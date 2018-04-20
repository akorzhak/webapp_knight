/*
 * JDBCKnightDao
 *
 * Description: This source file is a part of the Knight web app.
 *
 * By: Alyona Korzhakova
 *
 * Created: 2018/04/10
 *
 * Updated: 2018/04/20
 */
package ua.training.model.dao.implement;

import ua.training.model.dao.KnightDao;
import ua.training.model.entity.Knight;
import ua.training.model.util.Constants;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCKnightDao implements KnightDao {

    private Connection connection;

    public JDBCKnightDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean create(Knight knight) {

        String queryAddUser = Constants.ADD_USER_QUERY + knight.getName() + "', '" + knight.getAge() + "', '"
                + knight.getEmail() + "', '" + knight.getLogin() + "', '" + knight.getPassword() + "')";

        try (Statement statement = connection.createStatement()) {
            if (!isUniqueLogin(statement, knight.getLogin())) {
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

    public boolean isUniqueLogin(Statement statement, String login) {

        String isFreeLoginQuery = Constants.IS_FREE_LOGIN_QUERY + login + "'";

        try {
            ResultSet uniqueLogin = statement.executeQuery(isFreeLoginQuery);
            if (uniqueLogin.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Knight findById(int id) {
        return null;
    }

    private Knight extractFromResultSet(ResultSet rs) throws SQLException{
        Knight knight = new Knight();

        knight.setName(rs.getString("name"));
        knight.setAge(rs.getString("age"));
        knight.setEmail(rs.getString("email"));
        knight.setLogin(rs.getString("login"));
        knight.setPassword(rs.getString("password"));

        return knight;
    }

    public Knight findByName(String name) {

        Knight knight = null;

        try (Statement statement = connection.createStatement()) {
            String queryByName = Constants.QUERY_BY_NAME + name + "'";
            ResultSet rs = statement.executeQuery(queryByName);
            if (rs.next()) {
                knight = extractFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return knight;
    }

    public boolean findByLogin(String login, String password) {
        String isValidUser = Constants.IS_VALID_USER_QUERY + login + "'";

        try (Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery(isValidUser);
            if (!rs.next() || !rs.getString("password").equals(password)) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public List<Knight> findAll() {
        List<Knight> all = new ArrayList<Knight>();

        return all;
    }


    @Override
    public boolean update(Knight knight) {
        return true;
    }

    @Override
    public boolean delete(int id) {
        return true;
    }

    @Override
    public void close() throws Exception {

    }
}
