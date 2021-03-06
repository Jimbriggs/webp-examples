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
 * Displays project mark and comments to the student
 */
public class StudentViewProject extends PumsBaseAction {
    
    /** Creates a new instance of LoadMarkForm */
    public StudentViewProject()  {
        
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
        su.getRequest().getSession().removeAttribute("project");
        StudentBean student = (StudentBean)su.findAttribute("studentbean");
        
        int projectid = Integer.parseInt(su.getRequest().getParameter("PROJECT").toString());
        Project project = new Project();
        project.setProjectID(projectid);
                
        try {
            Connection conn = su.getConn();
            ProjectService projectservice = new ProjectService(conn);
            projectservice.readProject(project);
            su.closeConn();
        } catch (java.sql.SQLException e) {
            throw new JimFatalException("Cannot load project - database problem", e);
        }
        
        if (student.getID() == project.getStudentID()) {
            su.setAttribute("project",  project,    StrutsUtils.SESSION_SCOPE);
            return su.success();
        } else {
            return su.failure();
        }
    }
}
