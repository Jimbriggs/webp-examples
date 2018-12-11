/*
 * Class.java
 *
 * Created on 17 August 2004, 12:46
 */

package jim.pums.ideas;

import jim.common.JimFatalException;
import jim.common.Trace;
import jim.pums.bus.*;
import jim.pums.process.IdeasProcess;
import jim.util.struts.*;
import org.apache.struts.action.*;

/**
 *
 * @author  briggsj
 */
public class ProjIdeaAction extends jim.pums.actions.PumsBaseAction {
    
    /** Creates a new instance of Class */
    public ProjIdeaAction() {
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
        
        ProjIdea idea = new ProjIdea();
        su.copyBean(idea, form);
        
        IdeasProcess id = new IdeasProcess(su.getConn());
        su.beginTransaction();
        
        try {
            Trace.print("Contact is valid");
            id.enterContact(contact);
        } catch (Exception e) {
            Trace.print("Could not insert contact: " + e);
            errors.addGlobal("pums.errors.dberror", "Could not insert contact with id " + contact.getOrgid() + ": " + e.getMessage());
        }
        
        idea.setProjorg(contact.getOrgid());
        
        try {
            Trace.print("Idea is valid");
            id.enterIdea(idea);
        } catch (Exception e) {
            Trace.print("Could not insert idea: " + e);
            errors.addGlobal("pums.errors.dberror", "Could not insert idea with id " + idea.getProjid() + ": " + e.getMessage());
        }

        return su.endTransaction();
    }
}
