/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.airline.listener;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import jim.airline.bus.InitialiseService;

/**
 * Web application lifecycle listener.
 *
 * @author briggsj
 */
@WebListener()
public class InitialiseDatabase implements ServletContextListener {

    @EJB private InitialiseService is;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        is.initialise();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //nothing to do
    }
}
