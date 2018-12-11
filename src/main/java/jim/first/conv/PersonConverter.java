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
import jim.first.ent.Person;
import jim.first.pers.PersonFacade;

/**
 *
 * @author briggsj
 */
@FacesConverter(forClass = Person.class)
public class PersonConverter implements javax.faces.convert.Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Long id = new Long(value);
        PersonFacade pf = CDI.current().select(PersonFacade.class).get();
        Person p = pf.find(id);
        return p;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Person p = (Person) value;
        return p.getId().toString();
    }

}
