/*
 * AssessSessionFilter.java
 *
 * Created on 18 May 2005, 16:35
 */

package jim.pums;

import javax.servlet.*;
import javax.servlet.http.*;
import jim.util.SessionFilter;

/**
 *
 * @author  briggsj
 */
public class AssessSessionFilter extends SessionFilter {
    
    /** Creates a new instance of AssessSessionFilter */
    public AssessSessionFilter() {
    }
    
    protected boolean isInvalid(HttpSession session, ServletRequest request, ServletResponse response) {
        Object mark = ((HttpServletRequest)request).getSession().getAttribute("markForm");
        return (mark != null);
    }
    
}
