/*
 * DisplaySelectionService
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
import ua.training.model.dao.ProductDao;
import ua.training.model.dao.implement.JDBCDaoFactory;
import ua.training.model.entity.Product;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class DisplaySelectionService {

    private DaoFactory daoFactory = new JDBCDaoFactory();
    private ProductDao productDao = daoFactory.createProductDao();

    public List<Product> extractProductsByDescription(String desc) {
        return productDao.findByDesc(desc);
    }

    public String formPage(HttpServletRequest request, List<Product> products, long price) {
        request.setAttribute("price", price);
        request.setAttribute("sorted_products", products);
        request.removeAttribute("products");
        return "/view/order.jsp";
    }
}
