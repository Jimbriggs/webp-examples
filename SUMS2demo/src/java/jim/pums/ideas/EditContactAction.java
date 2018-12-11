/*
 * ListIdeaAction.java
 *
 * Created on 02 November 2004, 10:52
 */

package jim.pums.ideas;

import jim.pums.process.IdeasProcess;
/**
 *
 * @author  briggsj
 */
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;
import org.apache.commons.beanutils.BeanUtils;
import jim.common.*;
import jim.util.struts.StrutsUtils;
import jim.util.RequestUtils;


public class EditContactAction extends jim.pums.actions.PumsBaseAction {
    
    /** Creates a new instance of ListIdeaAction */
    public EditContactAction() {
        super();
    }
    
    public ActionForward doPumsExecute(StrutsUtils su) throws IOException, ServletException, JimFatalException {
        try {
            HttpServletRequest request = su.getRequest();
            ActionMapping mapping = su.getMapping();
            IdeasProcess i = new IdeasProcess(su.getConn());
            
            int num = RequestUtils.getParameter(request, "contact", 0);
            Map contact = i.getContactById(num);
            if (contact == null) {
                su.getErrors().addGlobal("pums.nosuchcontact", new Integer(num).toString());
                return su.getMapping().findForward("noSuchContact");
            }
            ProjContact projcontact = new ProjContact();
            BeanUtils.copyProperties(projcontact, contact);
            
            Trace.print("Creating new contactForm bean under key " + "contactForm");
            request.setAttribute("contactForm", projcontact);
            return su.success();
        } catch (Exception e) {
            throw new JimFatalException("database problem", e);
        }
    }
    
}
