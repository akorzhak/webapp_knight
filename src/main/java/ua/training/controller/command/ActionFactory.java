package ua.training.controller.command;

import ua.training.model.util.Constants;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {

    public Command defineCommand(HttpServletRequest request) {

        Command command = null;

        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            return null;
        }
        try {
            CommandEnum commandEnum = CommandEnum.valueOf(action.toUpperCase());
            command = commandEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", action
                    + Constants.WRONG_ACTION);
        }
        return command;
    }
}