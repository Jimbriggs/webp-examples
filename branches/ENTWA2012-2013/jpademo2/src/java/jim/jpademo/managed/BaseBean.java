/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.jpademo.managed;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class BaseBean {

    public void addMessage(String clientId, FacesMessage.Severity severity, String summary, String details) {
        FacesContext fc = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage(severity, summary, details);
        fc.addMessage(clientId, fm);
    }

    public void addError(String message) {
        addMessage(null, FacesMessage.SEVERITY_ERROR, message, message);
    }

    public void addInfo(String message) {
        addMessage(null, FacesMessage.SEVERITY_INFO, message, message);
    }

    public void addWarn(String message) {
        addMessage(null, FacesMessage.SEVERITY_WARN, message, message);
    }

    public void addFatal(String message) {
        addMessage(null, FacesMessage.SEVERITY_FATAL, message, message);
    }
    
}
