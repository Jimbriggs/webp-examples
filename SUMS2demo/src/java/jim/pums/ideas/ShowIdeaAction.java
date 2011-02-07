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
import org.apache.struts.action.*;
import jim.pums.process.IdeasProcess;
import jim.common.*;
import jim.util.*;
import jim.util.struts.StrutsUtils;


public class ShowIdeaAction extends jim.pums.actions.PumsBaseAction {
    
    private IdeasProcess i;
    
    /** Creates a new instance of ListIdeaAction */
    public ShowIdeaAction() {
        super();
    }
    
    public ActionForward doPumsExecute(StrutsUtils su) throws IOException, ServletException, JimFatalException {
        // Create list of projects in a bean
        try {
            int num = RequestUtils.getParameter(su.getRequest(), "idea", 0);
            i = new IdeasProcess(su.getConn());
            Map idea = i.getIdeaById(num);
            if (idea == null) {
                su.getErrors().addGlobal("pums.nosuchidea", new Integer(num).toString());
                return su.getMapping().findForward("noSuchIdea");
            }
            su.getRequest().setAttribute("item", idea);
            //return success
            return su.success();
        } catch (Exception e) {
            throw new JimFatalException("database problem", e);
        }
    }
    
       
}
