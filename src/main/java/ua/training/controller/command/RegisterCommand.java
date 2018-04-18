package ua.training.controller.command;

import ua.training.model.services.KnightCreatorService;
import ua.training.model.entity.Knight;

import javax.servlet.http.HttpServletRequest;

public class RegisterCommand implements Command {

    private KnightCreatorService knightCreatorService = new KnightCreatorService();

    @Override
    public String execute(HttpServletRequest request) {

        Knight knight = knightCreatorService.createKnight(request);

        return knightCreatorService.registerKnight(request, knight);
    }

}
