package ua.training.command;

public enum CommandEnum {


    REGISTER {
        {
            this.command = new RegisterCommand();
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
