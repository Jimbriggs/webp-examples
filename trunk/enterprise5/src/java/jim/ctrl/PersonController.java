/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.ctrl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import jim.bus.BusinessException;
import jim.bus.PersonRegistration;
import jim.entities.Address;
import jim.entities.Person;

/**
 *
 * @author briggsj
 */

@RequestScoped
@ManagedBean
public class PersonController extends BasicController {

    @EJB
    private PersonRegistration personRegistration;
    protected Person person = new Person();
    protected List<Address> addressList = new ArrayList<Address>();
    protected List<Person> personList = new ArrayList<Person>();

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    /** Creates a new instance of PersonController */
    public PersonController() {
    }

    @PostConstruct
    public void init() {
        addressList = personRegistration.findAllAddresses();
        personList = personRegistration.findAllPersons();
    }
    /**
     * Get the value of person
     *
     * @return the value of person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Set the value of person
     *
     * @param person new value of person
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * Get the value of addressList
     *
     * @return the value of addressList
     */
    public List<Address> getAddressList() {
        return addressList;
    }

    /**
     * Set the value of addressList
     *
     * @param addressList new value of addressList
     */
    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public String doAddPerson() {
        try {
            person = personRegistration.createNewPerson(person);
            addInfo("Person " + person.getFullName() + " added to database");
            personList = personRegistration.findAllPersons();
        } catch (BusinessException ex) {
            Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
            addError("Person " + person.getFullName() + " cannot be added to database: " + ex.getMessage());
        }
        return "personlist.xhtml";
    }
}
