/*
 * HelloAction.java
 *
 * Created on 17 August 2004, 12:41
 */

package jim.pums.actions;

import org.apache.struts.action.*;
import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.ServletException;

/**
 *
 * @author  briggsj
 */
public class HelloAction extends org.apache.struts.action.Action {
    
    /** Creates a new instance of HelloAction */
    public HelloAction() {
    }
    
    public ActionForward execute(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response) throws IOException, ServletException {
        return mapping.findForward("success");
    }
}
