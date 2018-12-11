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
 * Checks that mark form has not already been submitted
 * @author Steve Powell
 */
public class CalculateMark extends PumsBaseAction {
    
    /** Creates a new instance of CalculateMark */
    public CalculateMark() {
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
        
        if(isTokenValid(su.getRequest())) {
            return su.success();
        } else {
            return su.failure();
        }
        
    }
    
    
}
