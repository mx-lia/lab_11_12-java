package by.maximchikova.repositories;

import by.maximchikova.entities.Student;
import by.maximchikova.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class StudentRepository extends AbstractRepository<Student> {

    private Student buildStudent(ResultSet rs) throws SQLException {
        int id = rs.getInt(1);
        String name = rs.getString(2);
        String email = rs.getString(3);
        String phone = rs.getString(4);
        Student student = new Student.StudentBuilder(id, name)
                .setEmail(email)
                .setPhone(phone)
                .build();
        return student;
    }

    @Override
    public List<Student> selectAll() throws SQLException {
        List<Student> students = new LinkedList<>();
        try (Connection connection = getDbConnection();
             PreparedStatement pst = connection.prepareStatement(SqlHelper.SELECT_ALL_STUDENTS);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                students.add(buildStudent(rs));
            }
            return students;
        }
    }

    @Override
    public void add(Student item) throws SQLException {
        try (Connection con = getDbConnection();
             PreparedStatement pst = con.prepareStatement(SqlHelper.INSERT_STUDENT, new String[]{"id"})) {
            Integer id = -1;
            pst.setString(1, item.getName());
            pst.setString(2, item.getEmail());
            pst.setString(3, item.getPhone());
            pst.executeUpdate();
        }
    }
}
