/*
 * PumsUserFilter.java
 *
 * Created on 27 September 2005, 14:31
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package jim.pums.process;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jim.pums.PumsApp;
import jim.util.RemoteUserFilter;
import jim.util.RequestUtils;
import jim.util.SqlUtils;
import steve.pums.assess.bus.PersonBean;
import steve.pums.assess.bus.UserBean;
import steve.pums.assess.process.ProjectService;

/**
 *
 * @author briggsj
 */
public class PumsUserFilter extends RemoteUserFilter {
    
    /** Creates a new instance of PumsUserFilter */
    public PumsUserFilter() {
    }
    
    protected boolean isOK(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            String username = request.getRemoteUser();
            if (username == null) {
                //Try extracting it from the authorization header
                username = RequestUtils.getAuthName(request);
            }
            if (username == null || username.equals("")) {
                //TODO: Remove this once a better authentication mechanism is in place!
                String x = RequestUtils.displayAsHtml(request);
                session.setAttribute("username", (username==null?"null":username) + "<BR>Request: " + x);
                if ("127.0.0.1".equals(request.getRemoteHost())) {
                    username = "Jim.Briggs";
                } else {
                    return false;
                }
            }
            SqlUtils sql = PumsApp.getInstance().getSqlUtils();
            ProjectService service = new ProjectService(sql);
            PersonBean pb = service.findPersonByUser_name(username);
            UserBean ub = new UserBean();
            ub.setPersonID(pb.getPerson_id());
            ub.setName(pb.getName());
            PumsApp.getInstance().closeSqlUtils();
            session.setAttribute("userbean", ub);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
