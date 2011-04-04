/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.ws;

import java.util.Random;
import javax.jws.WebService;

/**
 *
 * @author briggsj
 */
@WebService
public class Validator {

    public boolean validate(User user) {
        return user.getForename() != null && user.getLastname() != null;
    }

    public String capitalise (String text) {
        return text.toUpperCase();
    }

    public String randomise() {
        return Integer.toString(new Random().nextInt(256));
    }
}
