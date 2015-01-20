/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.tiny;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author briggsj
 */
@ManagedBean
@RequestScoped
public class exampleBean {

    /** Creates a new instance of exampleBean */
    public exampleBean() {
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
//        return text.length();
        return length;
    }

    public void countListener(AjaxBehaviorEvent event) {
        length = text.length();
    }
}
