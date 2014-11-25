/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.entwa2.bus;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import jim.entwa2.ent.Address;
import jim.entwa2.ent.UserPerson;
import jim.entwa2.pers.AddressFacade;
import jim.entwa2.pers.UserPersonFacade;

/**
 *
 * @author BriggsJ
 */
@Stateless
public class InitService {

    @EJB
    private UserPersonFacade upf;
    @EJB
    private AddressFacade af;

    public List<UserPerson> initialise() throws BusinessException {
        if (upf.count() <= 30) {
            List<UserPerson> ul = upf.createInitialData();
            List<Address> al = af.createInitialData();

            Address addr = al.get(0);
            for (UserPerson up : ul) {
                up.setHome(addr);
                addr.getResidents().add(up);
            }
            return ul;
        } else {
            return null;
        }
    }
}
