/*
 * SPProjectService.java
 *
 * Created on 24 July 2005, 01:48
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */
package steve.pums.assess.process;

import java.sql.*;
import jim.util.SqlUtils;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Date;
import steve.pums.assess.bus.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.mail.MessagingException;
import jim.common.JimFatalException;
import org.apache.struts.util.LabelValueBean;

/**
 * Provides methods for the registration and mainteneance of student projects
 * @author Steve Powell
 */
public class ProjectService {

    /**
     * SUMS database connection
     */
//    private Connection conn = null;
    /**
     * Jim App SQL Utils
     */
    private SqlUtils sql = null;
    private EmailService email = null;

    /**
     * Creates a new instance of ProjectService
     * @param conn SUMS database connection
     */
    public ProjectService(SqlUtils sql) {
        this.sql = sql;
        email = new EmailService(sql);
    }

    public ProjectService(Connection conn) {
        sql = new SqlUtils(conn);
        email = new EmailService(sql);
    }

    /**
     * Returns all students for the project registration form
     * @return Collection of students
     * @throws java.sql.SQLException in the event of SQL errors
     */
    public List<StudentBean> getStudents() throws SQLException {
        List<StudentBean> students = new ArrayList<StudentBean>();
        String select = "SELECT P.PERSON_ID, P.FIRST_NAME, P.SURNAME, S.HEMIS_NO " +
                "FROM PERSON P, STUDENT S " +
                "WHERE S.PERSON_ID = P.PERSON_ID " +
                "AND P.INACTIVE IS NULL " +
                "ORDER BY S.HEMIS_NO, P.FIRST_NAME, P.SURNAME";
        ResultSet rs = sql.selectRS(select);
        while (rs.next()) {
            StudentBean stud = new StudentBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            students.add(stud);
        }
        rs.close();
        return students;
    }

//    /**
//     * Returns all cohorts for the project registration form
//     * @return Collection of cohorts
//     * @throws java.sql.SQLException in the event of SQL errors
//     */
//    public List<CohortBean> readAllCohorts() throws SQLException {
//        List<CohortBean> cohorts = new ArrayList<CohortBean>();
//        String select = "SELECT C.COHORT_ID, C.COHORT_DESCRIPTION, C.PROJECT_START_DATE, C.PROJECT_END_DATE, C.COHORT_CLOSED " +
//                "FROM COHORT C " +
//                "WHERE C.COHORT_CLOSED IS NULL " +
//                "ORDER BY C.PROJECT_END_DATE";
//        ResultSet rs = sql.selectRS(select);
//        while (rs.next()) {
//            CohortBean cohort = new CohortBean();
//            cohort.setID(rs.getInt(1));
//            cohort.setCohortDesc(rs.getString(2));
//            cohort.setStartDate(rs.getDate(3));
//            cohort.setEndDate(rs.getDate(4));
//            cohort.setClosed(false); //cos COHORT_CLOSED IS NOT NULL!
//            cohorts.add(cohort);
//        }
//        rs.close();
//        return cohorts;
//    }

    /**
     * Returns all units for the project registration form
     * @return Collection of units
     * @throws java.sql.SQLException in the event of SQL errors
     */
    public List<UnitBean> getUnits() throws SQLException {

        List<UnitBean> units = new ArrayList<UnitBean>();

        String select = "SELECT U.UNIT_ID, U.UNIT_CODE, U.UNIT_NAME " +
                "FROM UNIT U " +
                "WHERE U.ACADEMIC_YR_LAST_RUN IS NULL";

        ResultSet rs = sql.selectRS(select);

        while (rs.next()) {
            UnitBean unit = new UnitBean(rs.getInt(1), rs.getString(2), rs.getString(3));
            units.add(unit);
        }
        rs.close();

        return units;

    }

    /**
     * Returns all staff for the project registration form
     * @return Collection of staff
     * @throws java.sql.SQLException in the event of SQL errors
     */
    public List<StaffBean> getStaff() throws SQLException {

        List<StaffBean> staff = new ArrayList<StaffBean>();

        String select = "SELECT P.PERSON_ID, P.FIRST_NAME, P.SURNAME FROM PERSON P, STAFF S " + "WHERE S.PERSON_ID = P.PERSON_ID " + "AND P.INACTIVE IS NULL " + "ORDER BY P.SURNAME, P.FIRST_NAME";

        ResultSet rs = sql.selectRS(select);

        while (rs.next()) {
            StaffBean staffmem = new StaffBean(rs.getInt(1), rs.getString(2), rs.getString(3));
            staff.add(staffmem);
        }
        rs.close();

        return staff;
    }

    public int findPersonIdByName(String first_name, String surname) throws SQLException {
        if (allPersons == null) {
            allPersons = getPersons();
        }
        Iterator<PersonBean> it = allPersons.iterator();
        while (it.hasNext()) {
            PersonBean pb = it.next();
            if (pb.isSameName(first_name + " " + surname)) {
                return pb.getPerson_id();
            }
        }
        return -1;
    }

    public PersonBean findPersonByUser_name(String username) throws SQLException {
        if (allPersons == null) {
            allPersons = getPersons();
        }
        Iterator<PersonBean> it = allPersons.iterator();
        while (it.hasNext()) {
            PersonBean pb = it.next();
            if (pb.isSameUsername(username)) {
                return pb;
            }
        }
        return null;
    }

    public int findPersonIdByUser_name(String username) throws SQLException {
        PersonBean pb = findPersonByUser_name(username);
        if (pb == null) {
            return -1;
        } else {
            return pb.getPerson_id();
        }
    }

    public List<PersonBean> getPersons() throws SQLException {
        List<PersonBean> persons = new ArrayList<PersonBean>();

        String select = "SELECT P.PERSON_ID, P.FIRST_NAME, P.SURNAME, P.USER_NAME, P.PWD FROM PERSON P " + "WHERE P.INACTIVE IS NULL " + "ORDER BY P.SURNAME, P.FIRST_NAME";

        ResultSet rs = sql.selectRS(select);

        while (rs.next()) {
            PersonBean person = new PersonBean(rs.getInt(1), rs.getString(2), rs.getString(3));
            person.setUser_name(rs.getString(4));
            person.setPassword(rs.getString(5));
            person.setInactive(false);
            persons.add(person);
        }
        rs.close();

        return persons;
    }

    public int findPersonIdByHemis(int hemis) throws SQLException {
        String select = "SELECT P.PERSON_ID " +
                "FROM PERSON P, STUDENT S " +
                "WHERE S.PERSON_ID = P.PERSON_ID " +
                "AND S.HEMIS_NO = ? ";

        ResultSet rs = sql.selectRS(select, new Integer(hemis));

        Map<Integer, Integer> idFrequency = new HashMap<Integer, Integer>();
        Integer lastid = null;
        while (rs.next()) {
            lastid = rs.getInt(1);
            Integer lastCount = idFrequency.get(lastid);
            if (lastCount == null) {
                lastCount = new Integer(0);
                idFrequency.put(lastid, lastCount);
            }
            lastCount++;
        }
        if (idFrequency.size() == 1) {
            return lastid;
        } else if (idFrequency.size() > 1) {
            StringBuffer text = new StringBuffer();
            for (Integer i : idFrequency.keySet()) {
                text.append(" " + i + "(" + idFrequency.get(i) + ")");
            }
            throw new SQLException("Found multiple person records for HEMIS number " + hemis + ":" + text);
        } else {
            return -1;
        }

    }

    private boolean isAlreadyListed(PersonBean person) throws SQLException {
        return findPersonIdByUser_name(person.getUser_name()) != -1;
    }

    public Map<String, Integer> getRoles() throws SQLException {
        String select = "SELECT role_id, role_description FROM roles ORDER BY role_description";
        ResultSet rs = sql.selectRS(select);
        HashMap<String, Integer> roles = new HashMap<String, Integer>();
        while (rs.next()) {
            Integer id = rs.getInt(1);
            String desc = rs.getString(2);
            roles.put(desc, id);
        }
        rs.close();
        return roles;
    }

    public void insertPersonRole(int person_id, Integer role) throws SQLException {
        String insert = "INSERT INTO person_roles (role, person_id) VALUES (?, ?)";
        sql.doExecute(insert, new Object[]{role, sql.intParam(person_id)});
    }
    private List<PersonBean> allPersons = null;
    private Map<String, Integer> roles = null;

    public boolean addStaffPerson(PersonBean person, List<String> emails) throws SQLException {
        boolean added = false;

        if (allPersons == null) {
            allPersons = getPersons();
        }
        if (roles == null) {
            roles = getRoles();
        }

        int id = findPersonIdByUser_name(person.getUser_name());
        if (id == -1) {
            //Add to PERSON
            person = addPerson(person);
            //Add to STAFF
            String staffNo = insertStaff(null, person.getPerson_id());
            //Add appropriate roles to PERSON_ROLES
            insertPersonRole(person.getPerson_id(), roles.get("Staff"));
            insertPersonRole(person.getPerson_id(), roles.get("Marker"));

            allPersons = getPersons();  //update the list
            insertEmails(person.getPerson_id(), emails);
            added = true;
        } else {
            person.setPerson_id(id);
        }
        return added;
    }

    public boolean insertEmails(int person_id, List<String> emailAddresses) throws SQLException {
        boolean ok = false;
        String select = "SELECT E_MAIL_ID, PERSON_ID, E_MAIL_ADD, E_MAIL_SUSPENDED " +
                "FROM PERSON_EMAIL " +
                "WHERE PERSON_ID = ?";
        ResultSet rs = sql.selectRSmod(select, new Object[]{person_id});
        while (rs.next()) {
            rs.deleteRow();
        }
        Iterator<String> it = emailAddresses.iterator();
        while (it.hasNext()) {
            String email = it.next();
            rs.moveToInsertRow();
            int id = sql.nextval("PERSON_EMAIL_1");
            rs.updateInt(1, id);
            rs.updateInt(2, person_id);
            rs.updateString(3, email);
            rs.updateNull(4);
            rs.insertRow();
        }
        rs.close();
        return ok;
    }

    public String insertStaff(String staffNo, int person_id) throws SQLException {

        String insert = "INSERT INTO staff (staff_no, person_id) VALUES (?, ?)";
//                "SET "
//                + "staff_no = ?, "
//                + "person_id = ?";

        if (staffNo == null) {
            //assign new unique staff number
            //Since Person_IDs are unique, we can reuse that.
            staffNo = Integer.toString(person_id);
        }
        sql.doExecute(insert, new Object[]{
            staffNo,
            sql.intParam(person_id)
        });

        return staffNo;
    }

    public PersonBean addPerson(PersonBean person) throws SQLException {
        String insert = "INSERT INTO person " + "(person_id, user_name, first_name, surname, pwd, inactive) " + "VALUES (?, ?, ?, ?, ?, ?) ";
        person.setPerson_id(sql.nextval("PERSON_1"));
        //TODO: check that this id is unique
        String inactive = person.isInactive() ? "Y" : "";
        sql.doExecute(insert, new Object[]{
            sql.intParam(person.getPerson_id()),
            person.getUser_name(),
            person.getFirst_name(),
            person.getSurname(),
            person.getPassword(),
            new String(inactive)
        });
        return person;
    }

    public boolean addNewStudent(Project project, StudentBean student, PersonBean person) throws JimFatalException, SQLException, ParseException, MessagingException {
        if (allPersons == null) {
            allPersons = getPersons();
        }
        if (roles == null) {
            roles = getRoles();
        }

        //TODO find by HEMIS number first
        int id = findPersonIdByHemis(student.getHemis());
        if (id == -1) {
            //then by username
            id = findPersonIdByUser_name(person.getUser_name());
        }
        //TODO add check that username matches HEMIS number
        if (id == -1) {
            //Add to PERSON
            person = addPerson(person);
            allPersons = getPersons();  //update the list
        } else {
            person.setPerson_id(id);
        }
        project.setStudentID(person.getPerson_id());
        student = insertStudent(student, person.getPerson_id());
        project = insertFinalProject(project);

        // Insert the markers

        updateMarker(project, project.getSupervisorID(), "SUPERVISOR");
        updateMarker(project, project.getModerator(), "MODERATOR");
        project = readMarkers(project);
        project = readCoordinators(project);
        project = readProjectRelationships(project);

//        EmailService email = new EmailService(conn);
//        email.sendEmail(project.getMarkerIDs(),"PROJECTREADY",project.getProjectMap());

        return true;
    }

    public StudentBean insertStudent(StudentBean student, int personID) throws SQLException {
        String insert = "INSERT INTO student " +
                "(student_id, hemis_no, person_id, degree_stream, final_year) " +
                "VALUES (?, ?, ?, ?, ?)";
        student.setID(sql.nextval("STUDENT_1"));
        sql.doExecute(insert, new Object[]{
            student.getID(),
            sql.intParam(student.getHemis()),
            sql.intParam(personID),
            student.getDegreeStream(),
            student.getFinal_year()
        });
        return student;
    }
    /**
     * List of fields in FINAL_PROJECT table
     */
    static private final String projectFields =
            "project_id, " +
            "student_id, " +
            "cohort_id, " +
            "unit_id, " +
            "project_title, " +
            "project_submitted_date, " +
            "late_hand_in, " +
            "project_status, " +
            "project_mark, " +
            "project_comments, " +
            "recon_comments";

    /**
     * Registers a new project in the SUMS database
     * @param project the new project
     * @throws java.sql.SQLException in the event of SQL errors
     * @return project populated with marker and other related information
     * @throws java.text.ParseException in the event of date parsing error
     * @throws javax.mail.MessagingException As a result of error in sending emails
     * @throws jim.common.JimFatalException As a result of fatal exception
     */
    public Project insertFinalProject(Project project) throws SQLException, ParseException, javax.mail.MessagingException, jim.common.JimFatalException {

        String insert = "INSERT INTO FINAL_PROJECT " + "(" + projectFields + ") " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        project.setProjectID(sql.nextval("FINAL_PROJECT_1"));
        sql.doExecute(insert, new Object[]{
            sql.intParam(project.getProjectID()),
            sql.intParam(project.getStudentID()),
            sql.intParam(project.getCohortID()),
            sql.intParam(project.getUnitID()),
            sql.stringParam(project.getTitle(), 50),
            sql.dateParam(project.getDatesubmitted()),
            sql.stringParam(project.getLatehandin(), 1),
            sql.stringParam("A", 3),
            sql.intParam(project.getMark()),
            sql.clobParam(project.getComments()),
            sql.clobParam(project.getReconComments())
        });


        return project;
    }

    /**
     * Sets a person in a marking role for a specified project
     * @param project Project to assign marker to
     * @param person Person to assign as marker
     * @param type Role to assign marker to
     * @return Updated project
     * @throws java.sql.SQLException In the event of SQL errors
     * @throws javax.mail.MessagingException As a result of errors in sending emails
     * @throws java.text.ParseException As a result of date parsing error
     * @throws jim.common.JimFatalException As a result of fatal exception
     */
    public Project updateMarker(Project project, int person, String type) throws SQLException, ParseException, javax.mail.MessagingException, jim.common.JimFatalException {

        boolean sendmail = true;

        String select = "SELECT marker_capacity_id, project_id, marker_type_id, person_id, allocated_date, unallocated_date " +
                "FROM MARKER_CAPACITY " +
                "WHERE PROJECT_ID = ? " +
                "AND MARKER_TYPE_ID = ? " +
                "AND UNALLOCATED_DATE IS NULL";
        ResultSet rs = sql.selectRSmod(select, new Object[]{
            project.getProjectID(),
            readMarkerType(type)
        });

        if (!rs.next()) {
            rs.moveToInsertRow();
            rs.updateInt("PROJECT_ID", project.getProjectID());
            rs.updateInt("MARKER_TYPE_ID", readMarkerType(type));
            rs.updateInt("PERSON_ID", person);
            rs.updateDate("ALLOCATED_DATE", sql.dateParam(new Date()));
            rs.insertRow();

            if (!(type.equals("Third") || type.equals("Examiner"))) {
                sendmail = false;
            }
        } else {
            rs.updateDate("UNALLOCATED_DATE", sql.dateParam(new Date()));
            rs.updateRow();

            rs.moveToInsertRow();
            rs.updateInt("PROJECT_ID", project.getProjectID());
            rs.updateInt("MARKER_TYPE_ID", readMarkerType(type));
            rs.updateInt("PERSON_ID", person);
            rs.updateDate("ALLOCATED_DATE", sql.dateParam(new Date()));
            rs.insertRow();
        }

        rs.close();

        if (sendmail) {
            project = readMarkers(project);
//            EmailService email = new EmailService(conn);
            Map<String, Object> args = project.getProjectMap();
            args.put("ROLE", type);
            email.sendEmail(new int[]{person}, "MARKERALERT", args);
            email.sendEmail(project.getCoordAndMarkerIDs(), "MARKERCONF", args);
        }

        return project;

    }

    /**
     * Retrieves the ID of the marking capacity string
     * @param type String identifier of marking role e.g. Supervisor
     * @return ID of marker type
     * @throws java.sql.SQLException As a result of SQL errors
     */
    public int readMarkerType(String type) throws SQLException {

        String select = "SELECT MARKER_TYPE_ID FROM MARKER_TYPE " +
                "WHERE lower(marker_description) = lower(?)";
        Map markerType = sql.selectOne(select, new Object[]{type});
        return sql.num2int(markerType.get("MARKER_TYPE_ID"));
    }

    /**
     * Populates a Project with data retrieved from the SUMS database
     * @return Returns the populated project
     * @param project Project to be populated
     * @throws java.sql.SQLException As a result of SQL error
     */
    public Project readProject(Project project) throws SQLException {

        String select = "SELECT * FROM FINAL_PROJECT F, STATUSES S " +
                "WHERE F.PROJECT_ID = ? " +
                "AND F.PROJECT_STATUS = S.STATUS_CODE";

        ResultSet rs = sql.selectRS(select, new Object[]{project.getProjectID()});

        if (rs.next()) {
            project.setCohortID(rs.getInt("COHORT_ID"));
            project.setDatesubmitted(rs.getDate("PROJECT_SUBMITTED_DATE"));
            project.setLatehandin(rs.getString("LATE_HAND_IN"));
            project.setStudentID(rs.getInt("STUDENT_ID"));
            project.setTitle(rs.getString("PROJECT_TITLE"));
            project.setUnitID(rs.getInt("UNIT_ID"));
            project.setStatus(rs.getString("PROJECT_STATUS"));
            project.setStatusDesc(rs.getString("STATUS"));
            project.setMark(rs.getInt("PROJECT_MARK"));
            project.setComments(sql.getClobString(rs, "PROJECT_COMMENTS"));

            if (rs.next()) {
                throw new SQLException("More than 1 row returned from " + select);
            }
        } else {
            throw new SQLException("No row returned from " + select);
        }

        rs.close();

        project = readMarkers(project);
        project = readMarkerMarks(project);
        project = readCoordinators(project);
        project = readProjectRelationships(project);

        return project;

    }

    /**
     * Retrieves details of the project markers from the SUMS database
     * @param project Project to load markers for
     * @return Project with marker information populated
     * @throws java.sql.SQLException In the event of SQL errors
     */
    public Project readMarkers(Project project) throws SQLException {
        project.setMarkers(new HashMap<String, StaffBean>());
        String select = "SELECT T.MARKER_DESCRIPTION, P.PERSON_ID, P.FIRST_NAME, P.SURNAME " +
                "FROM PERSON P, FINAL_PROJECT F, MARKER_CAPACITY C, MARKER_TYPE T " +
                "WHERE F.PROJECT_ID = ? AND C.PROJECT_ID = F.PROJECT_ID " +
                "AND C.UNALLOCATED_DATE IS NULL " +
                "AND C.MARKER_TYPE_ID = T.MARKER_TYPE_ID " +
                "AND C.PERSON_ID = P.PERSON_ID " +
                "ORDER BY T.MARKER_TYPE_ID";

        ResultSet rs = sql.selectRS(select, new Object[]{
            project.getProjectID()
        });

        while (rs.next()) {
            project.addMarker(rs.getString(1), new StaffBean(rs.getInt(2), rs.getString(3), rs.getString(4)));
        }
        rs.close();
        return project;
    }

    /**
     * Loads details of the co-ordinators associated with the selected project
     * @param project Project to retrieve co-ordinators for
     * @return Project with co-ordinator details inserted
     * @throws java.sql.SQLException In the event of SQL errors
     */
    public Project readCoordinators(Project project) throws SQLException {
        project.setCoordinators(new ArrayList<StaffBean>());
        String select = "SELECT P.PERSON_ID, P.FIRST_NAME, P.SURNAME " +
                "FROM PERSON P, COHORT_COORDINATORS C " +
                "WHERE C.COHORT_ID = ? " +
                "AND C.PERSON_ID = P.PERSON_ID " +
                "ORDER BY P.SURNAME, P.FIRST_NAME";

        ResultSet rs = sql.selectRS(select, new Object[]{
            project.getCohortID()
        });

        while (rs.next()) {
            project.addCoordinator(new StaffBean(rs.getInt(1), rs.getString(2), rs.getString(3)));
        }
        rs.close();
        return project;
    }

    /**
     * Loads text descriptions associted with student, cohort and unit
     * @param project Project to populate text fields for
     * @return Project with populated text fields
     * @throws java.sql.SQLException In the event of SQL errors
     */
    private Project readProjectRelationships(Project project) throws SQLException {
        project.setStudent(findStudentById(project.getStudentID()));
        project.setCohort(findCohortById(project.getCohortID()));
        project.setUnit(findUnitById(project.getUnitID()));
        return project;
    }

    /**
     * Retrieves the student text field of the Project
     * @param studentid ID of student
     * @return Name of student
     * @throws java.sql.SQLException In the event of SQL errors
     */
    public StudentBean findStudentById(int studentid) throws SQLException {

        String select = "SELECT P.PERSON_ID, P.FIRST_NAME, P.SURNAME, S.HEMIS_NO " +
                "FROM PERSON P, STUDENT S " +
                "WHERE P.PERSON_ID = ? " +
                "AND P.PERSON_ID = S.PERSON_ID";
        Map student = sql.selectOne(select, new Object[]{studentid});
        if (student != null) {
            StudentBean stud = new StudentBean(
                    sql.num2int(student.get("PERSON_ID")),
                    (String) student.get("FIRST_NAME"),
                    (String) student.get("SURNAME"),
                    sql.num2int(student.get("HEMIS_NO")));
            return stud;
        } else {
            return null;
        }
    }

    /**
     * Retrieves the student text field of the Project
     * @param unitid ID of unit
     * @return Name of project unit
     * @throws java.sql.SQLException In the event of SQL errors
     */
    public UnitBean findUnitById(int unitid) throws SQLException {
        String select = "SELECT U.UNIT_ID, U.UNIT_CODE, U.UNIT_NAME " +
                "FROM UNIT U " +
                "WHERE U.UNIT_ID = ?";
        Map unit = sql.selectOne(select, new Object[]{unitid});
        if (unit != null) {
            UnitBean unt = new UnitBean(sql.num2int(unit.get("UNIT_ID")), (String) unit.get("UNIT_CODE"), (String) unit.get("UNIT_NAME"));
            return unt;
        } else {
            return null;
        }

    }

    /**
     * Retrieves the cohort text field of the Project
     * @param cohortid ID of the cohort
     * @return Name of the cohort
     * @throws java.sql.SQLException In the event of SQL errors
     */
    private CohortBean findCohortById(int cohortid) throws SQLException {
        String select = "SELECT C.COHORT_ID, C.COHORT_DESCRIPTION, C.PROJECT_START_DATE, C.PROJECT_END_DATE, C.COHORT_CLOSED " +
                "FROM COHORT C " +
                "WHERE C.COHORT_ID = ?";
        Map map = sql.selectOne(select, new Object[]{cohortid});
        if (map != null) {
            CohortBean cohort = new CohortBean();
            cohort.setID(sql.num2int(map.get("COHORT_ID")));
            cohort.setCohortDesc((String) map.get("COHORT_DESCRIPTION"));
            cohort.setStartDate((Date) map.get("PROJECT_START_DATE"));
            cohort.setEndDate((Date) map.get("PROJECT_END_DATE"));
            cohort.setClosed(("Y".equalsIgnoreCase((String) map.get("COHORT_CLOSED"))));
            return cohort;
        } else {
            return null;
        }
    }

    /**
     * Saves changes in the project status (status code, mark and comments)
     * @param project Project to save status for
     * @param userid User triggering state change
     * @throws java.sql.SQLException In the event of SQL errors
     * @throws java.text.ParseException In the event of date parsing errors
     * @throws java.lang.Exception In the event of errors in sending emails
     */
    public void updateProjectStatus(Project project, int userid) throws SQLException, ParseException, java.lang.Exception {

        boolean statuschange = false;

        String select = "SELECT " + projectFields + " FROM FINAL_PROJECT " +
                "WHERE PROJECT_ID = ?";

        project.setStatusDesc(readStatusDesc(project.getStatus()));

        ResultSet rs = sql.selectRSlock(select, new Object[]{
            project.getProjectID()
        });
        rs.first();

        // logger stuff goes here
        LoggerService logger = new LoggerService(sql);

        if (!(sql.getClobString(rs, "PROJECT_COMMENTS").equals(project.getComments()))) {
            logger.log(userid, project.getProjectID(), "Final Project Comments", sql.getClobString(rs, "PROJECT_COMMENTS"), project.getComments());
            statuschange = true;
        }
        if (!(sql.getClobString(rs, "RECON_COMMENTS").equals(project.getReconComments()))) {
            logger.log(userid, project.getProjectID(), "Reconciliation Comments", sql.getClobString(rs, "RECON_COMMENTS"), project.getReconComments());
            statuschange = true;
        }
        if ((rs.getInt("PROJECT_MARK") != project.getMark())) {
            logger.log(userid, project.getProjectID(), "Final Project Mark", String.valueOf(rs.getInt("PROJECT_MARK")), String.valueOf(project.getMark()));
            statuschange = true;
        }
        if (!(rs.getString("PROJECT_STATUS").equals(project.getStatus()))) {
            logger.log(userid, project.getProjectID(), "Project Status", readStatusDesc(rs.getString("PROJECT_STATUS")), project.getStatusDesc());
            statuschange = true;

            if (project.getStatus().equals("R1A")) {
                email.sendEmail(project.getCoordAndMarkerIDs(), "RECONNEEDED", project.getProjectMap());
            }
            if (project.getStatus().equals("R2A")) {
                email.sendEmail(project.getCoordinatorIDs(), "THIRDNEEDED", project.getProjectMap());
            }
            if (project.getStatus().equals("R3A")) {
                email.sendEmail(project.getCoordinatorIDs(), "EXAMNEEDED", project.getProjectMap());
            }
            if (project.getStatus().equals("C")) {
                email.sendEmail(new int[]{sql.intParam(project.getStudentID())}, "CONFALERT", project.getProjectMap());
            }

        }
        // end of logger stuff

//        if (statuschange) {
        //TODO: address whether this message needs to be sent
//            email.sendEmail(project.getCoordAndMarkerIDs(),"STATUSCHANGE",project.getProjectMap());
//        }
        /* TODO Need to ensure that confirmatory email messages are only sent if the database commits
         * and that a negative email might need to be sent if the database rolls back
         */


        rs.updateString("PROJECT_STATUS", project.getStatus());
        rs.updateInt("PROJECT_MARK", project.getMark());
        sql.setClobString(rs, "PROJECT_COMMENTS", project.getComments());
        sql.setClobString(rs, "RECON_COMMENTS", project.getReconComments());
        rs.updateRow();

        rs.close();
    }

    /**
     * Loads the string associated with a project status code
     * @param code Project status code
     * @return Project status string
     * @throws java.sql.SQLException As a result of errors in SQL
     */
    private String readStatusDesc(String code) throws SQLException {

        String select = "SELECT STATUS FROM STATUSES WHERE STATUS_CODE = ?";

        Map status = sql.selectOne(select, new Object[]{code});

        if (status != null) {
            return (String) status.get("STATUS");
        } else {
            return null;
        }
    }

    /**
     * Checks if a person is assigned to a Project as a marker
     * @param newmarker ID of new marker
     * @param markers Map of existing markers
     * @return String of current capacity if marker already assigned, otherwise null
     */
    public String getCapacityAlreadyAssigned(int newmarker, Map<String, StaffBean> markers) {

       // for (Iterator iter = markers.entrySet().iterator(); iter.hasNext();) {
        for (Map.Entry<String, StaffBean> entry : markers.entrySet()) {
        //   Map.Entry entry = (Map.Entry) iter.next();
            String capacity = entry.getKey();
            StaffBean marker = entry.getValue();

            if (marker.getID() == newmarker) {
                return capacity;
            }
        }

        return null;

    }

    /**
     * Loads marks associated to project
     * @return Returns Project with marker marks populated
     * @param project Project to load marks for
     * @throws java.sql.SQLException In the event of SQL errors
     */
    private Project readMarkerMarks(Project project) throws SQLException {

        MarkFormProcess mfp = new MarkFormProcess(sql);
        project.setMarkermarks(mfp.readMarkerMarksByProjectId(project.getProjectID()));

        return project;

    }

    /**
     * Searches the projects held in the SUMS database associated with a particular staff member
     * @param person The ID of the staff member to retrieve marking allocations for
     * @return List of Projects allocated to the staff member
     * @throws java.sql.SQLException in the event of SQL errors
     */
    public List<Project> readProjectsByMarkerId(int person) throws SQLException {
        List<Project> allocations = new ArrayList<Project>();
        String select = "SELECT P.PROJECT_ID " +
                "FROM FINAL_PROJECT P, MARKER_CAPACITY M " +
                "WHERE M.PERSON_ID = ? AND M.UNALLOCATED_DATE IS NULL " +
                "AND M.PROJECT_ID = P.PROJECT_ID AND P.PROJECT_STATUS <> 'X' " +
                //Fix for issue SUMS-15
                "ORDER BY P.COHORT_ID desc";
        ResultSet rs = sql.selectRS(select, new Object[]{person});
        while (rs.next()) {
            Project allocation = new Project();
            allocation.setProjectID(rs.getInt(1));
            allocation = readProject(allocation);
            allocations.add(allocation);
        }
        rs.close();
        return allocations;
    }

    /**
     * Searches the projects held in the SUMS database that match the specified filter
     * @return List of Projects matching the filter
     * @param filter Details to filter by
     * @throws java.sql.SQLException in the event of SQL errors
     */
    public List<Project> readProjectsByFilter(ProjectFilter filter) throws SQLException {
        List<Project> projlist = new ArrayList<Project>();
        String where = filter.getResult().getWhere().toString();
        List args = filter.getResult().getArgs();
        String select = "SELECT DISTINCT P.PROJECT_ID " +
                "FROM FINAL_PROJECT P, MARKER_CAPACITY M, COHORT C " +
                "WHERE M.UNALLOCATED_DATE IS NULL " +
                "AND M.PROJECT_ID = P.PROJECT_ID " +
                "AND C.COHORT_ID = P.COHORT_ID " +
                "AND P.PROJECT_STATUS <> 'X' " +
                ((where == null || where.length() == 0) ? "" : (" AND " + where));
        ResultSet rs = sql.selectRS(select, args);
        while (rs.next()) {
            Project allocation = new Project();
            allocation.setProjectID(rs.getInt(1));
            allocation = readProject(allocation);
            projlist.add(allocation);
        }
        rs.close();
        return projlist;
    }

    /**
     * Searches the projects held in the SUMS database that match the specified filter
     * @return List of Projects matching the filter
     * @param filter Details to filter by
     * @throws java.sql.SQLException in the event of SQL errors
     */
    public List<Project> readUnmarkedProjects() throws SQLException {
        List<Project> projlist = new ArrayList<Project>();
        String where = "NOT (PROJECT_STATUS IN ('SM', 'C', 'R1M', 'R2M', 'R3M', 'NS')) AND NOT (UNIT_ID IN (1,3,6))";
        String select = "SELECT DISTINCT P.PROJECT_ID " +
                "FROM FINAL_PROJECT P, MARKER_CAPACITY M " +
                "WHERE M.UNALLOCATED_DATE IS NULL " +
                "AND M.PROJECT_ID = P.PROJECT_ID " +
                "AND P.PROJECT_STATUS <> 'X' " +
                ((where == null || where.length() == 0) ? "" : (" AND ( " + where + ")"));
        ResultSet rs = sql.selectRS(select);
        while (rs.next()) {
            Project allocation = new Project();
            allocation.setProjectID(rs.getInt(1));
            allocation = readProject(allocation);
            projlist.add(allocation);
        }
        rs.close();
        return projlist;
    }

    /**
     * Used to retrieve all projects assocaited with a particular student
     * @param student ID of student
     * @return List of student projects
     * @throws java.sql.SQLException As a result of SQL errors
     */
    public List<Project> findProjectsByStudentId(int student) throws SQLException {
        List<Project> projects = new ArrayList<Project>();
        String select = "SELECT P.PROJECT_ID FROM FINAL_PROJECT P WHERE P.STUDENT_ID = ? AND P.PROJECT_STATUS ='C'";
        ResultSet rs = sql.selectRS(select, new Object[]{student});
        while (rs.next()) {
            Project project = new Project();
            project.setProjectID(rs.getInt(1));
            project = readProject(project);
            projects.add(project);
        }
        rs.close();
        return projects;
    }

    public List<LabelValueBean> findAllUnitsAsLVB() throws SQLException {
        List<LabelValueBean> list = new ArrayList<LabelValueBean>();
        if (allunits == null) {
            allunits = findAllUnitsAsMap();
        }
        Set<String> keys = allunits.keySet();
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            Integer value = allunits.get(key);
            LabelValueBean bean = new LabelValueBean(key, value.toString());
            list.add(bean);
        }
        return list;
    }

    public List<LabelValueBean> findCohortsLVB() throws SQLException {
        List<CohortBean> cohorts = findAllCohorts();
        List<LabelValueBean> list = new ArrayList<LabelValueBean>();
        for (Iterator<CohortBean> it = cohorts.iterator(); it.hasNext();) {
            CohortBean cb = it.next();
            LabelValueBean lvb = new LabelValueBean(cb.getCohortDesc(), Integer.toString(cb.getID()));
            list.add(lvb);
        }
        return list;
    }

    public List<CohortBean> findAllCohorts() throws SQLException {
        List<CohortBean> list = new ArrayList<CohortBean>();
        String select = "SELECT cohort_id, cohort_description, project_start_date, project_end_date, cohort_closed FROM cohort";
        ResultSet rs = sql.selectRS(select);
        while (rs.next()) {
            CohortBean cb = new CohortBean();
            cb.setID(rs.getInt(1));
            cb.setCohortDesc(rs.getString(2));
            cb.setStartDate(rs.getDate(3));
            cb.setEndDate(rs.getDate(4));
            cb.setClosed(rs.getString(5) == null ? false : rs.getString(5).equalsIgnoreCase("y"));
            list.add(cb);
        }
        rs.close();
        return list;
    }

    public Map<String, Integer> findAllUnitsAsMap() throws SQLException {
        Map<String, Integer> map = new HashMap<String, Integer>();
        String select = "SELECT unit_id, unit_code FROM unit";
        ResultSet rs = sql.selectRS(select);
        while (rs.next()) {
            map.put(rs.getString(2), rs.getInt(1));
        }
        rs.close();
        return map;
    }
    static private Map<String, Integer> allunits = null;

    public int findUnitByName(String unitname) throws SQLException {
        if (allunits == null) {
            allunits = findAllUnitsAsMap();
        }
        Integer n = allunits.get(unitname);
        if (n == null) {
            return -1;
        } else {
            return n;
        }
    }
}
