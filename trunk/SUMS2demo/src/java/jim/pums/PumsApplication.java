/*
 * PumsApplication.java
 *
 * Created on 17 August 2004, 16:54
 */

package jim.pums;

import java.sql.*;
import java.util.ResourceBundle;
import javax.naming.*;
import javax.sql.*;
import jim.common.*;
import jim.util.*;

/**
 * 
 * @author briggsj
 * @deprecated Use {@link PumsApp} instead.
 */
public class PumsApplication extends BaseApplication {
    
 
    /** Creates a new instance of PumsApplication */
    protected PumsApplication() {
        super();
    }
    
    public String getName() {
        return "PUMS";
    }
        


    public String getBundleName() {
        return "pums";
    }

    static private PumsApplication instance = null;
    
    public static BaseApplication getInstance() {
        if (instance == null) {
            instance = new PumsApplication();
        }
        return instance;
    }
    
}
