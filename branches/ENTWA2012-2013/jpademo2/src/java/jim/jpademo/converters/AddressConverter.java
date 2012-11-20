/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.jpademo.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import jim.jpademo.entities.Address;
import jim.jpademo.managed.AddressBean;

/**
 *
 * @author BriggsJ
 */
@FacesConverter(value="addressConverter")
public class AddressConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Long num = new Long(value);
        AddressBean ab = (AddressBean) context.getApplication().getELResolver().getValue(context.getELContext(), null, "addressBean");
        Address address = ab.getFacade().find(num);
        return address;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Address) {
            Address a = (Address)value;
            return a.getId().toString();
        } else {
            return "";
        }
    }

}
