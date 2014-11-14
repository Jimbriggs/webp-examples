/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.entwa2.ctrl;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import jim.entwa2.ent.Address;

/**
 *
 * @author BriggsJ
 */
@FacesConverter(forClass = Address.class)
public class AddressConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Long l = Long.parseLong(value);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        UserController uc = (UserController)facesContext.getApplication().getELResolver().
                getValue(facesContext.getELContext(), null, "userController");
        Address a = uc.getUs().findAddressById(l);
        return a;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Address) {
            Address a = (Address)value;
            return a.getId().toString();
//            return a.getCity();
        } else {
            throw new Error("Wrong type");
        }
    }



}
