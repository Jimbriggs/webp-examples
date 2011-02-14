/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.ctrl.conv;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import jim.entities.Address;
import jim.facades.AddressFacade;

/**
 *
 * @author briggsj
 */
@Stateless
@FacesConverter(value = "AddressConverter")
public class AddressConverter implements javax.faces.convert.Converter {

    @EJB
    private AddressFacade af;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Address a = af.find(Long.parseLong(value));
        return a;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof String) {
            return (String) value;
        } else {
            return value.toString();
        }
    }
}
