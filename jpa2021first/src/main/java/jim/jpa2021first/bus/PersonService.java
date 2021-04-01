/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.jpa2021first.bus;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import jim.jpa2021first.ent.Address;
import jim.jpa2021first.ent.Person;
import jim.jpa2021first.pers.AddressFacade;
import jim.jpa2021first.pers.PersonFacade;

/**
 *
 * @author Jim Briggs
 */
@Stateless
@LocalBean
public class PersonService {

    @EJB
    private PersonFacade pf;
    @EJB
    private AddressFacade af;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public Person createNewPerson(Person p, Long residenceId) {
        Address residence = af.find(residenceId);
        p.getResidences().add(residence);
        residence.getOccupier().add(p);
        pf.create(p);
        return p;
    }
    
    public Address createNewAddress(Address a) {
        af.create(a);
        return a;
    }
    
    public List<Person> fetchAllPersons() {
        return pf.findAll();
    }

    public List<Address> fetchAllAddresses() {
        return af.findAll();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
