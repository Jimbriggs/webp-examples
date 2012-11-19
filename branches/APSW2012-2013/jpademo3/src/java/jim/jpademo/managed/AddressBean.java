/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.jpademo.managed;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import jim.jpademo.bus.BusinessException;
import jim.jpademo.bus.CustomerService;
import jim.jpademo.entities.Address;
import jim.jpademo.facades.AddressFacade;

/**
 *
 * @author BriggsJ
 */
@ManagedBean
@RequestScoped
public class AddressBean extends AbstractBean<Address, AddressFacade> {

    @EJB
    private CustomerService cs;
    @EJB
    private AddressFacade af;

    @Override
    public AddressFacade getFacade() {
        return af;
    }

    public String doAddAddress() {
        try {
            cs.createAddress(newItem);
        } catch (BusinessException ex) {
            Logger.getLogger(AddressBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    /**
     * Creates a new instance of AddressBean
     */
    public AddressBean() {
        super(Address.class);
    }

}
