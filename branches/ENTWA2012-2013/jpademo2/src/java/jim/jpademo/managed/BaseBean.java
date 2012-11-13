/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.jpademo.managed;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class BaseBean {

    protected void addError(String s) {
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, new FacesMessage(s));
    }
}
