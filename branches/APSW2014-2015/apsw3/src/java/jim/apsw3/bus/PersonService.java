/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.apsw3.bus;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import jim.apsw3.ents.Address;
import jim.apsw3.ents.Person;
import jim.apsw3.pers.AddressFacade;
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
    @EJB
    private AddressFacade af;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public Person addPerson(Person p, Address a) throws BusinessException {
        if (!alreadyExist(p)) {
            a = af.edit(a);
            p.changeAddress(a);
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

    public List<Address> findAllAddresses() {
        return af.findAll();
    }

    public List<Address> initAddresses() {
        if (af.count() == 0) {
            return af.initAddresses();
        } else {
            return null;
        }
    }

    public Address findAddressById(Long id) {
        return af.find(id);
    }
}
