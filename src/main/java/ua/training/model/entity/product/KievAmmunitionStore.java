package ua.training.model.entity.product;

import ua.training.model.entity.product.ammunition.RichKnightAmmunition;
import ua.training.model.entity.product.ammunition.Ammunition;
import ua.training.model.entity.product.ammunition.PoorKnightAmmunition;
import ua.training.model.entity.product.ammunition.MiddleKnightAmmunition;

public class KievAmmunitionStore extends AmmunitionStore {

	public Ammunition selectAmmunition(String type) {

		if (type.equals("poor knight")) {
			return new PoorKnightAmmunition();
		}
		else if (type.equals("middle knight")) {
			return new MiddleKnightAmmunition();
		}
		else if (type.equals("rich knight")) {
			return new RichKnightAmmunition();
		}
		else
			return null;
	}
}