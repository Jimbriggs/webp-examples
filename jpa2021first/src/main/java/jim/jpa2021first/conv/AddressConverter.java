/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.jpa2021first.conv;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import jim.jpa2021first.ent.Address;
import jim.jpa2021first.pers.AddressFacade;

/**
 *
 * @author Jim Briggs
 */
@FacesConverter(forClass = Address.class)
public class AddressConverter implements Converter {

    @Inject
    private AddressFacade af;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Long id = Long.parseLong(string);
        if (af == null) {
            return null;
        }
        Address a = af.find(id);
        return a;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Address a = (Address)t;
        return a.getId().toString();
    }
    
}
