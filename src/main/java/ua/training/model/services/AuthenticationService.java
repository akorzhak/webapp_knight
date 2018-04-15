package ua.training.model.services;

import ua.training.model.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthenticationService {

    public static boolean checkLogin(String login, String password) {

        ConnectionUtil connectionUtil = new ConnectionUtil();
        String isValidUser = "SELECT login, password FROM mydb.users where login = '" + login + "'";

        try (Connection connection = connectionUtil.connectToDatabase();
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