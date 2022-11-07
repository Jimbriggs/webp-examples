/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package jim.adamproj5.ctrl;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import jim.adamproj5.bus.StartService;

/**
 *
 * @author Jim Briggs
 */
@Named(value = "starter")
@RequestScoped
public class Starter {

    /**
     * Creates a new instance of Starter
     */
    public Starter() {
    }

    private String startword = "start";

    public String getStartword() {
        return startword;
    }

    public void setStartword(String startword) {
        this.startword = startword;
    }

    @EJB
    private StartService ss;

    public String doStart() {
        startword = startword + "!";
        startword = ss.startStarting(startword);
        return "";
    }
}
