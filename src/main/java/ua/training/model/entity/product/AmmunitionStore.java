package ua.training.model.entity.product;

import ua.training.model.entity.product.ammunition.Ammunition;

public abstract class AmmunitionStore {

	public Ammunition orderAmmunition(String type, int kg) {

		Ammunition 	ammunition;

		ammunition = selectAmmunition(type);

		ammunition.calculateSize(kg);
		ammunition.calculatePrice();

		return ammunition;
	}

	//factory method;
	protected abstract Ammunition selectAmmunition(String type);
}