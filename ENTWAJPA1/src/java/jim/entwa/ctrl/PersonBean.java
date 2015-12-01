/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.entwa.ctrl;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import jim.entwa.bus.PersonService;
import jim.entwa.ent.Address;
import jim.entwa.ent.Person;

/**
 *
 * @author BriggsJ
 */
@Named(value = "personBean")
@RequestScoped
public class PersonBean {

    /**
     * Creates a new instance of PersonBean
     */
    public PersonBean() {
    }

    @EJB
    private PersonService ps;

    private Person p = new Person();
    private Address a = new Address();

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

    public String doAddNewPerson() {
        ps.addNewPerson(p, a);
        FacesContext fc = FacesContext.getCurrentInstance();
        MySessionBean msb = (MySessionBean)fc.getApplication().getELResolver().getValue(fc.getELContext(), null, "mySessionBean");
        return "";
    }

    public List<Person> getAllPersons() {
        return ps.findAllPersons();
    }
}
