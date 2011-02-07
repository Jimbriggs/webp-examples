/*
 * PumsBaseAction.java
 *
 * Created on 17 August 2004, 16:17
 */

package jim.pums.actions;

import org.apache.struts.action.*;
import java.io.IOException;
import javax.servlet.ServletException;
import jim.common.*;
import jim.pums.*;
import jim.util.struts.JimBaseAction;
import jim.util.struts.StrutsUtils;

/**
 *
 * @author  briggsj
 */
abstract public class PumsBaseAction extends JimBaseAction {
    
    /** Creates a new instance of PumsBaseAction */
    public PumsBaseAction() {
        super();
    }
    
    protected PumsApp createApplication() {
        return PumsApp.getInstance();
    }
    
    public final ActionForward doExecute(StrutsUtils su) throws IOException, ServletException, JimFatalException {
        ActionForward af = doPumsExecute(su);
        return af;
    }
    
    public abstract ActionForward doPumsExecute(StrutsUtils su) throws IOException, ServletException, JimFatalException;
    
}
