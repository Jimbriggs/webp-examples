/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.relations.ctrl;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import jim.relations.bus.PeopleService;
import jim.relations.ent.Address;
import jim.relations.ent.Person;

/**
 *
 * @author briggsj
 */
@Named(value = "controller")
@RequestScoped
public class Controller {

    public Person getNewP() {
        return newP;
    }

    public void setNewP(Person newP) {
        this.newP = newP;
    }

    public Address getNewA() {
        return newA;
    }

    public void setNewA(Address newA) {
        this.newA = newA;
    }

    private List<Address> allAddresses = null;

    /**
     * Creates a new instance of Controller
     */
    public Controller() {
    }

    public List<Address> getAllAddresses() {
        if (allAddresses == null) {
            allAddresses = ps.findAllAddresses();
        }
        return allAddresses;
    }

    public void setAllAddresses(List<Address> allAddresses) {
        this.allAddresses = allAddresses;
    }

    @EJB
    private PeopleService ps;
    private Person newP = new Person();
    private Address newA = new Address();

    public String doStuff() {
        ps.createNewRelationship(newP, newA);
        return "";
    }

}
