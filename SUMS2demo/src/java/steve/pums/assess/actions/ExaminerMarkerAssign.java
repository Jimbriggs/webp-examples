/*
 * SPAddProject.java
 *
 * Created on 23 July 2005, 10:22
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package steve.pums.assess.actions;

import jim.pums.actions.PumsBaseAction;
import jim.util.struts.*;
import jim.pums.assess.bus.*;
import jim.pums.assess.process.*;
import jim.common.JimFatalException;
import org.apache.struts.action.ActionForward;
import java.io.IOException;
import javax.servlet.ServletException;
import java.sql.Connection;
import steve.pums.assess.process.ProjectService;
import steve.pums.assess.bus.*;

/**
 * Assigns a staff member as examiner marker for a project
 * @author Steve Powell
 */
public class ExaminerMarkerAssign extends PumsBaseAction {
    
    /** Creates a new instance of SPAddProject */
    public ExaminerMarkerAssign() {
    }
    
    /**
     * Action Execution
     * @param su Jim App Struts Resources
     * @return ActionForward
     * @throws java.io.IOException IOException
     * @throws javax.servlet.ServletException ServletException
     * @throws jim.common.JimFatalException JimFatalException
     */
    public ActionForward doPumsExecute(StrutsUtils su) throws IOException, ServletException, JimFatalException {      
        if(isTokenValid(su.getRequest())) {          
            resetToken(su.getRequest());
            Project project = (Project)su.getRequest().getSession().getAttribute("project");
            UserBean user = (UserBean)su.getRequest().getSession().getAttribute("userbean");
            StaffBean examinermarker = (StaffBean)su.getForm();           
            try {
                Connection conn = su.getConn();
                su.beginTransaction();
                ProjectService projectservice = new ProjectService(conn);
                String assigned = projectservice.getCapacityAlreadyAssigned(examinermarker.getID(), project.getMarkers());
                if(assigned==null) {
                    project = projectservice.updateMarker(project, examinermarker.getID(), "Examiner");
                    project.setStatus("R3B");
                    projectservice.updateProjectStatus(project, user.getPersonID());
                } else {
                    su.getErrors().add("ID","marker.alreadyassigned",assigned);
                }
                su.setAttribute("project",  project,    StrutsUtils.SESSION_SCOPE);
                return su.endTransaction();
            } catch (java.sql.SQLException e) {
                throw new JimFatalException("Cannot register examiner marker - database problem", e);
            } catch (java.text.ParseException e) {
                throw new JimFatalException("Cannot parse project date", e);
            } catch (javax.mail.MessagingException e) {
                su.getErrors().addGlobal("markForm.emailfailure", "");
                return su.failure();
            } catch (java.lang.Exception e) {
                throw new JimFatalException("Lang error", e);
            }
        }
        return su.failure();
    }
    
}
