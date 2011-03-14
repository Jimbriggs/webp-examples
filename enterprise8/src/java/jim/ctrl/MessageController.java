/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.ctrl;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author briggsj
 */
public abstract class MessageController implements Serializable {

    protected FacesContext ctx = FacesContext.getCurrentInstance();

    protected void addError(String s) {
        addError((String) null, s);
    }

    protected void addError(String item, String s) {
        ctx.addMessage(item, new FacesMessage(FacesMessage.SEVERITY_ERROR, s, s));
    }

    protected void addInfo(String item, String s) {
        ctx.addMessage(item, new FacesMessage(FacesMessage.SEVERITY_INFO, s, s));
    }

    protected void addInfo(String s) {
        addInfo(null, s);
    }

    protected void addError(Exception ex, String defaultMsg) {
        String msg = ex.getLocalizedMessage();
        if (msg != null && msg.length() > 0) {
            addError(msg);
        } else {
            addError(defaultMsg);
        }
    }
}
