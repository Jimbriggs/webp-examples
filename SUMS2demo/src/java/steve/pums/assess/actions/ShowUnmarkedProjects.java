/*
 * ShowProjects.java
 *
 * Created on 10 October 2005, 11:06
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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.servlet.ServletException;
import jim.util.SqlUtils;
import steve.pums.assess.bus.*;
import steve.pums.assess.process.ProjectService;

/**
 * Retrieves list of the user's project allocations
 * @author Steve Powell
 */
public class ShowUnmarkedProjects extends PumsBaseAction {
    
    /** Creates a new instance of SPShowAllocations */
    public ShowUnmarkedProjects() {
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
        UserBean user = (UserBean)su.getAttribute("userbean", StrutsUtils.SESSION_SCOPE);

        try {
            SqlUtils sql = su.getSqlUtils();
            ProjectService projectservice = new ProjectService(sql);
            List<Project> allocations = projectservice.readUnmarkedProjects();
            Collections.sort(allocations);
            su.setAttribute("allocations", allocations, StrutsUtils.REQUEST_SCOPE);
            su.closeConn();
        } catch (java.sql.SQLException e) {
            throw new JimFatalException("Cannot list projects - database problem", e);
        }
        return su.successOrFailure();
    }
    
}
