/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.seventh.ctrl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import jim.seventh.bus.BusinessException;
import jim.seventh.bus.UserService;
import jim.seventh.entities.LoginUser;

/**
 *
 * @author BriggsJ
 */
@Named(value = "userController")
@RequestScoped
public class UserController extends MessageController {

    /**
     * Creates a new instance of UserController
     */
    public UserController() {
    }

    @EJB
    private UserService us;

    public String initUsers() {
        try {
            us.initUsers();
        } catch (BusinessException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            addError("Cannot initialise database with users");
        }
        return "";
    }

    private List<LoginUser> allUsers = new ArrayList<>();

    public List<LoginUser> getAllUsers() {
        return us.getAllUsers();
    }


}
