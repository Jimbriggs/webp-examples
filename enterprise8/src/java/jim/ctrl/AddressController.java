/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.ctrl;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import jim.entities.Address;
import jim.facades.AddressFacade;

/**
 *
 * @author briggsj
 */
@ManagedBean
@RequestScoped
public class AddressController extends AbstractController<Address, AddressFacade> {

    public AddressController() {
        super(Address.class);
    }
    @EJB
    private AddressFacade facade;

    @Override
    public AddressFacade getFacade() {
        return facade;
    }
}
