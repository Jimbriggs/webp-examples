/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.entwa.ctrl;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jim.entwa.ent.Person;

/**
 *
 * @author BriggsJ
 */
@Named(value = "mySessionBean")
@SessionScoped
public class MySessionBean implements Serializable {

    /**
     * Creates a new instance of MySessionBean
     */
    public MySessionBean() {
    }

    private List<Person> personList = new ArrayList<Person>();

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

}
