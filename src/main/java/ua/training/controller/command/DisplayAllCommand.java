/*
 * DisplayAllCommand
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

import ua.training.model.entity.Product;
import ua.training.model.services.DisplayAllService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Displays all the store products.
 */
public class DisplayAllCommand implements Command {

    private DisplayAllService displayAllService = new DisplayAllService();

    @Override
    public String execute(HttpServletRequest request) {
        
        List<Product> products = displayAllService.extractAllProducts();
        return displayAllService.formPage(request, products);
    }
}