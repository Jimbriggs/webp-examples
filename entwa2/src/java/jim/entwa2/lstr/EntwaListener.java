/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.entwa2.lstr;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import jim.entwa2.bus.BusinessException;
import jim.entwa2.bus.InitService;

/**
 * Web application lifecycle listener.
 *
 * @author BriggsJ
 */
public class EntwaListener implements ServletContextListener {

    @EJB
    private InitService is;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            is.initialise();
        } catch (BusinessException ex) {
            Logger.getLogger(EntwaListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
