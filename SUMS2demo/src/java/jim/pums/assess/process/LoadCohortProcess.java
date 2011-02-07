/*
 * MarkFormProcess.java
 *
 * Created on 02 May 2005, 21:28
 */
package jim.pums.assess.process;

import java.io.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jim.common.JimFatalException;
import org.apache.commons.beanutils.BeanUtils;
import steve.pums.assess.bus.PersonBean;
import steve.pums.assess.bus.Project;
import steve.pums.assess.bus.StudentBean;
import steve.pums.assess.process.ProjectService;

/**
 *
 * @author  briggsj
 */
public class LoadCohortProcess {

    private ProjectService service = null;

    /** Creates a new instance of MarkFormProcess */
    public LoadCohortProcess(ProjectService service) {
        this.service = service;
    }

    private PersonBean readSupervisor(String line) {
        String[] fields = line.split(":", 4);
        PersonBean person = new PersonBean();
        if (fields[0].contains("@")) {
            //Username is an email address
            person.setSurname(fields[0]);
            person.setFirst_name("");
            String username = fields[0].substring(0, 15).split("@", 2)[0];
            person.setUser_name(username);
            person.setLongUserName(fields[0]);
        } else {
            String[] name = fields[0].split("\\.", 2);
            person.setUser_name(fields[0]);
            person.setLongUserName(fields[0]);
            person.setFirst_name(name[0]);
            person.setSurname(name[1]);
        }
        return person;
    }

    public List<String> loadStaff(InputStream in) throws JimFatalException {
        PersonBean person = null;
        List<String> msgs = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = br.readLine()) != null) {
                person = readSupervisor(line);
                List<String> emailAddresses = new ArrayList<String>();
                String username = person.getUser_name();
                if (!username.contains("@")) {
                    username += "@port.ac.uk";
                }
                emailAddresses.add(username);
                boolean added = service.addStaffPerson(person, emailAddresses);
                if (added) {
                    msgs.add("Added new member of staff: " + person.getName() + " (" + person.getUser_name() + ")");
                }
            }
        } catch (IOException e) {
            throw new JimFatalException("IOException reading supervisor file", e);
        } catch (SQLException e) {
            throw new JimFatalException("SQLException adding new staff member " + person.getName(), e);
        }
        return msgs;
    }
    static private Pattern studentPattern = Pattern.compile("^([^, ]+),?\\s+(.*)\\s+(\\d+)$");

    private StudentBean readStudent(String line) throws ParseException {
        String[] fields = line.split(":");

        Matcher m = studentPattern.matcher(fields[0]);
        if (!m.matches()) {
            throw new ParseException("Student name is not in correct format: " + fields[0], m.end());
        }
        
        StudentBean student = new StudentBean();
        student.setFirst_name(m.group(2));
//        if (name[0].endsWith(",")) {
//            name[0] = name[0].substring(0, name[0].length()-1);
//        }
        student.setSurname(m.group(1));
        student.setHemis(Integer.parseInt(m.group(3)));
        student.setDegreeStream(fields[1]);
        return student;
    }

    private Project readProject(String line) throws SQLException {
        String[] fields = line.split(":");
        Project project = new Project();
//        project.setUnitTxt(fields[2]);
        project.setUnitID(service.findUnitByName(fields[2]));
        if (fields[4].endsWith("%")) {
            fields[4] = fields[4].substring(0, fields[4].length() - 1);
        }
        project.setSupervisorID(service.findPersonIdByUser_name(fields[4]));
        if (fields[5].endsWith("%")) {
            fields[5] = fields[5].substring(0, fields[5].length() - 1);
        }
        project.setModeratorID(service.findPersonIdByUser_name(fields[5]));
        project.setTitle(fields[6]);
        project.setComments(fields[7]);
        return project;
    }

    public List<String> loadStudents(int cohortId, String cohortName, Date deadline, InputStream in) throws JimFatalException {
        List<String> msgs = new ArrayList<String>();
        PersonBean person = null;
        Project project = null;
        StudentBean student = null;

        if (cohortName.length() > 128) {
            throw new JimFatalException("Cohort name longer than 128 characters");
        }
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = br.readLine()) != null) {
                project = readProject(line);

                project.setCohortID(cohortId);
                project.setDatesubmitted(deadline);
                project.setLatehandin("N");

                student = readStudent(line);
                student.setFinal_year(cohortName);

                person = new PersonBean();
                BeanUtils.copyProperties(person, student);
                person.setUser_name(line.split(":")[15]);
                boolean added = service.addNewStudent(project, student, person);
                if (added) {
                    msgs.add("Added new student: " + person.getName() + " (" + person.getUser_name() + ")");
                }
            }
        } catch (IOException e) {
            throw new JimFatalException("IOException reading student file", e);
        } catch (SQLException e) {
            throw new JimFatalException("SQLException adding new student " + person.getName(), e);
        } catch (Exception e) {
            throw new JimFatalException("Exception adding new student " + person.getName(), e);
        }
        return msgs;
    }
}
