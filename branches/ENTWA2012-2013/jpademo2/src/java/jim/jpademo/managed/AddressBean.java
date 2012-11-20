/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.jpademo.managed;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import jim.jpademo.entities.Address;
import jim.jpademo.facades.AddressFacade;


/**
 *
 * @author BriggsJ
 */
@ManagedBean
public class AddressBean extends AbstractBean<Address, AddressFacade> {

    @EJB
    private AddressFacade af;

    @Override
    public AddressFacade getFacade() {
        return af;
    }

    public AddressBean() {
        super(Address.class);
    }
    
}
