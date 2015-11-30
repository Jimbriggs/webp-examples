/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.apsw151.ctrl;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import jim.apsw151.ents.Address;
import jim.apsw151.pers.AddressFacade;

/**
 *
 * @author BriggsJ
 */
@Named(value = "addressBean")
@RequestScoped
public class AddressBean extends AbstractController<Address, AddressFacade> {

    @EJB
    private AddressFacade af;

    /**
     * Creates a new instance of AddressBean
     */
    public AddressBean() {
    }

    @Override
    public AddressFacade getFacade() {
        return af;
    }

}
