/*
 * ActionFactory
 *
 * Description: This source file is a part of the Knight web app.
 *
 * By: Alyona Korzhakova
 *
 * Created: 2018/04/10
 *
 * Updated: 2018/04/20
 */
package ua.training.controller.command;

import ua.training.model.util.Constants;

import javax.servlet.http.HttpServletRequest;

/**
 * Defines requested command and creates its instance.
 */
public class ActionFactory {

    /**
     * Extracts requested command name from HttpServletRequest object
     * and creates corresponding Command object.
     * @param request
     * @return in case of success - Command object,
     *         in case of incorrect requested command name - null.
     */
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