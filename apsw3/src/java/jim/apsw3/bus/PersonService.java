/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.apsw3.bus;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import jim.apsw3.ents.Person;
import jim.apsw3.pers.PersonFacade;

/**
 *
 * @author BriggsJ
 */
@Stateless
public class PersonService {

    @EJB
    private PersonFacade pf;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public Person addPerson(Person p) {
        if (true) {
            pf.create(p);
        }
        return p;
    }
}
