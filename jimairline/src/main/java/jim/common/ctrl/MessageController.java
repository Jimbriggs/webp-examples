/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.common.ctrl;

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

    protected void addError(String item, String errorMessage) {
        ctx.addMessage(item, new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, errorMessage));
    }

    protected void addInfo(String item, String errorMessage) {
        ctx.addMessage(item, new FacesMessage(FacesMessage.SEVERITY_INFO, errorMessage, errorMessage));
    }

    protected void addInfo(String infoMessage) {
        addInfo(null, infoMessage);
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
