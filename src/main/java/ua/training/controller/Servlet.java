/*
 * Servlet
 *
 * Description: This controller is a part of the web app.
 *
 * By: Alyona Korzhakova
 *
 * Created: 2018/03/22
 *
 * Updated: 2018/03/25
 */
package ua.training.controller;

import ua.training.command.ActionFactory;
import ua.training.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;

public class Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ActionFactory client = new ActionFactory();
        Command command = client.defineCommand(request);
        String page = command.execute(request);

        if (page != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("/errors/error500.jsp");
        }
    }
}