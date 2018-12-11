/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.first.ctrl;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import jim.first.bus.InitService;

/**
 *
 * @author briggsj
 */
@Named(value = "initCtrl")
@RequestScoped
public class InitCtrl {

    @EJB
    private InitService is;
    
    /**
     * Creates a new instance of InitCtrl
     */
    public InitCtrl() {
    }
    
    public String initialise() {
        is.init();
        return "";
    }
}
