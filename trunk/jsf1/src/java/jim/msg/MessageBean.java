/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.msg;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.mail.Session;

/**
 *
 * @author BriggsJ
 */
@ManagedBean
@RequestScoped
public class MessageBean {
    private String message = "nobody";
    private String newMessage;

    /**
     * Creates a new instance of MessageBean
     */
    public MessageBean() {
    }

    /**
     * Get the value of message
     *
     * @return the value of message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set the value of message
     *
     * @param message new value of message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    public String doHelloWorld() {
        setMessage("world");
        return "";
    }

    /**
     * Get the value of newMessage
     *
     * @return the value of newMessage
     */
    public String getNewMessage() {
        return newMessage;
    }

    /**
     * Set the value of newMessage
     *
     * @param newMessage new value of newMessage
     */
    public void setNewMessage(String newMessage) {
        this.newMessage = newMessage;
    }
    
    public String doNewMessage() {
        setMessage(getNewMessage());
        return "";
    }
}
