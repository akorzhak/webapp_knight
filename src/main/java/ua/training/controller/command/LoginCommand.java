package ua.training.controller.command;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.KnightDao;
import ua.training.model.dao.implement.JDBCDaoFactory;
import ua.training.model.util.Constants;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {

    private DaoFactory daoFactory = new JDBCDaoFactory();
    private KnightDao knightDao = daoFactory.createKnightDao();

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String login = request.getParameter(Constants.PARAM_NAME_LOGIN);
        String pass = request.getParameter(Constants.PARAM_NAME_PASSWORD);

        if (knightDao.findByLogin(login, pass)) {
            request.setAttribute("user", login);
            page = "/success_signin.jsp";
        }
        else {
            request.setAttribute("invalidLogin", Constants.INVALID_LOGIN);
            page = "/login.jsp";
        }
        return page;
    }
}