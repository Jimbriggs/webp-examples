/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.entwa2.ctrl;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import jim.entwa2.bus.BusinessException;
import jim.entwa2.bus.UserService;
import jim.entwa2.ent.UserPerson;

/**
 *
 * @author BriggsJ
 */
@Named(value = "userController")
@RequestScoped
public class UserController {

    /**
     * Creates a new instance of UserController
     */
    public UserController() {
    }

    private UserPerson up = new UserPerson();

    public UserPerson getUp() {
        return up;
    }

    public void setUp(UserPerson up) {
        this.up = up;
    }

    @EJB
    private UserService us;

    public String doAddUser() {
        try {
            us.addUser(up);
        } catch (BusinessException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            FacesMessage fm = new FacesMessage(ex.getMessage());
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
        return "";
    }
}
