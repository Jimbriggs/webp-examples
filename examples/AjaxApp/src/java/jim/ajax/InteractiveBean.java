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
//        length = text.length();
    }

    private Integer length = 0;

    public Integer getLength() {
        return text.length();
    }

    public void countListener(AjaxBehaviorEvent event) {
//        length = text.length();
    }

    public boolean isShowlength() {
        return text.length() > 6;
    }
}
