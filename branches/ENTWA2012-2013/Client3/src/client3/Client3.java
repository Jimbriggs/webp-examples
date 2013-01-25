/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package client3;

import client3a.*;

/**
 *
 * @author BriggsJ
 */
public class Client3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer temp = new Integer(7);
        System.out.println(twice(temp));
    }

    private static Integer twice(java.lang.Integer arg0) {
        client3a.Doubler_Service service = new client3a.Doubler_Service();
        client3a.Doubler port = service.getDoublerPort();
        return port.twice(arg0);
    }
}
