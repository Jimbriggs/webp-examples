/*
 * MailFormAction.java
 *
 * Created on 03 May 2005, 21:21
 */

package jim.pums.assess.actions;

import java.io.IOException;
import javax.servlet.ServletException;
import jim.common.*;
import jim.pums.actions.PumsBaseAction;
import jim.pums.assess.bus.*;
import jim.util.struts.*;
import org.apache.struts.action.*;
import java.sql.*;
import jim.pums.assess.process.*;
import jim.util.SqlUtils;

/**
 *
 * @author  briggsj
 */
public class MailFormAction extends PumsBaseAction {
    
    /** Creates a new instance of MailFormAction */
    public MailFormAction() {
    }
    
    public ActionForward doPumsExecute(StrutsUtils su) throws IOException, ServletException, JimFatalException {
        AnyProjectMark form = (AnyProjectMark)su.getRequest().getSession().getAttribute("markForm");
        if (form == null) {
            su.getErrors().addGlobal("mail.noform", "");
            return su.failure();
        }
        if (form.getStudent() == null) {
            su.getErrors().addGlobal("mail.nostudent", "");
            return su.failure();
        }
        try {
            Connection conn = jim.pums.PumsApp.getInstance().getConnection();
            SqlUtils sql = new SqlUtils(conn);
            MarkFormProcess mfp = new MarkFormProcess(sql);
            try {
                mfp.sendEmail(form);
                su.getMessages().addGlobal("mail.sent", form.getStudent().getStudentName());
            } catch (javax.mail.MessagingException e) {
                su.getErrors().addGlobal("markForm.emailfailure", "");
            }
        } catch (java.sql.SQLException e) {
            throw new JimFatalException("Cannot get mark form categories", e);
        }
        // Dispose of markForm once emailed so that it can't be (easily) sent again
        su.getRequest().getSession().removeAttribute("markForm");
        su.getRequest().getSession().removeAttribute("markPreForm");
        su.getRequest().removeAttribute("markForm");
        return su.success();
    }
    
}
