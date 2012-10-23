/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.jsf1;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author briggsj
 */
@ManagedBean
@RequestScoped
public class NameBean {

    private String firstName = "nobody";
    private String newName;

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Creates a new instance of nameBean
     */
    public NameBean() {
    }
    
    public String doName() {
        this.setFirstName(this.getNewName());
        return "";
    }
}
