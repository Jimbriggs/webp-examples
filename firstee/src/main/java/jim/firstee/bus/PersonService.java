/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.firstee.bus;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import jim.firstee.ent.Person;
import jim.firstee.pers.PersonFacade;

/**
 *
 * @author Jim Briggs
 */
@Stateless
public class PersonService {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @EJB
    private PersonFacade pf;
    
    public Person createNewPerson(Person p) {
        pf.create(p);
        return p;
    }
}
