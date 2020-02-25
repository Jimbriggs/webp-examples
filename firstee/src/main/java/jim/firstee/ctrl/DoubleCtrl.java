/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.firstee.ctrl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import jim.firstee.bus.DoubleService;
import jim.firstee.bus.PersonService;
import jim.firstee.ent.Person;

/**
 *
 * @author Jim Briggs
 */
@Named(value = "doubleCtrl")
@SessionScoped
public class DoubleCtrl implements Serializable {

    /**
     * Creates a new instance of DoubleCtrl
     */
    public DoubleCtrl() {
    }
    
    private Integer number = 0;
    private Integer result = 73;
    private List<Integer> numList = new ArrayList<>();

    public List<Integer> getNumList() {
        return numList;
    }

    public void setNumList(List<Integer> numList) {
        this.numList = numList;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
    
    @EJB
    private DoubleService ds;
    @EJB
    private PersonService ps;
    
    public String doDouble() {
        result = ds.doubler(number);
        numList.add(result);
        Person p = new Person();
        p.setName(number.toString());
        p = ps.createNewPerson(p);
        return "";
    }
    
    
}
