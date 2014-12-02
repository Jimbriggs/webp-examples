/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.apsw3.ctrl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import jim.apsw3.bus.PersonService;
import jim.apsw3.ents.Address;
import jim.apsw3.ents.Person;
import jim.common.bus.BusinessException;
import jim.common.ctrl.MessageController;

/**
 *
 * @author BriggsJ
 */
@Named(value = "personController")
@RequestScoped
public class PersonController extends MessageController {

    @EJB
    private PersonService ps;

    public PersonService getPs() {
        return ps;
    }

    private Person p = new Person();
    private Address addr = new Address();

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }


    /**
     * Creates a new instance of PersonController
     */
    public PersonController() {
    }

    public List<Person> getAllUsers() {
        return ps.findAllPersons();
    }

    public String doAddPerson() {
        try {
            ps.addPerson(p, addr);
        } catch (BusinessException ex) {
            Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            addError(ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            addError("Some unexpected error occurred with message: " + ex.getMessage());
        }
        return "";
    }

    public List<Address> getAllAddresses() {
        return ps.findAllAddresses();
    }

    public String doInitAddresses() {
        ps.initAddresses();
        return "";
    }
}
