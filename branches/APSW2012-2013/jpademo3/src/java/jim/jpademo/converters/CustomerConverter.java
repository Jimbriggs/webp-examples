/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.jpademo.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import jim.jpademo.entities.Customer;
import jim.jpademo.managed.CustomerBean;

/**
 *
 * @author BriggsJ
 */
@FacesConverter(value="customerConverter")
public class CustomerConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.isEmpty()) {
            return null;
        }
        Long num = new Long(value);
        CustomerBean ab = (CustomerBean) context.getApplication().getELResolver().getValue(context.getELContext(), null, "customerBean");
        Customer customer = ab.getFacade().find(num);
        return customer;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Customer) {
            Customer c = (Customer)value;
            return c.getId().toString();
        } else {
            return "";
        }
    }

}
