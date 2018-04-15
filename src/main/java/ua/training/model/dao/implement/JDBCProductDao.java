package ua.training.model.dao.implement;

import ua.training.model.dao.ProductDao;
import ua.training.model.entity.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCProductDao implements ProductDao {

    private Connection connection;

    public JDBCProductDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean create(Product product) {
        String queryAddUser = "INSERT INTO mydb.users (name, age, email, login, password) VALUES ('"
                + product.getName() + "', '" + product.getDescription() + "', '" + product.getPrice() + "')";

        try (Statement statement = connection.createStatement()) {
            statement.execute(queryAddUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    private Product extractFromResultSet(ResultSet rs) throws SQLException{
        Product product = new Product();

        product.setName(rs.getString("name"));
        product.setDescription(rs.getString("description"));
        product.setPrice(rs.getInt("price"));

        return product;
    }

    @Override
    public Product findByName(String name) {

        Product product = null;

        try (Statement statement = connection.createStatement()) {
            String queryProductData = "SELECT name, price, description FROM mydb.products where name = '" + name + "'";
            ResultSet rs = statement.executeQuery(queryProductData);
            if (rs.next()) {
                product = extractFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> all = new ArrayList<Product>();

        return all;
    }


    @Override
    public boolean update(Product product) {
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

