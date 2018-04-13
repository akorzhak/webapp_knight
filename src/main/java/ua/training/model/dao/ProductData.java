package ua.training.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductData {

    public ArrayList<String> getProductsData(ArrayList<String> items) {

        Database database = new Database();
        ArrayList<String> itemsData = new ArrayList<>();

        try (Connection connection = database.connectToDatabase(); Statement statement = connection.createStatement()) {
            for (String itemName : items) {
                String queryProductData = "SELECT name, price, description FROM mydb.products where name = '" + itemName + "'";
                ResultSet productData = statement.executeQuery(queryProductData);
                if (!productData.next())
                    return null;
                String name = productData.getString("name");
                itemsData.add(name);
                long price = productData.getLong("price");
                itemsData.add(String.valueOf(price));
                String descriprion = productData.getString("description");
                itemsData.add(descriprion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemsData;
    }
}
