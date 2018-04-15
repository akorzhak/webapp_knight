package ua.training.model.entity;

public class Product {

    private String name;
    private long price;
    private String description;

    public Product(String name, long price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
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