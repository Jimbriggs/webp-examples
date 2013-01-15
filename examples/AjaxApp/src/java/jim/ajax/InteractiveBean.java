/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.ajax;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author briggsj
 */
@ManagedBean
@RequestScoped
public class InteractiveBean {

    /** Creates a new instance of InteractiveBean */
    public InteractiveBean() {
    }
    String text = "Hello ";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    private Integer length;

    public Integer getLength() {
        return length;
    }

    public void countListener(AjaxBehaviorEvent event) {
        length = text.length();
    }
}
