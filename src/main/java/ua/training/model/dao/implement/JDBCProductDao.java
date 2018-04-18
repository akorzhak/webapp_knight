package ua.training.model.dao.implement;

import ua.training.model.dao.ProductDao;
import ua.training.model.entity.Product;
import ua.training.model.util.Constants;

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
        product.setType(rs.getString("type"));

        return product;
    }

    @Override
    public Product findByName(String name) {

        Product product = null;

        try (Statement statement = connection.createStatement()) {
            String queryProductData = Constants.PRODUCT_NAME_QUERY + name + "'";
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
        List<Product> all = new ArrayList<>();

        Product product = null;

        try (Statement statement = connection.createStatement()) {
            String findAllQuery = Constants.FIND_ALL_QUERY;
            ResultSet rs = statement.executeQuery(findAllQuery);
            while (rs.next()) {
                product = extractFromResultSet(rs);
                all.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public List<Product> findByDesc(String description) {
        List<Product> all = new ArrayList<>();

        Product product = null;

        try (Statement statement = connection.createStatement()) {
            String findByDescQuery = Constants.FIND_BY_DESC_QUERY + description + "'";
            ResultSet rs = statement.executeQuery(findByDescQuery);
            while (rs.next()) {
                product = extractFromResultSet(rs);
                all.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

