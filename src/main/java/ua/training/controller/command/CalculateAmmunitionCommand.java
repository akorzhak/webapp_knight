package ua.training.controller.command;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.ProductDao;
import ua.training.model.dao.implement.JDBCDaoFactory;
import ua.training.model.entity.Product;
import ua.training.model.services.PriceCalculatorService;


import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class CalculateAmmunitionCommand implements Command {

        private DaoFactory daoFactory = new JDBCDaoFactory();
        private ProductDao productDao = daoFactory.createProductDao();
        private PriceCalculatorService priceCalculator = new PriceCalculatorService();

        @Override
        public String execute(HttpServletRequest request) {

            String desc = request.getParameter("pricetype");

            List<Product> products = productDao.findByDesc(desc);
            request.setAttribute("sorted_products", products);
            request.removeAttribute("products");
            request.setAttribute("price", priceCalculator.calculatePrice(products));
            return "/order.jsp";
        }
}
