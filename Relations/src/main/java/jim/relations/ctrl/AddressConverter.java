/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.relations.ctrl;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import jim.relations.ent.Address;
import jim.relations.pers.AddressFacade;
import jim.util.EJBlookup;

/**
 *
 * @author Jim Briggs
 */
@FacesConverter(forClass = Address.class)
public class AddressConverter implements Converter {

    //An @EJB annotation won't work here in JSF2.2 because this is not a "managed bean" so the container can't inject anything.
    //Therefore, we have to grab the AddressFacade object manually.
    //I understand that this will be fixed in JSF2.3.
    private AddressFacade af = EJBlookup.lookup(AddressFacade.class);
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Long lId = Long.parseLong(string);
        Address a = af.find(lId);
        if (a == null) {
            //report error
            FacesMessage error = new FacesMessage("Address object with primary key " + string + " not found");
            fc.addMessage("", error);
        }
        return a;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Address a = (Address)t;
        return a.getId().toString();
    }
    
}
