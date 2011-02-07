/*
 * SPShowAllocations.java
 *
 * Created on 25 July 2005, 11:06
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package steve.pums.assess.actions;

import jim.pums.actions.PumsBaseAction;
import jim.util.struts.*;
import jim.pums.assess.bus.*;
import jim.common.JimFatalException;
import org.apache.struts.action.ActionForward;
import java.io.IOException;
import javax.servlet.ServletException;
import java.sql.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import steve.pums.assess.bus.*;
import steve.pums.assess.process.ProjectService;

/**
 * Retrieves list of the user's project allocations
 * @author Steve Powell
 */
public class ShowAllocations extends PumsBaseAction {
    
    /** Creates a new instance of SPShowAllocations */
    public ShowAllocations() {
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
            Connection conn = su.getConn();        
            ProjectService projectservice = new ProjectService(conn);
            ProjectFilter filter = new ProjectFilter();
            Set<Integer> people = new HashSet<Integer>();
            people.add(user.getPersonID());
            filter.addPeople(people);
            List<Project> allocations = projectservice.readProjectsByFilter(filter);
            su.setAttribute("allocations", allocations, StrutsUtils.REQUEST_SCOPE);             
            su.closeConn();
        } catch (java.sql.SQLException e) {
            throw new JimFatalException("Cannot show allocations - database problem", e);
        }
        return su.successOrFailure();
    }
    
}
