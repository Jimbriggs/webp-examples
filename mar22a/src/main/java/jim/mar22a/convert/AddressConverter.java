/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jim.mar22a.convert;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.spi.BeanManager;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import jim.mar22a.ent.Address;
import jim.mar22a.pers.AddressFacade;

/**
 *
 * @author Jim Briggs
 */
@Dependent
@FacesConverter(value = "AddressConverter", managed = true)
public class AddressConverter implements Converter {

    @Inject
    private BeanManager beanManager;

    public String getAsString(FacesContext fc, UIComponent ui, Object value) {
        if (value instanceof Address) {
            Address a = (Address) value;
            return a.getId().toString();
        } else if (value instanceof Long) {
            return value.toString();
        } else {
            throw new Error("AddressConverter value is not an Address: " + value);
        }
    }

    @Inject
    private AddressFacade af;

    public Object getAsObject(FacesContext fc, UIComponent ui, String value) {
        if (!value.isEmpty()) {
            Long id = new Long(value);
            Address a = af.find(id);
            return a;
        } else {
            throw new Error("AddressConverter value does not represent an Address: " + value);
        }
    }

}
