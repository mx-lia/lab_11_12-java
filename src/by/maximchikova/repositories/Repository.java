package by.maximchikova.repositories;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {
    List<T> selectAll() throws SQLException;
    void add(T item) throws SQLException;
}
