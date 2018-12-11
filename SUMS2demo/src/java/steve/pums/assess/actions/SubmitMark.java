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
import jim.common.JimFatalException;
import org.apache.struts.action.ActionForward;
import java.io.IOException;
import javax.servlet.ServletException;
import jim.util.SqlUtils;
import steve.pums.assess.process.*;
import steve.pums.assess.bus.*;


/**
 * Saves a project mark and processes status changes
 */
public class SubmitMark extends PumsBaseAction {
    
    /** Creates a new instance of LoadMarkForm */
    public SubmitMark()  {
        
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
            
            Project project = (Project)su.findAttribute("project");
            MarkFormBean markform = (MarkFormBean)su.findAttribute("markform");
            UserBean user = (UserBean)su.findAttribute("userbean");
            if (project == null || markform == null || user == null) {
                return su.getMapping().findForward("restart");
            }
            
            SqlUtils sql = su.getSqlUtils();
            su.beginTransaction();
            
            try {
                MarkFormProcess mfp = new MarkFormProcess(sql);
                project = mfp.processMarkForm(project, markform);
            } catch (java.sql.SQLException e) {
                throw new JimFatalException("Cannot process project mark - database problem", e);
            } catch (java.lang.Exception e) {
                throw new JimFatalException("Cannot process project mark", e);
            }
            
            try {
                ProjectService projectService = new ProjectService(sql);
                projectService.updateProjectStatus(project, user.getPersonID());
                //TODO: transaction ends here
                projectService.readProject(project);
            } catch (java.sql.SQLException e) {
                throw new JimFatalException("Problem updating project status - database problem", e);
            } catch (java.text.ParseException e) {
                throw new JimFatalException("Parse error", e);
            } catch (java.lang.Exception e) {
                throw new JimFatalException("Unknown error", e);
            }
            
            su.setAttribute("project",  project,    StrutsUtils.SESSION_SCOPE);
            
            su.getSession().removeAttribute("markform");
            su.getRequest().removeAttribute("markform");
        }
        
        return su.endTransaction();
    }
    
}
