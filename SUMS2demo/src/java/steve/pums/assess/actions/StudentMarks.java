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
import steve.pums.assess.bus.*;

/**
 * Shows a list of projects the student can view marks for
 * @author Steve Powell
 */
public class StudentMarks extends PumsBaseAction {
    
    /** Creates a new instance of CalculateMark */
    public StudentMarks() {
    }
    
    /**
     * Action Execution
     * @throws javax.servlet.ServletException ServletException
     * @throws java.io.IOException IOException
     * @throws jim.common.JimFatalException JimFatalException
     * @return ActionForward
     * @param su Jim App Struts Resources
     */
    public ActionForward doPumsExecute(StrutsUtils su) throws IOException, ServletException, JimFatalException {
        
        StudentBean student = (StudentBean)su.getAttribute("studentbean",StrutsUtils.SESSION_SCOPE);  
                
        try {        
            Connection conn = su.getConn();        
            ProjectService projectservice = new ProjectService(conn);                          
            su.setAttribute("projects", projectservice.findProjectsByStudentId(student.getID()), StrutsUtils.REQUEST_SCOPE);             
            su.closeConn();
        } catch (java.sql.SQLException e) {
            throw new JimFatalException("Cannot load student projects - database problem", e);
        }
        return su.successOrFailure();
        
    }
    
    
}
