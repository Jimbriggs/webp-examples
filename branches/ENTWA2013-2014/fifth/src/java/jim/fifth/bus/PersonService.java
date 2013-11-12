/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jim.fifth.bus;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import jim.fifth.ent.Person;
import jim.fifth.pers.PersonFacade;

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

    public Person createNewPerson (Person p) throws BusinessException {
        //check business rules
        if (this.hasSameName(p)) {
            throw new BusinessException("Duplicated name: " + p.getName());
        }
        //call persistence operation
        pf.create(p);
        return p;
    }

    public boolean hasSameName(Person p) {
        return false;
    }

    public List<Person> getAllPersons() {
        return pf.findAll();
    }
}
