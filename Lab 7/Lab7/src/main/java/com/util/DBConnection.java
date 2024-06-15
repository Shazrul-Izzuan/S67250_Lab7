package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database Connection Utility.
 * Author: ashaz
 */
public class DBConnection {
    private static Connection myConnection = null;
    private static final String myURL = "jdbc:mysql://localhost:3306/CSM3023";

    private DBConnection() {
        // private constructor to prevent instantiation
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (myConnection == null || myConnection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                myConnection = DriverManager.getConnection(myURL, "root", "admin");
            } catch (SQLException e) {
                e.printStackTrace();
                throw e; // rethrow the exception
            }
        }
        return myConnection;
    }
}
