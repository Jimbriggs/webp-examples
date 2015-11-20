/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.entwa.ctrl;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import jim.entwa.bus.PersonService;
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

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }

    public String doAddNewPerson() {
        ps.addNewPerson(p);
        FacesContext fc = FacesContext.getCurrentInstance();
        MySessionBean msb = (MySessionBean)fc.getApplication().getELResolver().getValue(fc.getELContext(), null, "mySessionBean");
        return "";
    }
}
