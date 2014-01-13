/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jim.sixthS.bus;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import jim.sixthS.ent.Address;
import jim.sixthS.ent.Person;
import jim.sixthS.pers.AddressFacade;
import jim.sixthS.pers.PersonFacade;

/**
 *
 * @author BriggsJ
 */
@Stateless
@RolesAllowed(value = "staffRole")
public class PersonService {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @EJB
    private PersonFacade pf;
    @EJB
    private AddressFacade af;

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

    @PermitAll
    public List<Person> getAllPersons() {
        return pf.findAll();
    }

    public Person setPersonHome(Person p, Address a) throws BusinessException {
        p = pf.edit(p);
        a = af.edit(a);
        p.setHome(a);
        a.addOccupant(p);
        return p;
    }

    public Person changeAddress(Person p, Address newAddress) throws BusinessException {
        p = pf.edit(p);
        newAddress = af.edit(newAddress);
        Address oldAddress = p.getHome();
        oldAddress.getOccupiers().remove(p);
        newAddress.addOccupant(p);
        p.setHome(newAddress);
        return p;
    }

    public List<Person> liveAtAddress(String searchString) throws BusinessException {
        List<Address> addrList = af.findByAddress(searchString);
        List<Person> personList = new ArrayList<>();
        for (Address a : addrList) {
            List<Person> occupiers = a.getOccupiers();
            personList.addAll(occupiers);
        }
        return personList;
    }
}
