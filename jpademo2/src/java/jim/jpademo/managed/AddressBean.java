/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.jpademo.managed;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import jim.jpademo.bus.BusinessException;
import jim.jpademo.bus.CustomerService;
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
    @EJB
    private CustomerService cs;

    @Override
    public AddressFacade getFacade() {
        return af;
    }

    public AddressBean() {
        super(Address.class);
    }

    public String addItem() {
        try {
            cs.createAddress(newItem);
        } catch (BusinessException ex) {
            Logger.getLogger(AddressBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
