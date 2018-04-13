package ua.training.model.entity.product.ammunition.elements;

public class Knife extends Weapon {

    public Knife(long price, String description, String name) {

        this.name = name;
        this.price = price;
        this.description = description;
    }
}
