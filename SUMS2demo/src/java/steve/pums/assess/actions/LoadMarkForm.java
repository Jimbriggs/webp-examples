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
 * Loads a project mark form
 */
public class LoadMarkForm extends PumsBaseAction {
    
    /** Creates a new instance of LoadMarkForm */
    public LoadMarkForm()  {
        
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
        if (project == null) {
            return su.getMapping().findForward("sessionfail");
        }
        UserBean user = (UserBean)su.findAttribute("userbean");
        if (user == null) {
            return su.getMapping().findForward("restart");
        }
        
        SqlUtils sql = su.getSqlUtils();
        MarkFormBean markform = new MarkFormBean();
        MarkFormProcess mff = new MarkFormProcess(sql);
        
        try {
            markform = mff.readMarkFormForMarker(project, user.getPersonID());
        } catch (java.sql.SQLException e) {
            throw new JimFatalException("Cannot retrieve mark form - database problem", e);
        } catch (java.text.ParseException e) {
            throw new JimFatalException("Parse error when loading mark form", e);
        }
        
        markform.setMarkEnteredBy(user.getPersonID());
        
        Vector prizes = new Vector();
        
        try {
            prizes = (Vector)mff.readPrizes();
        } catch (java.sql.SQLException e) {
            throw new JimFatalException("Cannot retrieve prize list - database problem", e);
        }
        su.closeConn();
        
        su.setAttribute("project",  project,    StrutsUtils.SESSION_SCOPE);
        su.setAttribute("markform", markform,   StrutsUtils.SESSION_SCOPE);
        su.setAttribute("prizes",   prizes,     StrutsUtils.SESSION_SCOPE);
        
        final int session_timeout = 3 * 60 * 60; // 3 hours
        su.getSession().setMaxInactiveInterval(session_timeout);
        saveToken(su.getRequest());
        
        return su.successOrFailure();
    }
    
}
