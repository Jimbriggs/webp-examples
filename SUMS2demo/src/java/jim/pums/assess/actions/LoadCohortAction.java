/*
 * LoadCohortAction.java
 *
 * Created on 15 September 2005, 14:31
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package jim.pums.assess.actions;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import javax.servlet.ServletException;
import jim.common.JimFatalException;
import jim.pums.PumsApp;
import jim.pums.actions.PumsBaseAction;
import jim.pums.assess.process.LoadCohortProcess;
import org.apache.struts.action.*;
import jim.util.struts.*;
import org.apache.struts.upload.FormFile;
import steve.pums.assess.process.ProjectService;

/**
 *
 * @author briggsj
 */
public class LoadCohortAction extends PumsBaseAction {
    
    /** Creates a new instance of LoadCohortAction */
    public LoadCohortAction() {
    }
    
    public ActionForward doPumsExecute(StrutsUtils su) throws IOException, ServletException, JimFatalException {
        ActionForward af;
        LoadCohortForm clf = (LoadCohortForm)su.getForm();
        String cohortName = clf.getCohort();
        int cohortId = clf.getCohortID();
        Date deadline = clf.getDeadline();
        FormFile studentFile = clf.getStudentFile();
        FormFile staffFile = clf.getStaffFile();
        JimActionErrors messages = su.getMessages();
        su.setAttribute("cohort.name", cohortName, su.SESSION_SCOPE);
        
        try {
            Connection conn = PumsApp.getInstance().getConnection();
            su.beginTransaction();
            
            ProjectService projectservice = new ProjectService(conn);
            //process staff file (without overwriting existing entries)
            LoadCohortProcess lcp = new LoadCohortProcess(projectservice);
            messages.add(lcp.loadStaff(staffFile.getInputStream()));
            
            //process student file
            messages.add(lcp.loadStudents(cohortId, cohortName, deadline, studentFile.getInputStream()));
            
            af = su.endTransaction();
            conn.close();
        } catch (java.sql.SQLException e) {
            throw new JimFatalException("Cannot register new project - database problem", e);
//        } catch (java.text.ParseException e) {
//            throw new JimFatalException("Cannot parse project date", e);
//        } catch (javax.mail.MessagingException e) {
//            su.getErrors().addGlobal("markForm.emailfailure", "");
        }
        
        return af;
    }
    
}
