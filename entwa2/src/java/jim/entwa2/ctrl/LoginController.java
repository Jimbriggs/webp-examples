/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.entwa2.ctrl;

import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import jim.entwa2.bus.BusinessException;
import jim.entwa2.bus.LoginService;

/**
 *
 * @author BriggsJ
 */
@Named(value = "loginController")
@RequestScoped
public class LoginController implements Serializable {

    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @EJB
    private LoginService ls;

    private String username;

    public String doLogin() {
        try {
            ls.login(username);
        } catch (BusinessException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "view/adduser";
    }

    public String doLogout() {
        try {
            ls.logout();
        } catch (BusinessException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public String getLoggedinUsername() {
        return ls.getLoggedinUsername();
    }
}
