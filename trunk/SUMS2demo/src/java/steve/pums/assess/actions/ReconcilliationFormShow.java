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
 * Generates a form for mark reconcilliation
 */
public class ReconcilliationFormShow extends PumsBaseAction {
    
    /** Creates a new instance of LoadMarkForm */
    public ReconcilliationFormShow()  {
        
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
        ReconciliationForm form = new ReconciliationForm();
        form.setMark(project.getMark());
        form.setReason("");
        
        su.setAttribute("projectbean",  project, StrutsUtils.SESSION_SCOPE);
        su.setAttribute("reconForm", form, StrutsUtils.REQUEST_SCOPE);
        
        saveToken(su.getRequest());
        
        return su.successOrFailure();
    }
    
}
