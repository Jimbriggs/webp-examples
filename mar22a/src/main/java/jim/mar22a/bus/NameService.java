/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package jim.mar22a.bus;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import jim.mar22a.ent.Person;
import jim.mar22a.pers.PersonFacade;

/**
 *
 * @author Jim Briggs
 */
@Stateless
public class NameService {

    @EJB
    private PersonFacade pf;

    public String processName(String name) {
        name = "updated to " + name;
        Person p = new Person();
        p.setName(name);
        pf.create(p);
        return name;
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
