/*
 * CalcMark.java
 *
 */

package jim.pums.assess.actions;

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


public class CalcMarkAction extends PumsBaseAction {
    
    
    public CalcMarkAction() {
    }
    
    public ActionForward doPumsExecute(StrutsUtils su) throws IOException, ServletException, JimFatalException {
        AnyProjectMark mark = (AnyProjectMark)su.getForm();
        mark.getStudent().setDate(new Date());
        //        su.getErrors().add(mark.validate(su.getMapping(), su.getRequest()));
        //        su.setAttribute("markForm", mark, StrutsUtils.SESSION_SCOPE);
        return su.successOrFailure();
    }
}
