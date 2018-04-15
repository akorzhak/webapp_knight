package ua.training.controller.command;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.GenericDao;
import ua.training.model.dao.KnightDao;
import ua.training.model.dao.implement.JDBCDaoFactory;
import ua.training.model.dao.implement.JDBCKnightDao;
import ua.training.model.services.LoginLogic;
import ua.training.model.entity.Knight;
import ua.training.view.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class RegisterCommand implements Command {

    private DaoFactory daoFactory = new JDBCDaoFactory();
    private KnightDao knightDao = daoFactory.createKnightDao();

    @Override
    public String execute(HttpServletRequest request) {

        String page = "/registration.jsp";
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Knight knight = new Knight(name, age, email, login, password);
        System.out.println("111111");
        if (!LoginLogic.isValidUser(knight)) {
            request.setAttribute("invalidInputMessage", MessageManager.INVALID_DATA);
            System.out.println("22222");
        } else if (!knightDao.create(knight)) {
            request.setAttribute("notUniqueLoginMassage", MessageManager.NOT_UNIQUE_LOGIN);
            System.out.println("333333");
        } else {
            request.setAttribute("userName", name);
            request.setAttribute("userCreated", MessageManager.USER_CREATED);
            page = "/success_signup.jsp";
        }
        return page;
    }

}
