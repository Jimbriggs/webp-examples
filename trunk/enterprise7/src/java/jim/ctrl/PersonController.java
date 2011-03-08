/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.ctrl;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ListDataModel;
import jim.bus.BusinessException;
import jim.bus.PersonRegistration;
import jim.entities.Person;
import jim.facades.PersonFacade;

/**
 *
 * @author briggsj
 */
@RequestScoped
@ManagedBean
public class PersonController extends AbstractController<Person, PersonFacade> {

    public PersonController() {
        super(Person.class);
    }

    @EJB
    private PersonRegistration personRegistration;
    @EJB
    private PersonFacade facade;

    public String doAddPerson() {
        try {
            current = newItem = personRegistration.createNewPerson(newItem);
            addInfo("Person " + current.getFullName() + " added to database");
            items = new ListDataModel(personRegistration.findAllPersons());
        } catch (BusinessException ex) {
            Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
            addError("Person " + newItem.getFullName() + " cannot be added to database: " + ex.getMessage());
        }
        return "personlist.xhtml";
    }

    @Override
    public PersonFacade getFacade() {
        return facade;
    }
}
