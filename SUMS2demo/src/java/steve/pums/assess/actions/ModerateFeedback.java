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
import steve.pums.assess.process.*;
import steve.pums.assess.bus.*;
import java.util.Iterator;
import jim.util.SqlUtils;

/**
 * Generates a form for project comment moderation
 */
public class ModerateFeedback extends PumsBaseAction {
    
    /** Creates a new instance of LoadMarkForm */
    public ModerateFeedback()  {
        
    }
    
    /**
     * Action Execution
     * @return ActionForward
     * @param su Jim App Struts Resources
     * @throws java.io.IOException IOException
     * @throws javax.servlet.ServletException ServletException
     * @throws jim.common.JimFatalException JimFatalException
     */
    public ActionForward doPumsExecute(StrutsUtils su) throws IOException, ServletException, JimFatalException {
        Project project = (Project)su.findAttribute("project");
        if (project == null) {
            return su.getMapping().findForward("restart");
        }
        SqlUtils sql = su.getSqlUtils();
        Iterator<String> iterator = project.getMarkers().keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            StaffBean value = (StaffBean)project.getMarkers().get(key);
            MarkFormBean markform = new MarkFormBean();
            MarkFormProcess mff = new MarkFormProcess(sql);
            try {
                markform = mff.readMarkFormForMarker(project, value.getID());
            } catch (java.sql.SQLException e) {
                throw new JimFatalException("Cannot retrieve mark form - database problem", e);
            } catch (java.text.ParseException e) {
                throw new JimFatalException("Parse error when loading mark form", e);
            }
            su.setAttribute(key+"markform", markform, StrutsUtils.SESSION_SCOPE);
        }
        su.closeConn();
        saveToken(su.getRequest());
        su.setAttribute("projectbean", project,   StrutsUtils.SESSION_SCOPE);
        return su.successOrFailure();
    }
    
}
