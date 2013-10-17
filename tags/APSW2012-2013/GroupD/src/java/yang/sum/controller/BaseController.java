/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yang.sum.controller;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 *
 * @author BriggsJ
 */
// This class was shown during lectures
public class BaseController {

    public void addMessage(String clientId, Severity severity, String summary, String details) {
        FacesContext fc = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage(severity, summary, details);
        fc.addMessage(clientId, fm);
    }

    public void addError(String message) {
        addMessage(null, FacesMessage.SEVERITY_ERROR, message, message);
    }
    
    // This has been created to manage business level validation by adding the
    // error message to the right interface component
    public void addErrorToComponent(String clientId, String message) {
        addMessage(clientId, FacesMessage.SEVERITY_ERROR, message, message);
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
