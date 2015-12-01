/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.entwa.bus;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import jim.entwa.ent.Address;
import jim.entwa.ent.Person;
import jim.entwa.pers.AddressFacade;
import jim.entwa.pers.PersonFacade;

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
    @EJB
    private AddressFacade af;

    public Person addNewPerson(Person p, Address a) {
        //verify that the operation is OK to proceed

        //do the business
        if (a != null) {
            //p.getHome().getOccupants().remove(p);
            a = af.edit(a);
            p.setHome(a);
            a.getOccupants().add(p);
        }
        pf.create(p);
        //return an appropriate object
        return p;
    }

    public Set<Address> findAllAddresses() {
        Set<Address> s = new HashSet<>();
        s.addAll(af.findAll());
        return s;
    }

    public List<Person> findAllPersons() {
        return pf.findAll();
    }
}
