package ua.training.command;

import ua.training.model.dao.UserCreation;
import ua.training.model.entity.Knight;
import ua.training.view.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class RegisterCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        String page = "/registration.jsp";
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Knight user = new Knight(name, age, email, login, password);
        if (!user.isValidUser()) {
            request.setAttribute("invalidInputMessage", MessageManager.INVALID_DATA);
        } else if (!UserCreation.addUser(user)) {
            request.setAttribute("notUniqueLoginMassage", MessageManager.NOT_UNIQUE_LOGIN);
        } else {
            request.setAttribute("userName", name);
            request.setAttribute("userCreated", MessageManager.USER_CREATED);
            page = "/success_signup.jsp";
        }
        return page;
    }

}
