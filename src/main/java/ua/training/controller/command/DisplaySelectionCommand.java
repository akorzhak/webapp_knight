/*
 * DisplaySelectionCommand
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
import ua.training.model.services.DisplaySelectionService;
import ua.training.model.services.PriceCalculatorService;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Displays product selection according to the requested price parameter.
 */
public class DisplaySelectionCommand implements Command {

        private DisplaySelectionService selectionService = new DisplaySelectionService();
        private PriceCalculatorService priceCalculatorService = new PriceCalculatorService();

        @Override
        public String execute(HttpServletRequest request) {

            String desc = request.getParameter("pricetype");

            List<Product> products = selectionService.extractProductsByDescription(desc);
            long price = priceCalculatorService.calculatePrice(products);
            return selectionService.formPage(request, products, price);
        }
}
