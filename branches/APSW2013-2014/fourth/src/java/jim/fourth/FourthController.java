/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.fourth;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author BriggsJ
 */
@Named(value = "fourthController")
@RequestScoped
public class FourthController {

    /**
     * Creates a new instance of FourthController
     */
    public FourthController() {
    }

    private String name = "Fred";
    private String newName = "Steve";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String doChangeName () {
        setName(getNewName());
        return "";
    }
}
