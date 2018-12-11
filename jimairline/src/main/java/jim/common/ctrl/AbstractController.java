/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.common.ctrl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import jim.common.facades.AbstractFacade;

/**
 *
 * @author briggsj
 * @param <T>
 * @param <Facade>
 */
public abstract class AbstractController<T, Facade extends AbstractFacade> extends MessageController {

    private Class<T> entityClass;

    private AbstractController() {
    }

    protected AbstractController(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    protected T current = null;
    protected T newItem = null;
    protected DataModel<T> items = null;

    public DataModel<T> getItems() {
        if (items == null) {
            items = new ListDataModel<T>(getFacade().findAll());
        }
        return items;
    }

    public void setItems(DataModel<T> addressList) {
        this.items = addressList;
    }

    public T getCurrent() {
        if (current == null) {
            current = getItems().getRowData();
        }
        return current;
    }

    public T getNewItem() {
        if (newItem == null) {
            try {
                newItem = entityClass.newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(AbstractController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(AbstractController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return newItem;
    }

    public void setCurrent(T current) {
        this.current = current;
    }

    public void setNewItem(T newItem) {
        this.newItem = newItem;
    }

    public abstract Facade getFacade();

    public static SelectItem[] getSelectItems(List<?> entities, boolean selectOne) {
        int size = selectOne ? entities.size() + 1 : entities.size();
        SelectItem[] items = new SelectItem[size];
        int i = 0;
        if (selectOne) {
            items[0] = new SelectItem("", "---");
            i++;
        }
        for (Object x : entities) {
            items[i++] = new SelectItem(x, x.toString());
        }
        return items;
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return getSelectItems(getFacade().findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return getSelectItems(getFacade().findAll(), true);
    }
}
