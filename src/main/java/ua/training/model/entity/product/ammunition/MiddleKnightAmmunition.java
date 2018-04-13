package ua.training.model.entity.product.ammunition;

import ua.training.model.dao.ProductData;
import ua.training.model.entity.product.ammunition.elements.*;

import java.util.ArrayList;

public class MiddleKnightAmmunition extends Ammunition {

    private int i;
    private long price;
    private String name, description;
    private ProductData database = new ProductData();
    private ArrayList<String> products = new ArrayList<>();
    private ArrayList<String> productsData;

    public MiddleKnightAmmunition() {

        products.add("iron helmet");
        products.add("iron sword");
        products.add("iron chain armor");
        products.add("iron leg armor");
        products.add("brown horse");

        productsData = database.getProductsData(products);

        name = productsData.get(i++);
        price = Long.parseLong(productsData.get(i++), 10);
        description = productsData.get(i++);
        helmet = new IronHelmet(price, description, name);

        name = productsData.get(i++);
        price = Long.parseLong(productsData.get(i++), 10);
        description = productsData.get(i++);
        weapon = new IronSword(price, description, name);

        name = productsData.get(i++);
        price = Long.parseLong(productsData.get(i++), 10);
        description = productsData.get(i++);
        chainArmor = new IronChainArmor(price, description, name);

        name = productsData.get(i++);
        price = Long.parseLong(productsData.get(i++), 10);
        description = productsData.get(i++);
        legArmor = new IronLegArmor(price, description, name);

        name = productsData.get(i++);
        price = Long.parseLong(productsData.get(i++), 10);
        description = productsData.get(i++);
        vehicle = new BrownHorse(price, description, name);
    }
}
