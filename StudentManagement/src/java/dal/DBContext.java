    package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author FPT University - PRJ301
 */
public class DBContext {
    public Connection getConnection() throws Exception {	       
        String url = "jdbc:sqlserver:// " + serverName+":" + portNumber+";databaseName="+dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }
    private final String serverName = "DESKTOP-OMSOF7F";
    private final String dbName = "PROJECT";
    private final String portNumber = "1433";
    private final String userID = "minh";
    private final String password = "minh123";
}
