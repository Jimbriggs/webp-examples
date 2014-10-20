/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.entwa1.ctrl;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author BriggsJ
 */
@Named(value = "nameBean")
@RequestScoped
public class NameBean {

    /**
     * Creates a new instance of NameBean
     */
    public NameBean() {
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String doName() {
        return "";
    }

}
