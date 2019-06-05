package by.maximchikova.repositories;

import by.maximchikova.managers.ConfigurationManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class AbstractRepository<T> implements Repository<T> {
    Connection connection;

    public Connection getDbConnection() throws SQLException {
        String connectionString = ConfigurationManager.getProperty("db.url");
        connection = DriverManager.getConnection(connectionString, ConfigurationManager.getProperty("db.user"), ConfigurationManager.getProperty("db.password"));
        return connection;
    }

    public void closeDbConnection() {
        if (connection != null)
        {
            try {
                connection.close();
            }
            catch (SQLException e) {
                System.err.println("Wrong connection" + e);
            }
        }
    }

    public PreparedStatement getPrepareStatement(String sql) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    public void closePrepareStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
