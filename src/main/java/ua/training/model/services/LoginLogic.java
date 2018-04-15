package ua.training.model.services;

import ua.training.model.entity.Knight;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

    public class LoginLogic {

    private static boolean isValidName(String name){
        System.out.println(name);
        return name.matches("^[A-Z]{1}[a-z]+");
    }

    private static boolean isValidAge(String age){
        return age.matches("[0-9]{2}");
    }

    private static boolean isValidEmail(String email){
        return email.matches("^[\\w-_.+]*[\\w-_.]" +
                "@([\\w]+.)+[\\w]+[\\w]$");
    }

    private static boolean isValidLogin(String login){
        return login.matches("^[^\\d_][a-z\\d_]{3,10}");
    }

    private static boolean isValidPassword(String password){
        return password.matches(".{4,}");
    }

    /**
     * isValidUser method
     * Checks input data for validity.
     * @return true - if valid, false - if invalid.
     */
    public static boolean isValidUser(Knight knight) {
        return (isValidName(knight.getName()) && isValidAge(knight.getAge()) && isValidEmail(knight.getEmail())
                && isValidLogin(knight.getLogin()) && isValidPassword(knight.getPassword()));
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

    public static boolean isRegisteredLogin(Statement statement, String login, String password) {

        String isValidUser = "SELECT login, password FROM mydb.users where login = '" + login + "'";

        try {
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
