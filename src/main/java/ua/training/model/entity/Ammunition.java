package ua.training.model.entity;

public class Ammunition {

	private Product     helmet;
    private Product     weapon;
    private Product chainArmor;
    private Product   legArmor;
    private Product    vehicle;
    private long	     price;

    public Ammunition(Product helmet, Product weapon, Product chainArmor, Product legArmor, Product vehicle, long price) {
        this.helmet = helmet;
        this.weapon = weapon;
        this.chainArmor = chainArmor;
        this.legArmor = legArmor;
        this.vehicle = vehicle;
        this.price = price;
    }

    public Ammunition() {
    }

    public Product getHelmet() {
        return helmet;
    }

    public void setHelmet(Product helmet) {
        this.helmet = helmet;
    }

    public Product getWeapon() {
        return weapon;
    }

    public void setWeapon(Product weapon) {
        this.weapon = weapon;
    }

    public Product getChainArmor() {
        return chainArmor;
    }

    public void setChainArmor(Product chainArmor) {
        this.chainArmor = chainArmor;
    }

    public Product getLegArmor() {
        return legArmor;
    }

    public void setLegArmor(Product legArmor) {
        this.legArmor = legArmor;
    }

    public Product getVehicle() {
        return vehicle;
    }

    public void setVehicle(Product vehicle) {
        this.vehicle = vehicle;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getPrice() {
       return price;
    }

	@Override
	public String toString() {

		final String DOLLAR_SIGN = "\u0024";

		StringBuilder ammunition = new StringBuilder();

		ammunition.append("YOUR ORDER:\n\n");
		ammunition.append("Helmet:\t\t" + helmet.getName() + "for " + helmet.getPrice() + " " + price + "\n");
		ammunition.append("Weapon:\t\t" + weapon + "\n");
		ammunition.append("Chain armor:\t" + chainArmor + "\n");
		ammunition.append("Leg armor:\t" + legArmor + "\n");
		ammunition.append("Vehicle:\t" + vehicle + "\n");
		ammunition.append("--------------------------------\n");
		ammunition.append("Price:\t\t" + DOLLAR_SIGN + price);

		return ammunition.toString();
	}
}