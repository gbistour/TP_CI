/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsu.ContinuousIntegration.Project.DAL.CRUD;

import com.almworks.sqlite4java.SQLiteConnection;
import com.almworks.sqlite4java.SQLiteException;
import com.almworks.sqlite4java.SQLiteStatement;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fsureau
 */
public class DataContext {

    private static DataContext instanceSingleton;
    private String dbConnection = "database.db3";
    private Connection connection = null;

    public static DataContext getInstance() {
        if (instanceSingleton == null) {
            instanceSingleton = new DataContext();
        }
        return instanceSingleton;
    }

    private DataContext() {
        
    }

    public void CloseConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DataContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Execute a query and return result set
     *
     * @param connection
     * @param requet
     * @return
     */
    private SQLiteStatement getResult(String requet) throws SQLiteException {
        String executionPath = System.getProperty("user.dir");
        System.out.print("Executing at =>" + executionPath.replace("\\", "/"));

        SQLiteConnection db = new SQLiteConnection(new File(dbConnection));
        db.open(true);
        return db.prepare(requet);
    }

    public SQLiteStatement retrieveAllFrom(String tableName) {
        String query = "Select * FROM " + tableName + ";";
        try {
            return getResult(query);
        } catch (SQLiteException ex) {
            Logger.getLogger(DataContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
