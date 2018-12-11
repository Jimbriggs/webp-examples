/*
 * DB.java
 *
 * Created on 30 January 2004, 10:46
 */

package jim.pums.db;

import java.sql.*;
import java.util.*;
/**
 *
 * @author  briggsj
 */
public interface DB {
    
    java.sql.PreparedStatement insertStmt = null;
    java.sql.PreparedStatement deleteStmt = null;
    java.sql.PreparedStatement updateStmt = null;
    java.sql.PreparedStatement loadStmt = null;
    
    public void insertRow() throws SQLException;
    
    public void deleteRow() throws SQLException;
    
    public boolean selectByPrimaryKey() throws SQLException;
    
    public void loadRow() throws SQLException;
    
    public void storeRow() throws SQLException;
    
    public ResultSet searchRows(String[] searchFields, String searchString) throws SQLException;
    
    //    public void createTable () throws SQLException;
    
    /** Getter for property con.
     * @return Value of property con.
     *
     */
    public java.sql.Connection getCon();
    
    /** Setter for property con.
     * @param con New value of property con.
     *
     */
    public void setCon(java.sql.Connection con);
    
}
