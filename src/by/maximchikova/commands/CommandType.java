package by.maximchikova.commands;

public enum CommandType {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    REGISTER {
        {
            this.command = new RegisterCommand();
        }
    },
    SIGN_OUT {
        {
            this.command = new SignOutCommand();
        }
    },
    ADD_STUDENT {
        {
            this.command = new AddNewStudentCommand();
        }
    };

    Command command;

    public  Command getCurrentCommand() {
        return command;
    }
}
