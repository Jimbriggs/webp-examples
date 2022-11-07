/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package jim.adamproj5.bus;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import jim.adamproj5.ent.Person;
import jim.adamproj5.pers.PersonFacade;

/**
 *
 * @author Jim Briggs
 */
@Stateless
public class StartService {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @EJB
    private PersonFacade pf;

    public String startStarting(String text) {
        Person p = new Person();
        p.setName(text);
        //save this in database
        pf.create(p);
        return text + "?";
    }
}
