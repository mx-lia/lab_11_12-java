package by.maximchikova.commands;

import by.maximchikova.entities.Student;
import by.maximchikova.managers.MessageManager;
import by.maximchikova.managers.PagesManager;
import by.maximchikova.services.StudentService;
import by.maximchikova.services.UserService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws IOException, SQLException {
        String page = null;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if(UserService.checkUser(login,password)) {
            request.setAttribute("user", login);
            request.getSession().setAttribute("user", login);
            page = PagesManager.getProperty("path.page.welcome");
            List<Student> students = (List<Student>) StudentService.getAll();
            request.setAttribute("students", students);
        } else {
            request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
            page  =  PagesManager.getProperty("path.page.login");
        }
        return page;
    }
}
