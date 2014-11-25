/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.apsw3.bus;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import jim.apsw3.ents.Person;
import jim.apsw3.pers.PersonFacade;
import jim.common.bus.BusinessException;

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
    public Person addPerson(Person p) throws BusinessException {
        if (!alreadyExist(p)) {
            pf.create(p);
        } else {
            throw new BusinessException("Person already exists with name " + p.getForename() + " " + p.getSurname());
        }
        return p;
    }

    public List<Person> findAllPersons() {
        return pf.findAll();
    }

    private boolean alreadyExist(Person p) {
        return !pf.findPersonByName(p.getForename(), p.getSurname()).isEmpty();
    }
}
