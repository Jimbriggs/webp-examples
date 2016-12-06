/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.apsw2.bus;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import jim.apsw2.ent.Address;
import jim.apsw2.ent.Person;
import jim.apsw2.pers.AddressFacade;
import jim.apsw2.pers.PersonFacade;

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

    public Person changeHome (Person p, Address a) throws BusinessException {
        //marry up
        p = pf.edit(p);
        a = af.edit(a);

        //business logic
        p.getHome().getOccupants().remove(p);
        p.setHome(a);
        a.getOccupants().add(p);

        //return something
        return p;
    }
}
