/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.entwa1.ctrl;

import java.util.Calendar;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import jim.entity.Money;

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

    private String ageGroup = "0-17";

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    private String[] allAges = {"0-17", "18-21", "22-99"};

    public String[] getAllAges() {
        return allAges;
    }

    public void setAllAges(String[] allAges) {
        this.allAges = allAges;
    }

    private Calendar cal = Calendar.getInstance();

    public Calendar getCal() {
        return cal;
    }

    public void setCal(Calendar cal) {
        this.cal = cal;
    }

    public Date getCalDate() {
        return cal.getTime();
    }

    public void setCalDate(Date d) {
        cal.setTime(d);
    }

    public String doName() {
        return "";
    }

    private Money cash;

    public Money getCash() {
        return cash;
    }

    public void setCash(Money cash) {
        this.cash = cash;
    }


}
