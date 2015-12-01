/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.entwa.ctrl;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import jim.entwa.ent.Address;
import jim.entwa.pers.AddressFacade;

/**
 *
 * @author BriggsJ
 */
@FacesConverter(forClass = Address.class)
public class AddressConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        AddressBean addrCtrl = (AddressBean) facesContext.getApplication().getELResolver().
                getValue(facesContext.getELContext(), null, "addressBean");
        AddressFacade af = addrCtrl.getFacade();
        Long id = Long.decode(value);
        Address a = af.find(id);
        return a;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Address) {
            return ((Address) value).getId().toString();
        } else {
            throw new Error("object is not of type Address");
        }
    }

}
