package by.maximchikova.commands.factory;

import by.maximchikova.commands.Command;
import by.maximchikova.commands.CommandType;
import by.maximchikova.managers.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class CommandFactory {

    public Command defineCommand (HttpServletRequest request) {
        Command current = null;
        String command = request.getParameter("command");
        if(command == null || command.isEmpty()) {
            return current;
        }

        try {
            CommandType currentType = CommandType.valueOf(command.toUpperCase());
            current = currentType.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", command + MessageManager.getProperty("message.wrongaction"));
        }
        return  current;
    }
}
