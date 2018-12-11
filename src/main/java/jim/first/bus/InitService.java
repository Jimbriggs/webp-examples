/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.first.bus;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import jim.first.ent.Address;
import jim.first.pers.AddressFacade;

/**
 *
 * @author briggsj
 */
@Stateless
public class InitService {

    @EJB
    private AddressFacade af;
    
    static private String cities[] = {"Portsmouth", "London"};
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void init() {
        for (String s: cities) {
            Address a = new Address();
            a.setCity(s);
            af.create(a);
        }
    }
}
