package ua.training.controller.command;

public enum CommandEnum {

    REGISTER {
        {
            this.command = new RegisterCommand();
        }
    },
    SHOW_ALL_AMMUNITION {
        {
            this.command = new ShowAmmunitionCommand();
        }
    },
    CALCULATE_AMMUNITION {
        {
            this.command = new CalculateAmmunitionCommand();
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
