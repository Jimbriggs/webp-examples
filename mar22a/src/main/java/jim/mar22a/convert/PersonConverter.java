/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jim.mar22a.convert;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.spi.BeanManager;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import jim.mar22a.ent.Person;
import jim.mar22a.pers.PersonFacade;

/**
 *
 * @author Jim Briggs
 */
@Dependent
@FacesConverter(value = "PersonConverter", managed = true)
public class PersonConverter implements Converter {

    @Inject
    private BeanManager beanManager;

    public String getAsString(FacesContext fc, UIComponent ui, Object value) {
        if (value instanceof Person) {
            Person p = (Person) value;
            return p.getId().toString();
        } else if (value instanceof Long) {
            return value.toString();
        } else {
            throw new Error("PersonConverter value is not a Person: " + value);
        }
    }

    @Inject
    private PersonFacade pf;

    public Object getAsObject(FacesContext fc, UIComponent ui, String value) {
        if (!value.isEmpty()) {
            Long id = new Long(value);
            try {
                Person p = pf.find(id);
                return p;
            } catch (Exception ex) {
                FacesMessage msg = new FacesMessage(ex.getMessage());
                fc.addMessage(ui.getId(), msg);
                return null;
            }
        } else {
            throw new Error("PersonConverter value does not represent a Person: " + value);
        }
    }

}
