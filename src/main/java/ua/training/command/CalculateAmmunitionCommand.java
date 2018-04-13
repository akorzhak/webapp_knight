package ua.training.command;

import ua.training.model.entity.product.AmmunitionStore;
import ua.training.model.entity.product.KievAmmunitionStore;
import ua.training.model.entity.product.ammunition.Ammunition;

import javax.servlet.http.HttpServletRequest;

public class CalculateAmmunitionCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        String page = "/order.jsp";
        String type, weight;

        type = request.getParameter("typelist");
        weight = request.getParameter("weight");
        AmmunitionStore kievStore = new KievAmmunitionStore();

        Ammunition ammunition = kievStore.orderAmmunition(type, Integer.parseInt(weight));

        String helmetName = ammunition.helmet.getName();
        String helmetDescription = ammunition.helmet.getDescription();
        long helmetPrice = ammunition.helmet.getPrice();

        String weaponName = ammunition.weapon.getName();
        String weaponDescription = ammunition.weapon.getDescription();
        long weaponPrice = ammunition.weapon.getPrice();

        String chainArmorName = ammunition.chainArmor.getName();
        String chainArmorDescription = ammunition.chainArmor.getDescription();
        long chainArmorPrice = ammunition.chainArmor.getPrice();

        String legArmorName = ammunition.legArmor.getName();
        String legArmorDescription = ammunition.legArmor.getDescription();
        long legArmorPrice = ammunition.legArmor.getPrice();

        String vehicleName = ammunition.vehicle.getName();
        String vehicleDescription = ammunition.vehicle.getDescription();
        long vehiclePrice = ammunition.vehicle.getPrice();

        long price = ammunition.getPrice();
        int size = ammunition.getSize();

        request.setAttribute("helmetName", helmetName);
        request.setAttribute("helmetDescription", helmetDescription);
        request.setAttribute("helmetPrice", helmetPrice);

        request.setAttribute("weaponName", weaponName);
        request.setAttribute("weaponDescription", weaponDescription);
        request.setAttribute("weaponPrice", weaponPrice);

        request.setAttribute("chainArmorName", chainArmorName);
        request.setAttribute("chainArmorDescription", chainArmorDescription);
        request.setAttribute("chainArmorPrice", chainArmorPrice);

        request.setAttribute("legArmorName", legArmorName);
        request.setAttribute("legArmorDescription", legArmorDescription);
        request.setAttribute("legArmorPrice", legArmorPrice);

        request.setAttribute("vehicleName", vehicleName);
        request.setAttribute("vehicleDescription", vehicleDescription);
        request.setAttribute("vehiclePrice", vehiclePrice);

        request.setAttribute("price", price);
        request.setAttribute("size", size);

        return page;
    }
}
