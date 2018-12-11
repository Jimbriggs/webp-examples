/*
 * UserService.java
 *
 * Created on 27 September 2005, 14:19
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package steve.pums.assess.process;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import jim.util.SqlUtils;
import steve.pums.assess.bus.PersonBean;

/**
 *
 * @author briggsj
 */
public class UserService {
    
    /**
     * Creates a new instance of UserService
     */
    private UserService() {
    }
    
    /**
     * SUMS database connection
     */
    private Connection conn = null;
    /**
     * Jim App SQL Utils
     */
    private SqlUtils sql = null;
    
    /**
     * Creates a new instance of ProjectService
     * @param conn SUMS database connection
     */
    public UserService(Connection conn) {
        this.conn = conn;
        sql = new SqlUtils(conn);
    }
    
}
