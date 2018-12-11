/*
 * registerProject.java
 *
 * Created on 23 July 2005, 14:19
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package steve.pums.assess.actions;

/**
 *
 * @author Steve Powell
 */

import jim.pums.actions.PumsBaseAction;
import jim.util.struts.*;
import jim.pums.assess.bus.*;
import jim.common.JimFatalException;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionErrors;
import java.io.IOException;
import javax.servlet.ServletException;
import java.sql.Connection;
import steve.pums.assess.process.*;
import steve.pums.assess.bus.Project;

/**
 * Initiates addition of a new project to the SUMS database
 */
public class RegisterProject extends PumsBaseAction {
    
    /** Creates a new instance of registerProject */
    public RegisterProject() {
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
            Project project = (Project)su.getForm();
            try {
                Connection conn = su.getConn();
                su.beginTransaction();
                ProjectService projectservice = new ProjectService(conn);
                project = projectservice.insertFinalProject(project);
                return su.endTransaction();
            } catch (java.sql.SQLException e) {
                throw new JimFatalException("Cannot register new project - database problem", e);
            } catch (java.text.ParseException e) {
                throw new JimFatalException("Cannot parse project date", e);
            } catch (javax.mail.MessagingException e) {
                su.getErrors().addGlobal("markForm.emailfailure", "");
            }
        }
        return su.successOrFailure();
    }
    
}
