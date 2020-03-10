/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.relations.bus;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import jim.relations.ent.Address;
import jim.relations.ent.AddressFacade;
import jim.relations.ent.Person;
import jim.relations.ent.PersonFacade;

/**
 *
 * @author briggsj
 */
@Stateless
public class PeopleService {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @EJB
    private PersonFacade pf;
    @EJB
    private AddressFacade af;
    
    public Person createNewRelationship(Person p, Address a) {
//        Person p = new Person();
//        p.setName("Jim");
//        Address a = new Address();
//        a.setCity("Portsmouth");
        
        Address oldAddress = p.getHome();
        if (oldAddress != null && oldAddress.getOccupants().contains(p)) {
            oldAddress.getOccupants().remove(p);
        }
        p.setHome(a);
        a.getOccupants().add(p);
        
        pf.create(p);
        af.create(a);
        return p;
    }

    public List<Address> findAllAddresses() {
        return af.findAll();
    }
}
