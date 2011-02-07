package steve.pums.assess.actions;
/*
 * getUser.java
 *
 * Created on 19 July 2005, 22:16
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import jim.common.JimFatalException;
import jim.pums.PumsApp;
import jim.pums.actions.PumsBaseAction;
import jim.util.SqlUtils;
import jim.util.struts.*;
import org.apache.struts.action.ActionForward;
import steve.pums.assess.bus.UserBean;
import steve.pums.assess.process.ProjectService;

/**
 *
 * @author Steve Powell
 */
public class InitAction extends PumsBaseAction {
    
    /** Creates a new instance of getUser */
    public InitAction() {
    }
    
    public ActionForward doPumsExecute(StrutsUtils su) throws IOException, ServletException, JimFatalException {
        UserBean user = (UserBean)su.getForm();
        
        // to be populated and attached to session by login process
        su.setAttribute("userbean", user, su.SESSION_SCOPE);
        
        try {
            SqlUtils sql = PumsApp.getInstance().getSqlUtils();
            ProjectService service = new ProjectService(sql);
            List units = service.findAllUnitsAsLVB();
            su.setAttribute("units", units, su.SESSION_SCOPE);
        } catch (SQLException e) {
            throw new JimFatalException("cannot connect to database");
        }
        
        return su.successOrFailure();
    }
    
    
}
