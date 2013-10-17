/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yang.sum.business;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import yang.sum.entity.Students;
import yang.sum.facades.AbstractFacade;
import yang.sum.facades.StudentsFacade;


/**
 *
 * @author yang
 */
@Stateless
public class StudentService {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @EJB
    private StudentsFacade sf;

    public StudentsFacade getSf() {
        return sf;
    }

    // This method return a void to replicate the facade bahavior
    
   
    public void createStudents(Students student) {
     
        sf.create(student);
    }   
}
