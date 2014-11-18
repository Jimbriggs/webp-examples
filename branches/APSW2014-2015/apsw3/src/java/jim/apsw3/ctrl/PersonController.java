/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.apsw3.ctrl;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import jim.apsw3.bus.PersonService;
import jim.apsw3.ents.Person;

/**
 *
 * @author BriggsJ
 */
@Named(value = "personController")
@RequestScoped
public class PersonController {

    @EJB
    private PersonService ps;

    private Person p = new Person();

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }
    /**
     * Creates a new instance of PersonController
     */
    public PersonController() {
    }

    public String doAddPerson() {
        ps.addPerson(p);
        return "";
    }
}
