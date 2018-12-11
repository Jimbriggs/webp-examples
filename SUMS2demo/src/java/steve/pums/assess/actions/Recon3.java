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
 * Moves a project to the third stage of reconcilliation
 */
public class Recon3 extends PumsBaseAction {
    
    /** Creates a new instance of LoadMarkForm */
    public Recon3()  {
        
    }
    
    /**
     * Action Execution
     * @param su Jim App Struts Resources
     * @return ActionForward
     * @throws javax.servlet.ServletException ServletException
     * @throws java.io.IOException IOException
     * @throws jim.common.JimFatalException JimFatalException
     */
    public ActionForward doPumsExecute(StrutsUtils su) throws IOException, ServletException, JimFatalException {
        
        Project project = (Project)su.findAttribute("project");
        UserBean user = (UserBean)su.findAttribute("userbean");
        
        project.setStatus("R3A");
        
        try {
            Connection conn = su.getConn();
            su.beginTransaction();
            ProjectService projectService = new ProjectService(conn);
            projectService.updateProjectStatus(project,user.getPersonID());
            project = projectService.readProject(project);
            su.setAttribute("project",  project, StrutsUtils.SESSION_SCOPE);
            return su.endTransaction();
        } catch (java.sql.SQLException e) {
            throw new JimFatalException("Problem updating project status - database problem", e);
        } catch (java.text.ParseException e) {
            throw new JimFatalException("Parse error", e);
        } catch (java.lang.Exception e) {
            throw new JimFatalException("Lang error", e);
        }
    }
    
}
