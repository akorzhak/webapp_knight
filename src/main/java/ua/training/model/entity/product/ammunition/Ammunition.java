package ua.training.model.entity.product.ammunition;

import ua.training.model.entity.product.ammunition.elements.*;

public abstract class Ammunition {

	public Helmet     helmet;
	public Weapon     weapon;
	public ChainArmor chainArmor;
	public LegArmor   legArmor;
	public Vehicle    vehicle;

	public int 	      size;
	public long	      price;

	public void calculateSize(int kg) {

		if (kg >= 40 && kg < 55) {
			size = 1;
		}
		else if (kg >= 55 && kg < 70) {
			size = 2;
		}
		else if (kg >= 70 && kg < 85) {
			size = 3;
		}
		else if (kg >= 85 && kg < 100) {
			size = 4;
		}
		else if (kg >= 100 && kg <= 120) {
			size = 5;
		}
	}

    public void	calculatePrice() {
        price = helmet.getPrice() + weapon.getPrice() + chainArmor.getPrice()
                + legArmor.getPrice() + vehicle.getPrice();
    }

    public int getSize() {
        return size;
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
		ammunition.append("Size:\t\t" + size + "\n");
		ammunition.append("Price:\t\t" + DOLLAR_SIGN + price);

		return ammunition.toString();
	}
}