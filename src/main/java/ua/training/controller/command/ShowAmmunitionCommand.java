package ua.training.controller.command;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.ProductDao;
import ua.training.model.dao.implement.JDBCDaoFactory;
import ua.training.model.entity.Product;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowAmmunitionCommand implements Command {

    private DaoFactory daoFactory = new JDBCDaoFactory();
    private ProductDao productDao = daoFactory.createProductDao();

    @Override
    public String execute(HttpServletRequest request) {
        
        List<Product> products = productDao.findAll();
        request.setAttribute("products", products);
        request.removeAttribute("sorted_products");
        return "/order.jsp";
    }
}