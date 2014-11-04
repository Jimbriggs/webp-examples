/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.entwa2.bus;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import jim.entwa2.ent.UserPerson;
import jim.entwa2.pers.UserPersonFacade;

/**
 *
 * @author BriggsJ
 */
@Stateless
public class UserService {

    @EJB
    private UserPersonFacade upf;

    public UserPerson addUser(UserPerson up) throws BusinessException {
        //search for people with same name
        List<UserPerson> list = upf.findUsersByName(up.getForename(), up.getSurname());
        if (list.isEmpty()) {
            upf.create(up);
        } else {
            throw new BusinessException("User with name already exists " + up.getForename() + " " + up.getSurname());
        }

        return up;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
