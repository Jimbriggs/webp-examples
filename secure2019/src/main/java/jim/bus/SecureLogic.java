/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.bus;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 *
 * @author briggsj
 */
@Stateless
public class SecureLogic {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    //@RolesAllowed("staff")
    public String secureMethod(String username, String password) {
        if (username.equalsIgnoreCase(password)) {
            return username;
        } else {
            return null;
        }
       
    }
}
