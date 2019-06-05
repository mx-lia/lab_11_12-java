package by.maximchikova.services;

import by.maximchikova.entities.User;
import by.maximchikova.managers.ConfigurationManager;
import by.maximchikova.repositories.UserRepository;

import java.io.IOException;
import java.sql.SQLException;

public class UserService {

    private static UserRepository userRepository = new UserRepository();

    public static boolean checkUser(String login, String password) throws IOException, SQLException {
        if(userRepository.find(login, password) != null) {
            return true;
        }
        return  false;
    }

    public static void add(String login, String password) throws SQLException {
        User newUser = new User.UserBuilder(0,login,password,"user").build();
        userRepository.add(newUser);
    }
}
