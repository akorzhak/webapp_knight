package ua.training.command;

import ua.training.view.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {

    public Command defineCommand(HttpServletRequest request) {
        Command command = new EmptyCommand();
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            return command;
        }
        try {
            CommandEnum commandEnum = CommandEnum.valueOf(action.toUpperCase());
            command = commandEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", action
                    + MessageManager.WRONG_ACTION);
        }
        return command;
    }
}