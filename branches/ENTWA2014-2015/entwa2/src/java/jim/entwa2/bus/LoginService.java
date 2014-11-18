/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.entwa2.bus;

import javax.annotation.PreDestroy;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 *
 * @author BriggsJ
 */
@Stateful
public class LoginService {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    private String loggedinUsername = "unknown";

    public String getLoggedinUsername() {
        return loggedinUsername;
    }

    public void setLoggedinUsername(String loggedinUsername) {
        this.loggedinUsername = loggedinUsername;
    }

    public String login(String username) throws BusinessException {
        loggedinUsername = username;
        return username;
    }

    @Remove
    public String logout() throws BusinessException {
        loggedinUsername = "unknown";
        return loggedinUsername;
    }
}
