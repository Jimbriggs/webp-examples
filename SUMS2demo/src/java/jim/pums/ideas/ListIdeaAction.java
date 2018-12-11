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
import jim.pums.actions.PumsBaseAction;


public class ListIdeaAction extends jim.pums.actions.PumsBaseAction {
    
    /** Creates a new instance of ListIdeaAction */
    public ListIdeaAction() {
        super();
    }
    
    public ActionForward doPumsExecute(StrutsUtils su) throws IOException, ServletException, JimFatalException {
        // Create list of projects in a bean
        try {
            IdeasProcess id = new IdeasProcess(su.getConn());
            List projects;
            int contact = su.getParameter("contact", -1);
            if (contact > 0) {
                projects = id.getIdeasByContact(contact);
            } else {
                projects = id.getAllIdeas("%");
            }
            HttpServletRequest request = su.getRequest();
            request.setAttribute("ideas", projects);
            //return success
            return su.success();
        } catch (Exception e) {
            throw new JimFatalException("database problem", e);
        }
    }
    
}
