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
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import jim.util.RequestUtils;
import jim.util.SqlUtils;
import steve.pums.assess.bus.*;
import steve.pums.assess.process.ProjectService;

/**
 * Retrieves list of the user's project allocations
 * @author Steve Powell
 */
public class ShowProjects extends PumsBaseAction {

    /** Creates a new instance of SPShowAllocations */
    public ShowProjects() {
    }

//    static private final SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
    /**
     * Action Execution
     * @param su Jim App Struts Resources
     * @return ActionForward
     * @throws java.io.IOException IOException
     * @throws javax.servlet.ServletException ServletException
     * @throws jim.common.JimFatalException JimFatalException
     */
    public ActionForward doPumsExecute(StrutsUtils su) throws IOException, ServletException, JimFatalException {
        UserBean user = (UserBean) su.getAttribute("userbean", StrutsUtils.SESSION_SCOPE);
        ProjectFilter filter = new ProjectFilter(); // su.getForm();
        
        //Get months parameter and add to filter
        final int DEFAULT_MONTHS = 3;
        int months = RequestUtils.getParameter(su.getRequest(), "months", DEFAULT_MONTHS);

        Calendar monthsAgo = new GregorianCalendar(); // today
        monthsAgo.add(Calendar.MONTH, -months);
        Calendar inMonths = new GregorianCalendar();
        inMonths.add(Calendar.MONTH, months);
        filter.setDateRangeStart(monthsAgo.getTime()); //df.parse("20070101"));
        filter.setDateRangeFinish(inMonths.getTime()); //df.parse("20070930"));

        //Get person parameter and add to filter
        int person = RequestUtils.getParameter(su.getRequest(), "person", user.getPersonID());
        if (person != 0) {
            Set<Integer> people = new HashSet<Integer>();
            people.add(person);
            filter.addPeople(people);
        }

        //Get status parameter and add to filter
        String status = RequestUtils.getParameter(su.getRequest(), "status", "");
        filter.setStatus(status);
        
        try {
            SqlUtils sql = su.getSqlUtils();
            ProjectService projectservice = new ProjectService(sql);
            List<Project> allocations = projectservice.readProjectsByFilter(filter);
            Collections.sort(allocations);
            su.setAttribute("allocations", allocations, StrutsUtils.REQUEST_SCOPE);
            su.closeConn();
        } catch (java.sql.SQLException e) {
            throw new JimFatalException("Cannot list projects - database problem", e);
        }
        return su.successOrFailure();
    }
}
