package steve.pums.assess.actions;
/*
 * getUser.java
 *
 * Created on 19 July 2005, 22:16
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import jim.common.JimFatalException;
import jim.pums.actions.PumsBaseAction;
import jim.pums.assess.bus.*;
import jim.util.struts.*;
import org.apache.struts.action.ActionForward;
import org.apache.struts.validator.DynaValidatorForm;
import org.apache.commons.beanutils.BeanUtils;
import steve.pums.assess.bus.StudentBean;

/**
 *
 * @author Steve Powell
 */
public class GetStudent extends PumsBaseAction {
    
    /** Creates a new instance of getUser */
    public GetStudent() {
    }
    
    public ActionForward doPumsExecute(StrutsUtils su) throws IOException, ServletException, JimFatalException {
        
        StudentBean student = (StudentBean)su.getForm();
        
        // to be populated and attached to session by login process
        su.setAttribute("studentbeanbean", student, StrutsUtils.SESSION_SCOPE);
        
        return su.successOrFailure();
    }
    
    
}
