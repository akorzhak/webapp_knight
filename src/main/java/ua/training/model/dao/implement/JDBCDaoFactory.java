package ua.training.model.dao.implement;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.KnightDao;
import ua.training.model.dao.ProductDao;
import ua.training.model.util.Constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCDaoFactory extends DaoFactory {

    @Override
    public KnightDao createKnightDao() {
        return new JDBCKnightDao(getConnection());
    }
    @Override
    public ProductDao createProductDao() {
        return new JDBCProductDao(getConnection());
    }

    private Connection getConnection(){

        FileInputStream inputStream;
        Properties property = new Properties();

        Connection connection = null;

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.err.println(Constants.DRIVER_ERROR);
        }

        try {
            inputStream = new FileInputStream(Constants.DB_PROPERTIES_PATH);
            property.load(inputStream);

            String url = property.getProperty("db.url");
            String user = property.getProperty("db.user");
            String pass = property.getProperty("db.pass");

            connection = DriverManager.getConnection(url, user, pass);
        } catch (IOException e) {
            System.err.println(Constants.DB_PROPERTIES_ERROR);
        } catch (SQLException e) {
            System.err.println(Constants.CONNECTION_ERROR);
        }
        return connection;
    }
}