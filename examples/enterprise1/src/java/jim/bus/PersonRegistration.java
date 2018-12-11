/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.bus;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import jim.entities.Person;
import jim.facades.PersonFacade;

/**
 *
 * @author briggsj
 */
@Stateless
public class PersonRegistration {

    @EJB
    private PersonFacade personFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public Person createNewPerson(Person p) throws BusinessException {
        List<Person> sameNames = personFacade.findSameName(p);
        if (sameNames.isEmpty()) {
            personFacade.create(p);
        } else {
            throw new BusinessException("Person with name " + p.getFullName() + " already exists");
        }
        return p;
    }

    public List<Person> findAllPersons() {
        return personFacade.findAll();
    }
}
