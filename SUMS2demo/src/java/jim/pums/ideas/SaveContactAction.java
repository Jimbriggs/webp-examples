/*
 * Class.java
 *
 * Created on 17 August 2004, 12:46
 */

package jim.pums.ideas;

import jim.pums.process.IdeasProcess;
import org.apache.struts.action.*;
import jim.common.*;
import jim.util.struts.*;

/**
 *
 * @author  briggsj
 */
public class SaveContactAction extends jim.pums.actions.PumsBaseAction {
    
    /** Creates a new instance of Class */
    public SaveContactAction() {
        super();
    }
    
    public ActionForward doPumsExecute(StrutsUtils su) throws JimFatalException {
        JimActionErrors errors = su.getErrors();
        ActionForm form = su.getForm();
        errors.add(form.validate(su.getMapping(), su.getRequest()));
        if (!errors.isEmpty()) {
            return su.getMapping().findForward("failure");
        }
        ProjContact contact = new ProjContact();
        su.copyBean(contact, form);
        
        IdeasProcess id = new IdeasProcess(su.getConn());
        su.beginTransaction();
        
        try {
            Trace.print("Contact is valid");
            id.enterContact(contact);
        } catch (Exception e) {
            Trace.print("Could not insert contact: " + e);
            errors.addGlobal("pums.errors.dberror", "Could not insert contact with id " + contact.getOrgid() + ": " + e.getMessage());
        }

        return su.endTransaction();
    }
}
