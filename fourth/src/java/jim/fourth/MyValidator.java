/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.fourth;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author BriggsJ
 */
@FacesValidator
public class MyValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value instanceof String) {
            String strvalue = (String) value;
            if (strvalue == null || strvalue.isEmpty()) {
                FacesMessage fm = new FacesMessage("input is empty");
                throw new ValidatorException(fm);
            }
        } else {
            throw new ValidatorException(new FacesMessage("Wrong type"));
        }
    }

}
