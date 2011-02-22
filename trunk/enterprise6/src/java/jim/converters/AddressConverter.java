/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import jim.ctrl.AddressController;
import jim.entities.Address;
import jim.facades.AddressFacade;

/**
 *
 * @author briggsj
 */
@FacesConverter(forClass = Address.class)
public class AddressConverter implements javax.faces.convert.Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        AddressController controller = (AddressController) facesContext.getApplication().getELResolver().
                getValue(facesContext.getELContext(), null, "myAddressController");
        AddressFacade af = controller.getFacade();
        Address a = af.find(Long.parseLong(value));
        return a;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Address) {
            Address o = (Address) object;
            return getStringKey(o.getId());
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + AddressController.class.getName());
        }
    }

    public Long getKey(String value) {
        Long key;
        key = Long.valueOf(value);
        return key;
    }

    public String getStringKey(Long value) {
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        return sb.toString();
    }
}
