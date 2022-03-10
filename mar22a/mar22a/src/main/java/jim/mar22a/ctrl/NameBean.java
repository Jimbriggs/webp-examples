/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package jim.mar22a.ctrl;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import jim.mar22a.bus.NameService;

/**
 *
 * @author Jim Briggs
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

    private String city;

    /**
     * Get the value of city
     *
     * @return the value of city
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the value of city
     *
     * @param city new value of city
     */
    public void setCity(String city) {
        this.city = city;
    }

    @EJB
    private NameService ns;

    public String doNameUpdate() {
        this.setName(ns.processName(name));
        return "";
    }

}
