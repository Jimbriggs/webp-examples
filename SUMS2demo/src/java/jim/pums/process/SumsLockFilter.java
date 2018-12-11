/*
 * SumsLockFilter.java
 *
 * Created on 30 April 2007, 14:29
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package jim.pums.process;

import java.sql.*;
import jim.pums.PumsApp;
import jim.util.LockApplicationFilter;

/**
 *
 * @author briggsj
 */
public class SumsLockFilter extends LockApplicationFilter {
    
    /** Creates a new instance of SumsLockFilter */
    public SumsLockFilter() {
    }
    
    protected boolean locked() {
        boolean locked = false;
        Connection conn = null;
        try {
            conn = PumsApp.getInstance().getConnection();
            String sql = "SELECT NAME, VALUE FROM CONFIG WHERE NAME = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "LOCKED");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String message = rs.getString("VALUE");
                this.setMessage(message);
                locked = (message != null) && (message.length() > 0);
            } else {
                locked = false;
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            locked = true;
            this.setMessage(ex.getMessage());
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                //do nothing
            }
        }
        return locked;
    }
        
}
