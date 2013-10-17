/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.ws3;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author BriggsJ
 */
@WebService(serviceName = "Doubler")
public class Doubler {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    public Integer twice (Integer value) {
        return 2 * value;
    }
}
