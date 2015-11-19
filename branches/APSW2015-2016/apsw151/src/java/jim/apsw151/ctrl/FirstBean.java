/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.apsw151.ctrl;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import jim.apsw151.bus.PersonService;
import jim.apsw151.ents.Person;

/**
 *
 * @author BriggsJ
 */
@Named(value = "firstBean")
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

    @EJB
    private PersonService ps;

    public String doChangeName() {
        myName = newName;
        Person p = new Person();
        p.setForename(myName);
        p.setSurname(myName);
        ps.createNewPerson(p);
        return "";
    }

    private final String[] options = {"one", "two", "three"};

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
