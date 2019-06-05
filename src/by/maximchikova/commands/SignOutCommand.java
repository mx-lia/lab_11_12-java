package by.maximchikova.commands;

import by.maximchikova.managers.PagesManager;

import javax.servlet.http.HttpServletRequest;

public class SignOutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = PagesManager.getProperty("path.page.index");
        request.getSession().invalidate();
        return page;
    }
}
