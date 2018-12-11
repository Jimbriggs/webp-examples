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
import java.util.Vector;
import jim.util.SqlUtils;

/**
 * Displays project audit trail
 */
public class ViewAudit extends PumsBaseAction {
    
    /** Creates a new instance of LoadMarkForm */
    public ViewAudit()  {
        
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
        Project project = (Project)su.getRequest().getSession().getAttribute("project");
        UserBean user = (UserBean)su.getRequest().getSession().getAttribute("userbean");
        
        SqlUtils sql = su.getSqlUtils();
        Vector audit = new Vector();
        try {
            LoggerService logger = new LoggerService(sql);
            audit = logger.getAudit(project.getProjectID());
            su.closeConn();
        } catch (java.sql.SQLException e) {
            throw new JimFatalException("Cannot retrieve project audit - database problem", e);
        }
        su.setAttribute("audit", audit, StrutsUtils.REQUEST_SCOPE);        
        return su.successOrFailure();
    }
    
}
