package ua.training.command;

import ua.training.model.dao.Authentication;
import ua.training.view.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String login = request.getParameter(MessageManager.PARAM_NAME_LOGIN);
        String pass = request.getParameter(MessageManager.PARAM_NAME_PASSWORD);

        if (Authentication.checkLogin(login, pass)) {
            request.setAttribute("user", login);
            page = "/success_signin.jsp";
        }
        else {
            request.setAttribute("invalidLogin", MessageManager.INVALID_LOGIN);
            page = "/login.jsp";
        }
        return page;
    }
}