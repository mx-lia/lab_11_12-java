package by.maximchikova.repositories;

import by.maximchikova.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserRepository extends AbstractRepository<User> {

    private User buildUser(ResultSet rs) throws SQLException {
        int id = rs.getInt(1);
        String login = rs.getString(2);
        String password = rs.getString(3);
        String role = rs.getString(4);
        User user = new User.UserBuilder(id, login, password, role).build();
        return user;
    }

    @Override
    public List<User> selectAll() throws SQLException {
        List<User> users = new LinkedList<>();
        try (Connection connection = getDbConnection();
             PreparedStatement pst = connection.prepareStatement(SqlHelper.SELECT_All_USERS);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                users.add(buildUser(rs));
            }
            return users;
        }
    }

    @Override
    public void add(User item) throws SQLException {
        try (Connection con = getDbConnection();
             PreparedStatement pst = con.prepareStatement(SqlHelper.INSERT_USER, new String[]{"id"})) {
            Integer id = -1;
            pst.setString(1, item.getLogin());
            pst.setString(2, item.getPassword());
            pst.executeUpdate();
        }
    }

    public User find(String login, String password) throws SQLException {
        User user = null;
        try (Connection connection = getDbConnection();
             PreparedStatement pst = connection.prepareStatement(SqlHelper.FIND_USER)) {
            pst.setString(1, login);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                user = buildUser(rs);
            }
            return user;
        }
    }
}
