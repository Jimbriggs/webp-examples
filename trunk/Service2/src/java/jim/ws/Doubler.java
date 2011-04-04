/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.ws;

import javax.jws.WebService;

/**
 *
 * @author briggsj
 */
@WebService()
public class Doubler {

    public String doubler(Integer number) {
        return Integer.toString(2* number);
    }
}
