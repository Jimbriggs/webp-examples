/*
 * LoadCohortAction.java
 *
 * Created on 15 September 2005, 14:31
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package jim.pums.assess.actions;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletException;
import jim.common.JimFatalException;
import jim.pums.actions.PumsBaseAction;
import org.apache.struts.action.*;
import jim.util.struts.*;
import org.apache.struts.upload.FormFile;
import org.apache.struts.util.LabelValueBean;
import steve.pums.assess.process.ProjectService;

/**
 *
 * @author briggsj
 */
public class InitLoadCohortAction extends PumsBaseAction {
    
    /** Creates a new instance of LoadCohortAction */
    public InitLoadCohortAction() {
    }
    
    public ActionForward doPumsExecute(StrutsUtils su) throws IOException, ServletException, JimFatalException {
        ActionForward af;
                
        try {
            Connection conn = jim.pums.PumsApp.getInstance().getConnection();
            su.beginTransaction();
            
            ProjectService projectservice = new ProjectService(conn);
            //process staff file (without overwriting existing entries)
            List<LabelValueBean> lvblist = projectservice.findCohortsLVB();
            su.setAttribute("cohorts", lvblist, su.SESSION_SCOPE);
            af = su.endTransaction();
            conn.close();
        } catch (java.sql.SQLException e) {
            throw new JimFatalException("Cannot initalise a cohort - database problem", e);
//        } catch (java.text.ParseException e) {
//            throw new JimFatalException("Cannot parse project date", e);
//        } catch (javax.mail.MessagingException e) {
//            su.getErrors().addGlobal("markForm.emailfailure", "");
        }
        
        return af;
    }
    
}
