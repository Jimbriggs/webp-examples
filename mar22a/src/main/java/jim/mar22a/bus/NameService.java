/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package jim.mar22a.bus;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import jim.mar22a.ent.Address;
import jim.mar22a.ent.Person;
import jim.mar22a.pers.AddressFacade;
import jim.mar22a.pers.PersonFacade;

/**
 *
 * @author Jim Briggs
 */
@Stateless
public class NameService {

    @EJB
    private PersonFacade pf;
    @EJB
    private AddressFacade af;

    public String processName(String name) {
        name = "updated to " + name;
        Person p = new Person();
        p.setName(name);
        pf.create(p);
        return name;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public Person livesAt(Person p, Address a) throws BusinessException {
        if (p == null) {
            throw new BusinessException("Person missing");
        }
        if (a == null) {
            throw new BusinessException("Person missing");
        }
        p = pf.edit(p);
        a = af.edit(a);
        if (p.getResidences().contains(a)) {
            throw new BusinessException("Person " + p.getName() + " already lives at " + a.getCity());
        }
        if (a.getResidents().contains(p)) {
            throw new BusinessException("and Person " + p.getName() + " already lives at " + a.getCity());
        }
        p.getResidences().add(a);
        a.getResidents().add(p);
        return p;
    }

    public Person leaves(Person p, Address a) {
        p = pf.edit(p);
        a = af.edit(a);
        p.getResidences().remove(a);
        a.getResidents().remove(p);
        return p;
    }

    public Person changeAddress(Person p, Address oldAddress, Address newAddress) throws BusinessException {
        p = pf.edit(p);
        oldAddress = af.edit(oldAddress);
        newAddress = af.edit(newAddress);
        this.leaves(p, oldAddress);
        this.livesAt(p, newAddress);
        return p;
    }

    public List<Person> findAllPersons() {
        return pf.findAll();
    }

    public List<Address> findAllAddresses() {
        return af.findAll();
    }
}
