/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.apsw2.ctrl;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author BriggsJ
 */
@Named(value = "secondCtrl")
@RequestScoped
public class SecondCtrl {

    /**
     * Creates a new instance of secondCtrl
     */
    public SecondCtrl() {
    }

    private String name = "fred";
    private String longname = "tom";
    private String menuSelection;
    private String[] menuChoices = {"Bob", "billy", "Gary", "Fred"};

    public String[] getMenuChoices() {
        return menuChoices;
    }

    public void setMenuChoices(String[] menuChoices) {
        this.menuChoices = menuChoices;
    }

    public String getMenuSelection() {
        return menuSelection;
    }

    public void setMenuSelection(String menuSelection) {
        this.menuSelection = menuSelection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongname() {
        return longname;
    }

    public void setLongname(String longname) {
        this.longname = longname;
    }

    public String doSomething() {
        longname = menuSelection;
        return "";
    }
}
