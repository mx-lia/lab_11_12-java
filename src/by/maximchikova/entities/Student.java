package by.maximchikova.entities;

public class Student {
    private final int id;
    private final String name;
    private final String email;
    private final String phone;

    public static class StudentBuilder {
        private final int id;
        private final String name;
        private String email;
        private String phone;

        public StudentBuilder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public StudentBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public StudentBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    private Student(StudentBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.phone = builder.phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
