/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.firstee.bus;

import javax.ejb.Stateless;

/**
 *
 * @author Jim Briggs
 */
@Stateless
public class DoubleService {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public Integer doubler (Integer num) {
        return num*2;
    }
}
