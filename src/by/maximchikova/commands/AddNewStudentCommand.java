package by.maximchikova.commands;

import by.maximchikova.entities.Student;
import by.maximchikova.managers.PagesManager;
import by.maximchikova.services.StudentService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class AddNewStudentCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws SQLException {
        String page = null;
        String name = request.getParameter("name").toString();
        String email = request.getParameter("email").toString();
        String phone = request.getParameter("phone").toString();
        StudentService.add(name, phone, email);
        List<Student> students = (List<Student>) StudentService.getAll();
        request.setAttribute("students", students);
        request.setAttribute("user", request.getSession().getAttribute("user"));
        page = PagesManager.getProperty("path.page.welcome");
        return page;
    }
}
