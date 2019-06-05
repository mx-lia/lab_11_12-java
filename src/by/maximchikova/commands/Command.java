package by.maximchikova.commands;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

public interface Command {
    String execute (HttpServletRequest request) throws IOException, SQLException;
}
