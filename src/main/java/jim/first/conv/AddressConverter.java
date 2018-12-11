/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.first.conv;

import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import jim.first.ent.Address;
import jim.first.pers.AddressFacade;

/**
 *
 * @author briggsj
 */
@FacesConverter(forClass = Address.class)
public class AddressConverter implements javax.faces.convert.Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Long id = new Long(value);
        AddressFacade pf = CDI.current().select(AddressFacade.class).get();
        Address p = pf.find(id);
        return p;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Address p = (Address) value;
        return p.getId().toString();
    }

}
