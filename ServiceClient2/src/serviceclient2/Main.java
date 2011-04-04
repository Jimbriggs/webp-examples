/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package serviceclient2;

import jim.ws.User;
import jim.ws.Validator;
import jim.ws.ValidatorService;
import jim.ws.doubler.Doubler;
import jim.ws.doubler.DoublerService;

/**
 *
 * @author briggsj
 */
public class Main {

    public static void main(String[] args) {
        User u = new User();
        u.setForename("Jim");
        u.setLastname(null);

        Validator v = new ValidatorService().getValidatorPort();
        boolean b = v.validate(u);
        System.out.println("Valid: " + b);

        String s = v.capitalise("hello");
        System.out.println("Capitalised: " + s);

        String i = v.randomise();
        System.out.println("Random: " + i);

        Doubler d = new DoublerService().getDoublerPort();
        s = d.doubler(Integer.parseInt(i));
        System.out.println("Doubler: " + s);
    }

}
