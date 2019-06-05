package by.maximchikova.commands;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

public class ErrorCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws IOException, SQLException {
        return null;
    }
}
