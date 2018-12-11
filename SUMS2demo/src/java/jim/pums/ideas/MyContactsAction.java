/*
 * ListIdeaAction.java
 *
 * Created on 02 November 2004, 10:52
 */

package jim.pums.ideas;

/**
 *
 * @author  briggsj
 */
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;
import jim.pums.process.IdeasProcess;
import jim.common.*;
import jim.util.struts.StrutsUtils;


public class MyContactsAction extends jim.pums.actions.PumsBaseAction {
    
    private IdeasProcess i;
    
    /** Creates a new instance of ListIdeaAction */
    public MyContactsAction() {
        super();
    }
    
    public ActionForward doPumsExecute(StrutsUtils su) throws IOException, ServletException, JimFatalException {
        // Create list of projects in a bean
        try {
            i = new IdeasProcess(su.getConn());
            List allContacts = i.getMyContacts();
            HttpServletRequest request = su.getRequest();
            request.setAttribute("myContacts", allContacts);
            return su.success();
        } catch (Exception e) {
            throw new JimFatalException("database problem", e);
        }
    }
    
}
