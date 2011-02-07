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
 * Assigns staff member as project third marker
 * @author Steve Powell
 */
public class ThirdMarkerAssign extends PumsBaseAction {
    
    /** Creates a new instance of SPAddProject */
    public ThirdMarkerAssign() {
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
            StaffBean thirdmarker = (StaffBean)su.getForm();
            UserBean user = (UserBean)su.getRequest().getSession().getAttribute("userbean");
            
            try {
                Connection conn = su.getConn();
                su.beginTransaction();
                ProjectService projectservice = new ProjectService(conn);
                String assigned = projectservice.getCapacityAlreadyAssigned(thirdmarker.getID(), project.getMarkers());
                if(assigned == null) {
                    project = projectservice.updateMarker(project, thirdmarker.getID(), "Third");
                    project.setStatus("R2B");
                    projectservice.updateProjectStatus(project, user.getPersonID());
                    
                } else {
                    su.getErrors().add("ID","marker.alreadyassigned",assigned);
                }
                su.setAttribute("project",  project,    StrutsUtils.SESSION_SCOPE);
                return su.endTransaction();
            } catch (java.sql.SQLException e) {
                throw new JimFatalException("Cannot register third marker - database problem", e);
            } catch (java.text.ParseException e) {
                throw new JimFatalException("Cannot parse project date", e);
            } catch (javax.mail.MessagingException e) {
                su.getErrors().addGlobal("markForm.emailfailure", "");
            } catch (java.lang.Exception e) {
                throw new JimFatalException("Lang error", e);
            }
        }
        return su.failure();
    }

    private javax.sql.DataSource getSums29() throws javax.naming.NamingException {
        javax.naming.Context c = new javax.naming.InitialContext();
        return (javax.sql.DataSource) c.lookup("java:comp/env/jdbc/sums29");
    }
    
}
