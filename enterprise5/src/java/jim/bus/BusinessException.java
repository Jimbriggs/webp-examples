/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jim.bus;

/**
 *
 * @author briggsj
 */
public class BusinessException extends Exception {

    /**
     * Creates a new instance of <code>BusinessException</code> without detail message.
     */
    public BusinessException() {
    }


    /**
     * Constructs an instance of <code>BusinessException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public BusinessException(String msg) {
        super(msg);
    }
}
