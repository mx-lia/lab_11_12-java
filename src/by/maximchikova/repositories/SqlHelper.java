package by.maximchikova.repositories;

public class SqlHelper {
    public static final String SELECT_All_USERS = "SELECT * FROM users";
    public static final String SELECT_ALL_STUDENTS = "SELECT * FROM students";
    public static final String INSERT_STUDENT = "INSERT INTO students (name, email, phone) VALUES ( ?, ?, ?)";
    public static final String INSERT_USER = "INSERT INTO users (login, password) VALUES ( ?, ?)";
    public static final String FIND_USER = "SELECT * FROM users WHERE login=? and password=?";
}
