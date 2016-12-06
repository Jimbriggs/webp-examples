/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.apsw2.ctrl;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import jim.apsw2.bus.BusinessException;
import jim.apsw2.bus.PersonService;
import jim.apsw2.ent.Address;
import jim.apsw2.ent.Person;

/**
 *
 * @author BriggsJ
 */
@Named(value = "personController")
@RequestScoped
public class PersonController {

    /**
     * Creates a new instance of PersonController
     */
    public PersonController() {
    }

    private Person person;
    private Address address;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @EJB
    private PersonService ps;

    public String doChangeAddress() {
        try {
            ps.changeHome(person, address);
        } catch (BusinessException ex) {
            Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("something went wrong"));
        }
        return "";
    }
}
