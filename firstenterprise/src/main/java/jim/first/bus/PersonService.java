/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.first.bus;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import jim.first.ent.Person;
import jim.first.pers.PersonFacade;

/**
 *
 * @author briggsj
 */
@Stateless
public class PersonService {

    @EJB
    private PersonFacade pf;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public Person createNewPerson(Person p) {
        //check things: duplicates
        boolean ok = true;
        if (ok) {
            pf.create(p);
            return p;
        } else {
            //raise problem
            return null;
        }
    }

    public List<Person> findAllPersons() {
        return pf.findAll();
        
    }
}
