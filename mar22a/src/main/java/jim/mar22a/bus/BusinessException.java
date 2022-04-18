/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jim.mar22a.bus;

/**
 *
 * @author Jim Briggs
 */
public class BusinessException extends Exception {

    public BusinessException() {
    }

    public BusinessException(String string) {
        super(string);
    }

    public BusinessException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
    
}
