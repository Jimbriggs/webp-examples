/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.apsw151.bus;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import jim.apsw151.ents.Address;
import jim.apsw151.ents.Person;
import jim.apsw151.pers.AddressFacade;
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

    public Person createNewPerson(Person p) throws BusinessException {
        //verify that the operation is valid
        if (!personAlreadyExists(p)) {
            //do operation
            Address a = p.getHome();
            if (a != null) {
                a = af.edit(a);
                p.setHome(a);
                a.getOccupants().add(p);
            } else {
                throw new BusinessException("No address specified");
            }
            pf.create(p);
            //return an appropriate object
            return p;
        } else {
            throw new BusinessException("Person " + p.getFullName() + " already exists");
        }
    }

    public boolean personAlreadyExists(Person p) {
        List<Person> already = pf.findByName(p);
        return !already.isEmpty();
    }

    @EJB
    private AddressFacade af;

    public List<Address> getAllAddresses() {
        return af.findAll();
    }
}
