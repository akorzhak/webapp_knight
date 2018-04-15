package ua.training.model.dao.implement;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.KnightDao;
import ua.training.model.dao.ProductDao;
import ua.training.model.util.ConnectionConstants;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {


    private static final String DATABASE_URL = ConnectionConstants.DATABASE_URL;
    private static final String USERNAME = ConnectionConstants.USERNAME;
    private static final String PASSWORD = ConnectionConstants.PASSWORD;

    @Override
    public KnightDao createKnightDao() {
        return new JDBCKnightDao(getConnection());
    }
    @Override
    public ProductDao createProductDao() {
        return new JDBCProductDao(getConnection());
    }

    private Connection getConnection(){
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