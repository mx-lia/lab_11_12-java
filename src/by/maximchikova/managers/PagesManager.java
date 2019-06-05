package by.maximchikova.managers;

import java.util.ResourceBundle;

public class PagesManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("page");

    private PagesManager() { }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }

}
