/*
 * Database
 *
 * Description: This source file is a part of the
 * web app, that provides registration form, takes input,
 * checks it for validity and records to database.
 *
 * By: Alyona Korzhakova
 *
 * Created: 2018/03/22
 *
 * Updated: 2018/03/25
 */
package ua.training.model.dao;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import ua.training.model.entity.Knight;

import java.sql.*;
import java.util.ArrayList;

/**
 * Database class
 * Aimed to set connection between web app and database,
 * execute queries.
 */
public class Database {

    /**
     * connectToDatabase method
     * Connects webapp to MySQL
     * @return Connection object if succeeded,
     *          null - if failed
     */
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public Connection connectToDatabase() {

        Connection connection;
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.err.println("Failed to import class Driver");
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            connection = null;
            System.err.println("Failed to connect to Database");
        }
        return connection;
    }
}

