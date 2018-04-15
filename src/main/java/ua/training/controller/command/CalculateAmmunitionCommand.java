package ua.training.controller.command;

import ua.training.model.entity.Ammunition;
import ua.training.model.services.AmmunitionCreation;
import ua.training.model.services.PageCreation;

import javax.servlet.http.HttpServletRequest;

public class CalculateAmmunitionCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        String helmet = null;
        String weapon = null;
        String chainArmor = null;
        String legArmor = null;
        String vehicle = null;
        AmmunitionCreation ammunitionCreation = new AmmunitionCreation();
        PageCreation pageCreation = new PageCreation();

        String type = request.getParameter("typelist");

        if (type.equals("poor knight")) {
            helmet = "plastic helmet";
            weapon = "knife";
            chainArmor = "plastic chain armor";
            legArmor = "plastic leg armor";
            vehicle = "donkey";
        }
        else if (type.equals("middle knight")) {
            helmet = "iron helmet";
            weapon = "iron sword";
            chainArmor = "iron chain armor";
            legArmor = "iron leg armor";
            vehicle = "brown horse";
        }
        else if (type.equals("rich knight")) {
            helmet = "gold helmet";
            weapon = "gold sword";
            chainArmor = "gold chain armor";
            legArmor = "gold leg armor";
            vehicle = "white horse";
        }

        Ammunition ammunition = ammunitionCreation.createAmmunition(helmet, weapon, chainArmor, legArmor, vehicle);

        return pageCreation.createAmmunitionPage(ammunition, request);
    }
}
