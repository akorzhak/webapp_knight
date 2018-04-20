/*
 * Constants
 *
 * Description: This source file is a part of the Knight web app.
 *
 * By: Alyona Korzhakova
 *
 * Created: 2018/04/10
 *
 * Updated: 2018/04/20
 */
package ua.training.model.util;

public interface Constants {

    String PARAM_NAME_LOGIN = "login";
    String PARAM_NAME_PASSWORD = "password";
    String WRONG_ACTION = ": command not found!";
    String INVALID_LOGIN = "Login or password is invalid. Try again.";
    String USER_CREATED = "You have been successfully signed up!";
    String INVALID_DATA = "Input data is invalid!";
    String NOT_UNIQUE_LOGIN = "Input login is already in use!";
    String DB_PROPERTIES_PATH = "src/main/resources/db.properties";
    String DB_PROPERTIES_ERROR = "Failed to import db properties!";
    String DRIVER_ERROR = "Failed to import class Driver";
    String CONNECTION_ERROR = "Failed to import class Driver";
    String ADD_USER_QUERY = "INSERT INTO mydb.users (name, age, email, login, password) VALUES ('";
    String IS_FREE_LOGIN_QUERY = "SELECT login FROM mydb.users where login = '";
    String QUERY_BY_NAME = "SELECT login, password FROM mydb.users where login = '";
    String IS_VALID_USER_QUERY = "SELECT login, password FROM mydb.users where login = '";
    String PRODUCT_NAME_QUERY = "SELECT name, price, description, type FROM mydb.products where name = '";
    String FIND_ALL_QUERY = "SELECT name, price, description, type FROM mydb.products";
    String FIND_BY_DESC_QUERY = "SELECT name, price, description, type FROM mydb.products WHERE description = '";
}
