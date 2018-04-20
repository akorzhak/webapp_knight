/*
 * RegisterCommand
 *
 * Description: This command is a part of the Knight web app.
 *
 * By: Alyona Korzhakova
 *
 * Created: 2018/04/10
 *
 * Updated: 2018/04/20
 */
package ua.training.controller.command;

import ua.training.model.services.RegistrationService;
import ua.training.model.entity.Knight;

import javax.servlet.http.HttpServletRequest;

/**
 * Registers a new user.
 */
public class RegisterCommand implements Command {

    private RegistrationService registrationService = new RegistrationService();

    @Override
    public String execute(HttpServletRequest request) {

        Knight knight = registrationService.createKnight(request);

        return registrationService.registerKnight(request, knight);
    }

}