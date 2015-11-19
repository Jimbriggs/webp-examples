/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.apsw151.bus;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import jim.apsw151.ents.Person;
import jim.apsw151.pers.PersonFacade;

/**
 *
 * @author BriggsJ
 */
@Stateless
public class PersonService {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @EJB
    private PersonFacade pf;

    public Person createNewPerson(Person p) {
        //verify
        //TODO: check that this person doesn't already exist
        //do operation
        pf.create(p);
        //return an appropriate object
        return p;
    }
}
