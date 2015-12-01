/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.apsw151.ctrl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import jim.apsw151.bus.BusinessException;
import jim.apsw151.bus.PersonService;
import jim.apsw151.ents.Address;
import jim.apsw151.ents.Person;

/**
 *
 * @author BriggsJ
 */
@Named(value = "firstBean")
@RequestScoped
public class FirstBean extends MessageController {

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
    private Person p = new Person();
    private Address a = new Address();

    public String doChangeName() {
        try {
            if (a != null) {
                p.setHome(a);
            }
            ps.createNewPerson(p);
            addInfo(p.getFullName() + " successfully added");
        } catch (BusinessException ex) {
            Logger.getLogger(FirstBean.class.getName()).log(Level.SEVERE, null, ex);
            addError(ex.getLocalizedMessage());
        }
        return "";
    }

    public List<Address> getAllAddresses() {
        return ps.getAllAddresses();
    }

    public List<Person> getAllPersons() {
        return ps.getAllPersons();
    }
    
    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }

    public Address getA() {
        return a;
    }

    public void setA(Address a) {
        this.a = a;
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
