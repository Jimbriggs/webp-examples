/*
 * RegisterAction.java
 *
 * Created on 17 December 2004, 11:58
 */

package jim.pums.actions;

import jim.pums.process.UserMgmt;
/**
 *
 * @author  briggsj
 */

import java.io.*;
import javax.servlet.*;
import jim.common.*;
import jim.pums.bus.*;
import jim.util.struts.*;
import org.apache.struts.action.*;
import org.apache.struts.validator.DynaValidatorForm;

public class RegisterAction extends PumsBaseAction {
    
    /** Creates a new instance of RegisterAction */
    public RegisterAction() {
    }
    
    public ActionForward doPumsExecute(StrutsUtils su) throws IOException, ServletException, JimFatalException {
        JimActionErrors errors = su.getErrors();
        DynaValidatorForm form = (DynaValidatorForm)su.getForm();
        errors.add(form.validate(su.getMapping(), su.getRequest()));
        
        String pwd1 = (String)form.get("password1");
        String pwd2 = (String)form.get("password2");
        if (pwd1.equals(pwd2)) {
            //form.set("password", pwd1);
        } else {
            errors.add("password2", "pums.error.passwordmatch", "Passwords do not match");
        }
        
        if (!errors.isEmpty()) {
            return su.getMapping().findForward("failure");
        }
        
        User user = new User();
        su.copyBean(user, form);
        user.setPassword(pwd1);
        String emails[] = (String[])form.get("email");
        Trace.print("Emails = " + emails.toString());
        
        UserMgmt um = new UserMgmt(su.getConn());
        su.beginTransaction();
        
        try {
            Trace.print("User is valid");
            um.enterNewUser(user);
        } catch (Exception e) {
            Trace.print("Could not insert user: " + e);
            errors.addGlobal("pums.errors.dberror", "Could not insert user " + user.getFullname() + ": " + e.getMessage());
        }
        
        return su.endTransaction();
    }
    
}
