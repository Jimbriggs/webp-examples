package jim.apsw151.ctrl;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import jim.apsw151.pers.AbstractFacade;

/**
 *
 * @author briggsj
 * @param <T>
 * @param <Facade>
 */
public abstract class AbstractController<T, Facade extends AbstractFacade> extends MessageController {

    private Class<T> entityClass;

    public AbstractController() {
    }

    protected AbstractController(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    protected T current = null;
    protected T newItem = null;
    protected DataModel<T> items = null;

    public DataModel<T> getItems() {
        if (items == null) {
            items = new ListDataModel<>((List<T>) getFacade().findAll());
        }
        return items;
    }

    public void setItems(DataModel<T> itemList) {
        this.items = itemList;
    }

    public void setItems(List<T> itemlist) {
        this.items = new ListDataModel<>(itemlist);
    }

    public T getCurrent() {
        if (current == null) {
            DataModel<T> l = getItems();
            if (l.isRowAvailable()) {
                current = getItems().getRowData();
            } else {
                current = getNewItem();
            }
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
