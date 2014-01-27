/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.seventh.startup;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import jim.seventh.bus.BusinessException;
import jim.seventh.bus.UserService;

/**
 * Web application lifecycle listener.
 *
 * Note that this class is registered as a ContextListener in web.xml
 *
 * @author BriggsJ
 */
public class StartupListener implements ServletContextListener {

    @EJB
    private UserService us;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //This code will be executed every time the application starts
        try {
            us.initUsers();
        } catch (BusinessException ex) {
            Logger.getLogger(StartupListener.class.getName()).log(Level.SEVERE, null, ex);
            //Note there is no error message you can cause to be displayed now.
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //do nothing
    }
}
