/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.ctrl;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import jim.facades.AbstractFacade;

/**
 *
 * @author briggsj
 */
@ManagedBean
@RequestScoped
public abstract class AbstractController<T, Facade extends AbstractFacade> extends MessageController {

    private Class<T> entityClass;

    private AbstractController() {
    }

    protected AbstractController(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    protected T current = null;
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

    public void setCurrent(T current) {
        this.current = current;
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
