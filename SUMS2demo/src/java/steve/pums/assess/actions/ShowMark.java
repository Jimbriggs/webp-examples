/*
 * CalculateMark.java
 *
 * Created on 31 July 2005, 23:24
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package steve.pums.assess.actions;

import jim.pums.actions.PumsBaseAction;
import jim.util.struts.*;
import jim.common.JimFatalException;
import org.apache.struts.action.ActionForward;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import steve.pums.assess.bus.MarkFormBean;
import steve.pums.assess.process.ProjectService;
import steve.pums.assess.bus.Project;
import steve.pums.assess.process.MarkFormProcess;

/**
 * Checks that mark form has not already been submitted
 * @author Steve Powell
 */
public class ShowMark extends PumsBaseAction {
    
    /** Creates a new instance of CalculateMark */
    public ShowMark() {
    }
    
    /**
     * Action execution
     * @return ActionForward
     * @throws java.io.IOException IOException
     * @throws javax.servlet.ServletException ServletException
     * @throws jim.common.JimFatalException JimFatalException
     * @param su Jim App Struts Resources
     */
    public ActionForward doPumsExecute(StrutsUtils su) throws IOException, ServletException, JimFatalException {
        try {
            su.getSession().removeAttribute("project");
            int projectid = Integer.parseInt(su.getRequest().getParameter("PROJECT").toString());
            int markerid = Integer.parseInt(su.getRequest().getParameter("MARKER").toString());
            Project project = new Project();
            project.setProjectID(projectid);
            
            Connection conn = su.getConn();
            ProjectService projectservice = new ProjectService(conn);
            projectservice.readProject(project);
            su.setAttribute("project",  project,    StrutsUtils.SESSION_SCOPE);
            
            MarkFormBean markform = new MarkFormBean();
            MarkFormProcess mff = new MarkFormProcess(su.getSqlUtils());
            
            markform = mff.readMarkFormForMarker(project, markerid);
            su.setAttribute("markform", markform,   StrutsUtils.SESSION_SCOPE);
//            su.setAttribute("prizes",   prizes,     StrutsUtils.SESSION_SCOPE);
            su.closeConn();
        } catch (java.sql.SQLException e) {
            throw new JimFatalException("Cannot load project - database problem", e);
        } catch (java.text.ParseException e) {
            throw new JimFatalException("Cannot load project - parameter parsing problem", e);
        }
        return su.successOrFailure();
    }
    
    
}
