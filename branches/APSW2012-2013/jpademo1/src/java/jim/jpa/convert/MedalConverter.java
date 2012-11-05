/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.jpa.convert;

import java.util.ArrayList;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import jim.jpa.entities.Medal;

/**
 *
 * @author briggsj
 */
public class MedalConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.equalsIgnoreCase("gold")) {
            return Medal.GOLD;
        } else if (value.equalsIgnoreCase("silver")) {
            return Medal.SILVER;
        } else if (value.equalsIgnoreCase("bronze")) {
            return Medal.BRONZE;
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Medal medal = (Medal) value;
        if (medal.equals(Medal.GOLD)) {
            return "Gold";
        } else {
            return "";
        }
    }

    public static List<Medal> returnAllMedals() {
        List<Medal> medalList = new ArrayList<Medal>();
        medalList.add(Medal.GOLD);
        medalList.add(Medal.SILVER);
        medalList.add(Medal.BRONZE);
        return medalList;
    }
}
