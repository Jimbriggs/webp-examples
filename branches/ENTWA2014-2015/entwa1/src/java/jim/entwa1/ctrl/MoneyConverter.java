/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.entwa1.ctrl;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import jim.entity.Money;

/**
 *
 * @author BriggsJ
 */
@FacesConverter(forClass = jim.entity.Money.class, value = "moneyConverter")
public class MoneyConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Double d = Double.parseDouble(value) * 100;
        long l = d.longValue();
        Money m = new Money();
        m.setValue(l);
        return m;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Money) {
            Money cash = (Money)value;
            return cash.getValue() / 100 + "." + cash.getValue() % 100;
        } else {
            throw new Error("something bad happened");
        }
    }

}
