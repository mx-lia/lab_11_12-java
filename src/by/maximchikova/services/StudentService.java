package by.maximchikova.services;

import by.maximchikova.entities.Student;
import by.maximchikova.repositories.StudentRepository;

import java.sql.SQLException;

public class StudentService {

    private static StudentRepository studentRepository = new StudentRepository();

    public static void add(String name, String phone, String email) throws SQLException {
        Student student = new Student.StudentBuilder(0, name).setPhone(phone).setEmail(email).build();
        studentRepository.add(student);
    }

    public static Iterable<Student> getAll() throws SQLException {
        return studentRepository.selectAll();
    }
}
