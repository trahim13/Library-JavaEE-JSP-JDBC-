package org.trahim.web.db;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by root on 19.08.2017.
 */
public class Database {
    private static Connection conn;
    private static InitialContext ic;
    private static DataSource ds;

    public static Connection getConnection() {
        try {
            ic = new InitialContext();
//            ds = (DataSource) ic.lookup("java:comp/env/jdbc/Library1");
//            ds = (DataSource) ic.lookup("jdbc/Library1");
            ds = (DataSource) ic.lookup("jdbc/Library2");
            if (conn==null) {
                conn = ds.getConnection();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conn;
    }
}
