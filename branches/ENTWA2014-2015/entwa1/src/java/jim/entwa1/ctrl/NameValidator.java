/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.entwa1.ctrl;

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
public class NameValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String str = (String) value;
        if (str.contains("abc")) {
            return;
        }
        FacesMessage msg = new FacesMessage("String does not contain abc");
        throw new ValidatorException(msg);
    }

}
