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
public class BasicController implements Serializable {

    protected FacesContext ctx = FacesContext.getCurrentInstance();

    protected void addError (String s) {
        addError(null, s);
    }
    protected void addError (String item, String s) {
        ctx.addMessage(item, new FacesMessage(FacesMessage.SEVERITY_ERROR, s, s));
    }

    protected void addInfo (String item, String s) {
        ctx.addMessage(item, new FacesMessage(FacesMessage.SEVERITY_INFO, s, s));
    }

    protected void addInfo (String s) {
        addInfo(null, s);
    }
}
