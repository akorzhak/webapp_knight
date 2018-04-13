package ua.training.model.dao;

import ua.training.model.entity.Knight;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCreation {

    /**
     * addUser method
     * Checks user's login for uniqueness.
     * Adds a new user to database in case input data is valid.
     * @param user
     * @return true - if user has been successfully added to
     * database, otherwise - false.
     */
    public static boolean addUser(Knight user) {

        Database database = new Database();
        String queryAddUser = "INSERT INTO mydb.users (name, age, email, login, password) VALUES ('"
                + user.getName() + "', '" + user.getAge() + "', '" + user.getEmail() + "', '"
                + user.getLogin() + "', '" + user.getPassword() + "')";

        try (Connection connection = database.connectToDatabase(); Statement statement = connection.createStatement()) {
            if (!isUniqueLogin(statement, user.getLogin())) {
                return false;
            }
            statement.execute(queryAddUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Checks input login for uniqueness
     * @param statement
     * @param login
     * @return true - if login is already in use;
     *         false - if login is unique;
     */
    public static boolean isUniqueLogin(Statement statement, String login) {

        String queryIfFreeLogin = "SELECT login FROM mydb.users where login = '" + login + "'";

        try {
            ResultSet uniqueLogin = statement.executeQuery(queryIfFreeLogin);
            if (uniqueLogin.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
