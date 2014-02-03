/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jim.sixthS.ctrl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBAccessException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import jim.sixthS.bus.BusinessException;
import jim.sixthS.bus.PersonService;
import jim.sixthS.ent.LoginUser;
import jim.sixthS.ent.Person;
import jim.sixthS.pers.LoginUserFacade;

/**
 *
 * @author BriggsJ
 */
@Named("personController")
@RequestScoped
public class PersonController extends MessageController {

    /**
     * Creates a new instance of PersonController
     */
    public PersonController() {
    }

    private String newName;

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    private List<Person> allPersons;

    public List<Person> getAllPersons() {
        return allPersons;
    }

    public void setAllPersons(List<Person> allPersons) {
        this.allPersons = allPersons;
    }

    @EJB
    private PersonService ps;

    public String addPerson() {
        Person p = new Person();
        p.setName(newName);
        try {
            ps.createNewPerson(p);
        } catch (BusinessException ex) {
            Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EJBAccessException ex) {
            Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
            addError(ex, "Sorry you are not authorised to perform this operation.");
        }
        allPersons = ps.getAllPersons();
        return "";
    }

    private boolean initialised = false;

    public boolean isInitialised() {
        return false;
//        return initialised;
    }

    public void setInitialised(boolean initialised) {
        this.initialised = initialised;
    }

    @EJB
    private LoginUserFacade lf;

    public String init () {
        LoginUser u = new LoginUser();
        u.setId("jim");
        u.setPassword("test");
        lf.create(u);
        this.setInitialised(true);
        return "";
    }
}
