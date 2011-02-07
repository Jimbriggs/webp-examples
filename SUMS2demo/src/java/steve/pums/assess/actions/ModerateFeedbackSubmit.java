/*
 * LoadMarkForm.java
 *
 * Created on 26 July 2005, 14:03
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
import steve.pums.assess.bus.*;
import java.lang.Integer;
import java.util.Vector;

/**
 * Updates project comments
 */
public class ModerateFeedbackSubmit extends PumsBaseAction {
    
    /** Creates a new instance of LoadMarkForm */
    public ModerateFeedbackSubmit()  {
        
    }
    
    /**
     * Action Execution
     * @param su Jim App Struts Resources
     * @throws java.io.IOException IOException
     * @throws javax.servlet.ServletException ServletException
     * @throws jim.common.JimFatalException JimFatalException
     * @return ActionForward
     */
    public ActionForward doPumsExecute(StrutsUtils su) throws IOException, ServletException, JimFatalException {
        String test = "";
        test = "ooh";
        
        if(isTokenValid(su.getRequest())) {
            resetToken(su.getRequest());
            Project project = (Project)su.findAttribute("projectbean");
            UserBean user = (UserBean)su.findAttribute("userbean");
            Connection conn = su.getConn();
            su.beginTransaction();
            try {
                ProjectService projectService = new ProjectService(conn);
                projectService.updateProjectStatus(project, user.getPersonID());
            } catch (java.sql.SQLException e) {
                throw new JimFatalException("Problem updating project status - database problem", e);
            } catch (java.text.ParseException e) {
                throw new JimFatalException("Parse error", e);
            } catch (java.lang.Exception e) {
                throw new JimFatalException("Lang error", e);
            }
            
            su.setAttribute("project",  project,    StrutsUtils.SESSION_SCOPE);
            
            su.getSession().removeAttribute("Supervisormarkform");
            su.getRequest().removeAttribute("Supervisormarkform");
            
            su.getSession().removeAttribute("Moderatormarkform");
            su.getRequest().removeAttribute("Moderatormarkform");
            
            su.getSession().removeAttribute("Thirdmarkform");
            su.getRequest().removeAttribute("Thirdmarkform");
            
            su.getSession().removeAttribute("Examinermarkform");
            su.getRequest().removeAttribute("Examinermarkform");
            return su.endTransaction();
        }
        return su.failure();
    }
    
}
