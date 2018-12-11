/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.first.bus;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import jim.first.ent.Address;
import jim.first.ent.Person;
import jim.first.pers.AddressFacade;
import jim.first.pers.PersonFacade;

/**
 *
 * @author briggsj
 */
@Stateless
public class PersonService {

    @EJB
    private PersonFacade pf;
    @EJB
    private AddressFacade af;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public Person createNewPerson(Person p) throws BusinessException {
        //check things: duplicates
        boolean ok = true;
        if (pf.findPersonByName(p.getName()).isEmpty()) {
            pf.create(p);
            return p;
        } else {
            //raise problem
            throw new BusinessException("Duplicated name: " + p.getName());
        }
    }

    public List<Person> findAllPersons() {
        return pf.findAll();

    }

    public Person associatePersonHome(Person person, Address newAddress) {
        person = pf.edit(person);
        newAddress = af.edit(newAddress);
        Address oldAddress = person.getHome();
        if (oldAddress != null && oldAddress.getResidents().contains(person)) {
            oldAddress.getResidents().remove(person);
        }
        person.setHome(newAddress);
        newAddress.getResidents().add(person);
        return person;
    }

    public List<Address> findAllAddresses() {
        return af.findAll();
    }
}
