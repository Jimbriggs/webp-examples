/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.first.ctrl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import jim.first.bus.BusinessException;
import jim.first.bus.PersonService;
import jim.first.ent.Person;

/**
 *
 * @author briggsj
 */
@Named(value = "personCtrl")
@RequestScoped
public class PersonCtrl {

    /**
     * Creates a new instance of PersonCtrl
     */
    public PersonCtrl() {
    }

    private Person newPerson = new Person();
    private List<Person> allPersons = null;

    public List<Person> getAllPersons() {
        allPersons = ps.findAllPersons();
        return allPersons;
    }

    public void setAllPersons(List<Person> allPersons) {
        this.allPersons = allPersons;
    }

    public Person getNewPerson() {
        return newPerson;
    }

    public void setNewPerson(Person newPerson) {
        this.newPerson = newPerson;
    }

    @EJB
    private PersonService ps;

    public String doInsertPerson() {
        try {
            ps.createNewPerson(newPerson);
        } catch (BusinessException ex) {
            Logger.getLogger(PersonCtrl.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage("", new FacesMessage(ex.getMessage()));
        }
        return "";
    }
}
