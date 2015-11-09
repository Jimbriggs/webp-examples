/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.apsw151.ctrl;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author BriggsJ
 */
@Named(value = "firstBean")
//@Dependent
@RequestScoped
public class FirstBean {

    /**
     * Creates a new instance of FirstView
     */
    public FirstBean() {
    }

    private String myName;
    private String newName;

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String doChangeName() {
        myName = newName;
        return "";
    }

    private String[] options = {"one", "two", "three"};

    public String[] getOptions() {
        return options;
    }

    private String selected;

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    

}
