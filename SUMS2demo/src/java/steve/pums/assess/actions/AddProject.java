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
import steve.pums.assess.bus.Project;

/**
 * Generates the form for registration of student projects
 * @author Steve Powell
 */
public class AddProject extends PumsBaseAction {
    
    /** Creates a new instance of SPAddProject */
    public AddProject() {
    }
    
    /**
     * Action execution
     * @param su Jim App Struts Resources
     * @throws java.io.IOException IO Exception
     * @throws javax.servlet.ServletException Servlet Exception
     * @throws jim.common.JimFatalException Jim Fatal Exception
     * @return ActionForward
     */
    public ActionForward doPumsExecute(StrutsUtils su) throws IOException, ServletException, JimFatalException {
        
        su.getRequest().getSession().removeAttribute("projectbean");
        
        Project projectbean =  new Project();
        
        try {
            Connection conn = su.getConn();
            ProjectService projectservice = new ProjectService(conn);
            su.setAttribute("projectbean",  projectbean,                    StrutsUtils.SESSION_SCOPE);
            su.setAttribute("students",     projectservice.getStudents(),   StrutsUtils.SESSION_SCOPE);
            su.setAttribute("cohorts",      projectservice.findAllCohorts(),    StrutsUtils.SESSION_SCOPE);
            su.setAttribute("units",        projectservice.getUnits(),      StrutsUtils.SESSION_SCOPE);
            su.setAttribute("staff",        projectservice.getStaff(),      StrutsUtils.SESSION_SCOPE);
            su.closeConn();
        } catch (java.sql.SQLException e) {
            throw new JimFatalException("Cannot get project dropdowns - database problem", e);
        }
        saveToken(su.getRequest());
        return su.successOrFailure();
    }
    
}
