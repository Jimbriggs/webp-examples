/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.common.converters;

import javax.faces.convert.FacesConverter;
import jim.apsw151.ctrl.AddressBean;
import jim.apsw151.ents.Address;
import jim.apsw151.pers.AddressFacade;

/**
 *
 * @author BriggsJ
 */
@FacesConverter(forClass = Address.class)
public class AddressConverter extends AbstractConverter<Address, AddressFacade, AddressBean> {

    public AddressConverter(Class<Address> entityClass, Class<AddressFacade> facade, Class<AddressBean> controller) {
        super(entityClass, facade, controller);
    }

}
