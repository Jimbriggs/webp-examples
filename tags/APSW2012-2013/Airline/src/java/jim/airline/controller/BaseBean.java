/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.airline.controller;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 *
 * @author BriggsJ
 */
public class BaseBean {

    public void addMessage(String clientId, Severity severity, String summary, String details) {
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
