/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.entwa.ctrl;

import java.util.Set;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import jim.entwa.bus.PersonService;
import jim.entwa.ent.Address;
import jim.entwa.pers.AddressFacade;

/**
 *
 * @author BriggsJ
 */
@Named(value = "addressBean")
@RequestScoped
public class AddressBean {

    /**
     * Creates a new instance of AddressBean
     */
    public AddressBean() {
    }

    @EJB
    private AddressFacade af;
    @EJB
    private PersonService ps;

    public Set<Address> getAllAddresses() {
        return ps.findAllAddresses();
    }

    public AddressBean(PersonService ps) {
        this.ps = ps;
    }

    public AddressFacade getFacade() {
        return af;
    }
}
