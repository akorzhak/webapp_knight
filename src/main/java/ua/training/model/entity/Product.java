/*
 * Product
 *
 * Description: This source file is a part of the Knight web app.
 *
 * By: Alyona Korzhakova
 *
 * Created: 2018/04/10
 *
 * Updated: 2018/04/20
 */
package ua.training.model.entity;

public class Product {

    private String name;
    private long price;
    private String description;
    private String type;

    public Product(String name, long price, String description, String type) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Product() {
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        final String DOLLAR_SIGN = "\u0024";

        StringBuilder product = new StringBuilder();

        product.append("NAME: " + name + "\n");
        product.append("DESCRIPTION: " + description + "\n");
        product.append("PRICE: " + DOLLAR_SIGN + price + "\n");

        return product.toString();
    }
}