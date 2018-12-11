/*
 * GenForm.java
 *
 * Created on 01 March 2005, 11:38
 */

package jim.pums.assess.actions;

import java.io.IOException;
import javax.servlet.ServletException;
import jim.common.JimFatalException;
import jim.pums.actions.PumsBaseAction;
import jim.pums.assess.*;
import jim.pums.assess.bus.*;
import jim.util.struts.StrutsUtils;
import org.apache.struts.action.*;
import org.apache.struts.validator.DynaValidatorForm;

/**
 *
 * @author  briggsj
 */
public class GenFormAction extends PumsBaseAction {
    
    /** Creates a new instance of GenForm */
    public GenFormAction() {
    }
    
    public ActionForward doPumsExecute(StrutsUtils su) throws IOException, ServletException, JimFatalException {

        // Load form data        
        AssessStudentForm form = (AssessStudentForm)su.getForm();
        
        // Extract student name & unit from form
        String studentName = form.getStudentName();
        String unit = form.getUnit();
        
        ProjectMarkFactory pmf = new ProjectMarkFactory();
        
        // Check that the unit exists
        if (pmf.isValidUnit(unit)) {
            AnyProjectMark mark = pmf.createProjectMark(unit);
            mark.setStudent(form);
            su.setAttribute("markForm", mark, StrutsUtils.SESSION_SCOPE);
            final int session_timeout = 3 * 60 * 60; // 3 hours
            su.getRequest().getSession().setMaxInactiveInterval(session_timeout);
        } else {
            su.getErrors().add("unit", "pums.errors.unit", unit);
        }
        
        return su.successOrFailure();
    }
    
}
