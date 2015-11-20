/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.entwa.bus;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import jim.entwa.ent.Person;
import jim.entwa.pers.PersonFacade;

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

    public Person addNewPerson(Person p) {
        //verify that the operation is OK to proceed

        //do the business
        pf.create(p);
        //return an appropriate object
        return p;
    }
}
