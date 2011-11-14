/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.bus;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import jim.entities.Address;
import jim.entities.Person;
import jim.facades.AddressFacade;
import jim.facades.PersonFacade;

/**
 *
 * @author briggsj
 */
@Stateless
public class PersonRegistration {

    @EJB
    private AddressFacade addressFacade;
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

    public Address createNewAddress(Address a) throws BusinessException {
        List<Address> sameAddress = addressFacade.findSameAddress(a);
        if (sameAddress.isEmpty()) {
            addressFacade.create(a);
        } else {
            throw new BusinessException("Address with postcode " + a.getPostcode() + " already exists");
        }
        return a;
    }

    public List<Address> findAllAddresses() {
        return addressFacade.findAll();
    }

    public Address findAddress(String addressId) {
        Long id = Long.valueOf(addressId);
        if (id == 0L) {
            // 0 = no address
            return null;
        }
        Address a = addressFacade.find(id);
        return a;
    }
}
