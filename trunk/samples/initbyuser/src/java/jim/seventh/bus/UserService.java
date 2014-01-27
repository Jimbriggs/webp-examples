/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.seventh.bus;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import jim.seventh.entities.LoginUser;
import jim.seventh.facades.LoginUserFacade;

/**
 *
 * @author BriggsJ
 */
@Stateless
public class UserService {

    @EJB
    private LoginUserFacade uf;

    public LoginUser addUser(LoginUser user) throws BusinessException {
        if (uf.find(user.getId()) == null) {
            uf.create(user);
        } else {
            throw new BusinessException("User " + user.getId() + " already exists");
        }
        return user;
    }

    public List<LoginUser> getInitialUsers() {
        List<LoginUser> list = new ArrayList<>();
        final String[] allusers = {"jim", "fred"};
        for (String s : allusers) {
            LoginUser u = new LoginUser();
            u.setId(s);
            list.add(u);
        }
        return list;
    }

    public void initUsers() throws BusinessException {
        if (uf.count() == 0) {
            for (LoginUser u : getInitialUsers()) {
                addUser(u);
            }
        }
    }

    public List<LoginUser> getAllUsers() {
        return uf.findAll();
    }
}
