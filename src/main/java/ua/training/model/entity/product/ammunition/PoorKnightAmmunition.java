package ua.training.model.entity.product.ammunition;

import ua.training.model.dao.ProductData;
import ua.training.model.entity.product.ammunition.elements.*;

import java.util.ArrayList;

public class PoorKnightAmmunition extends Ammunition {

	private int i;
	private long price;
	private String name, description;
	private ProductData database = new ProductData();
	private ArrayList<String> products = new ArrayList<>();
	private ArrayList<String> productsData;

	public PoorKnightAmmunition() {

        products.add("plastic helmet");
		products.add("knife");
		products.add("plastic chain armor");
		products.add("plastic leg armor");
		products.add("donkey");

		productsData = database.getProductsData(products);

		name = productsData.get(i++);
		price = Long.parseLong(productsData.get(i++), 10);
		description = productsData.get(i++);
		helmet = new PlasticHelmet(price, description, name);

		name = productsData.get(i++);
		price = Long.parseLong(productsData.get(i++), 10);
		description = productsData.get(i++);
		weapon = new Knife(price, description, name);

		name = productsData.get(i++);
		price = Long.parseLong(productsData.get(i++), 10);
		description = productsData.get(i++);
		chainArmor = new PlasticChainArmor(price, description, name);

		name = productsData.get(i++);
		price = Long.parseLong(productsData.get(i++), 10);
		description = productsData.get(i++);
		legArmor = new PlasticLegArmor(price, description, name);

		name = productsData.get(i++);
		price = Long.parseLong(productsData.get(i++), 10);
		description = productsData.get(i++);
		vehicle = new Donkey(price, description, name);
	}
}