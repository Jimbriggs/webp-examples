/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.entwa1.ctrl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;



/**
 *
 * @author BriggsJ
 */
@Named
@RequestScoped
public class FirstBean {

    /**
     * Creates a new instance of FirstBean
     */
    public FirstBean() {
    }

    private String myName;
    private String newName;

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public String[] getMenuOptions() {
        return menuOptions;
    }

    public String doChangeName() {
        newName = myName;
        return "";
    }

    private final String[] menuOptions = {"One", "Two", "Three"};

    private String selected;

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }
    
}
