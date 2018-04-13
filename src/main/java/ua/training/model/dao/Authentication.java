package ua.training.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Authentication {

    public static boolean checkLogin(String login, String password) {

        Database database = new Database();
        String isValidUser = "SELECT login, password FROM mydb.users where login = '" + login + "'";

        try (Connection connection = database.connectToDatabase();
             Statement statement = connection.createStatement()) {

            ResultSet validUser = statement.executeQuery(isValidUser);
            if (!validUser.next() || !validUser.getString("password").equals(password)) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}