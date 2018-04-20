/*
 * LoginCommand
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

import ua.training.model.services.LoginService;

import javax.servlet.http.HttpServletRequest;

/**
 * Lets the existing user log into system.
 */
public class LoginCommand implements Command {

    private LoginService loginService = new LoginService();

    @Override
    public String execute(HttpServletRequest request) {

        return loginService.formPage(request);
    }
}