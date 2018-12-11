/*
 * PumsApp.java
 *
 * Created on 02 May 2005, 22:42
 */

package jim.pums;

import jim.common.*;

/**
 *
 * @author  briggsj
 */
public class PumsApp extends jim.common.BaseApplication {
    
    private static PumsApp pums = null;
    
    /** Creates a new instance of PumsApp */
    public PumsApp() {
    }
    
    public java.lang.String getBundleName() {
        return "resources/pums";
    }
 
    public static PumsApp getInstance() {
        if (pums == null) {
            pums = new PumsApp();
        }
        return pums;
    }
}
