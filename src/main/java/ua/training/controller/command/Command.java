/*
 * Command
 *
 * Description: This command interface is a part of the Knight web app.
 *
 * By: Alyona Korzhakova
 *
 * Created: 2018/04/10
 *
 * Updated: 2018/04/20
 */
package ua.training.controller.command;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    String execute(HttpServletRequest request);
}