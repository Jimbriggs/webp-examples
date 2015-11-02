/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.apsw1.ctrl;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author briggsj
 */
@Named(value = "beanTwo")
@SessionScoped
public class BeanTwo implements Serializable {

    /**
     * Creates a new instance of BeanTwo
     */
    public BeanTwo() {
    }
    
    private String name;
    private String newName;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }
    
    public String doUpdateName() {
        name = newName;
        return "";
    }
}
