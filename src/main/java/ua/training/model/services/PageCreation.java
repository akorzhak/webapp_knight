package ua.training.model.services;

import ua.training.model.entity.Ammunition;

import javax.servlet.http.HttpServletRequest;

public class PageCreation {

    public String createAmmunitionPage(Ammunition ammunition, HttpServletRequest request) {

        String page = "/order.jsp";

        String helmetDisplay = ammunition.getHelmet().toString();
        String weaponDisplay = ammunition.getWeapon().toString();
        String chainArmorDisplay = ammunition.getChainArmor().toString();
        String legArmorDisplay = ammunition.getLegArmor().toString();
        String vehicleDisplay = ammunition.getVehicle().toString();
        long price = ammunition.getPrice();

        request.setAttribute("helmet", helmetDisplay);
        request.setAttribute("weapon", weaponDisplay);
        request.setAttribute("chainArmor", chainArmorDisplay);
        request.setAttribute("legArmor", legArmorDisplay);
        request.setAttribute("vehicle", vehicleDisplay);
        request.setAttribute("price", price);

        return page;
    }
}
