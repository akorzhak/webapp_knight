package ua.training.controller.command;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        return null;
    }
}
