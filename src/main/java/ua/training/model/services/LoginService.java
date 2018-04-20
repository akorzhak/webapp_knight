/*
 * LoginService
 *
 * Description: This source file is a part of the Knight web app.
 *
 * By: Alyona Korzhakova
 *
 * Created: 2018/04/10
 *
 * Updated: 2018/04/20
 */
package ua.training.model.services;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.KnightDao;
import ua.training.model.dao.implement.JDBCDaoFactory;
import ua.training.model.util.Constants;

import javax.servlet.http.HttpServletRequest;

public class LoginService {

    private DaoFactory daoFactory = new JDBCDaoFactory();
    private KnightDao knightDao = daoFactory.createKnightDao();

    public String formPage(HttpServletRequest request) {

        String login = request.getParameter(Constants.PARAM_NAME_LOGIN);
        String pass = request.getParameter(Constants.PARAM_NAME_PASSWORD);

        if (knightDao.findByLogin(login, pass)) {
            request.setAttribute("user", login);
            return "/view/success_signin.jsp";
        }
        else {
            request.setAttribute("invalidLogin", Constants.INVALID_LOGIN);
            return "/view/login.jsp";
        }
    }
}
