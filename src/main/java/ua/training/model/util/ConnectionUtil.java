package ua.training.model.util;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    private static final String DATABASE_URL = ConnectionConstants.DATABASE_URL;
    private static final String USERNAME = ConnectionConstants.USERNAME;
    private static final String PASSWORD = ConnectionConstants.PASSWORD;

    public Connection connectToDatabase() {

        Connection connection;
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.err.println("Failed to import class Driver");
        }
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            connection = null;
            System.err.println("Failed to connect to Database");
        }
        return connection;
    }
}
