/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.ctrl;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import jim.bus.SecureLogic;

/**
 *
 * @author briggsj
 */
@Named(value = "secureController")
@RequestScoped
public class SecureController {

    /**
     * Creates a new instance of SecureController
     */
    public SecureController() {
    }
    
    private String word = "nothing";
    private String username = "";
    private String password = "";

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @EJB
    private SecureLogic sl;
    
    public String doSecure() {
        
        word = sl.secureMethod(username, password);
        if (word == null) {
            word = "failure";
        }
        return "";
    }
}
