package ua.training.model.dao.implement;

import ua.training.model.dao.KnightDao;
import ua.training.model.entity.Knight;
import ua.training.model.services.LoginLogic;

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
        String queryAddUser = "INSERT INTO mydb.users (name, age, email, login, password) VALUES ('"
                + knight.getName() + "', '" + knight.getAge() + "', '" + knight.getEmail() + "', '"
                + knight.getLogin() + "', '" + knight.getPassword() + "')";

        try (Statement statement = connection.createStatement()) {
            if (!LoginLogic.isUniqueLogin(statement, knight.getLogin())) {
                return false;
            }
            statement.execute(queryAddUser);
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
            String queryProductData = "SELECT name, price, description FROM mydb.users where name = '" + name + "'";
            ResultSet rs = statement.executeQuery(queryProductData);
            if (rs.next()) {
                knight = extractFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return knight;
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
