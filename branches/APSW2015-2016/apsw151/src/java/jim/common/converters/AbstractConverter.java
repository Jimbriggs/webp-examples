package jim.common.converters;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import jim.apsw151.ctrl.AbstractController;
import jim.apsw151.pers.AbstractFacade;



/**
 *
 * @author BriggsJ
 * @param <T>
 * @param <Facade>
 * @param <Controller>
 */
public abstract class AbstractConverter<T extends Convertable, Facade extends AbstractFacade, Controller extends AbstractController> implements Converter {

    private final Class<T> entityClass;
    private final Class<Facade> facadeClass;
    private final Class<Controller> controllerClass;

    public AbstractConverter(Class<T> entityClass, Class<Facade> facade, Class<Controller> controller) {
        this.entityClass = entityClass;
        this.facadeClass = facade;
        this.controllerClass = controller;
    }

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        String controllerName = controllerClass.getSimpleName();
        controllerName = Character.toLowerCase(controllerName.charAt(0)) + (controllerName.length() > 1 ? controllerName.substring(1) : "");
        Controller controller = (Controller) facesContext.getApplication().getELResolver().
                getValue(facesContext.getELContext(), null, controllerName);
        if (controller == null) {
            throw new Error("Cannot find controller: " + controllerName);
        }
        Facade af = (Facade) controller.getFacade();
        T a = (T) af.find(getKey(value));
        return a;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
        if (object == null) {
            return null;
        } else if (object instanceof String) {
            return (String) object;
        } else if (object instanceof Long) {
            return ((Long)object).toString();
        } else if (object instanceof Convertable) {
            T o = (T) object;
            return getStringKey(o.getId());
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + entityClass.getName());
        }
    }

    public static Long getKey(String value) {
        Long key;
        key = Long.parseLong(value);
        return key;
    }

    public static String getStringKey(Long value) {
        StringBuilder sb = new StringBuilder();
        sb.append(value.toString());
        return sb.toString();
    }

}
