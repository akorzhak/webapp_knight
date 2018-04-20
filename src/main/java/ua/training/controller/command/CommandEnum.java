/*
 * CommandEnum
 *
 * Description: This command enum is a part of the Knight web app.
 *
 * By: Alyona Korzhakova
 *
 * Created: 2018/04/10
 *
 * Updated: 2018/04/20
 */
package ua.training.controller.command;

/**
 * Enumerates all existing commands and creates Command instance according to the requested command name.
 */
public enum CommandEnum {

    REGISTER {
        {
            this.command = new RegisterCommand();
        }
    },
    SHOW_ALL_AMMUNITION {
        {
            this.command = new DisplayAllCommand();
        }
    },
    SORT_AMMUNITION {
        {
            this.command = new DisplaySelectionCommand();
        }
    },
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    };

    Command command;

    public Command getCurrentCommand() {
        return command;
    }
}
