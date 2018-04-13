package ua.training.model.entity.product.ammunition;

import ua.training.model.dao.ProductData;
import ua.training.model.entity.product.ammunition.elements.*;

import java.util.ArrayList;

public class RichKnightAmmunition extends Ammunition {

    private int i;
    private long price;
    private String name, description;
    private ProductData database = new ProductData();
    private ArrayList<String> products = new ArrayList<>();
    private ArrayList<String> productsData;

    public RichKnightAmmunition() {

        products.add("gold helmet");
        products.add("gold sword");
        products.add("gold chain armor");
        products.add("gold leg armor");
        products.add("white horse");

        productsData = database.getProductsData(products);

        name = productsData.get(i++);
        price = Long.parseLong(productsData.get(i++), 10);
        description = productsData.get(i++);
        helmet = new GoldHelmet(price, description, name);

        name = productsData.get(i++);
        price = Long.parseLong(productsData.get(i++), 10);
        description = productsData.get(i++);
        weapon = new GoldSword(price, description, name);

        name = productsData.get(i++);
        price = Long.parseLong(productsData.get(i++), 10);
        description = productsData.get(i++);
        chainArmor = new GoldChainArmor(price, description, name);

        name = productsData.get(i++);
        price = Long.parseLong(productsData.get(i++), 10);
        description = productsData.get(i++);
        legArmor = new GoldLegArmor(price, description, name);

        name = productsData.get(i++);
        price = Long.parseLong(productsData.get(i++), 10);
        description = productsData.get(i++);
        vehicle = new WhiteHorse(price, description, name);
    }
}
