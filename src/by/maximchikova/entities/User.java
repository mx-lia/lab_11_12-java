package by.maximchikova.entities;

public class User {
    private final int id;
    private final String login;
    private final String password;
    private final String role;

    public static class UserBuilder {
        private final int id;
        private final String login;
        private final String password;
        private final String role;

        public UserBuilder(int id, String login, String password, String role) {
            this.id = id;
            this.login = login;
            this.password = password;
            this.role = role;
        }

        public User build() {
            return new User(this);
        }
    }

    private User(UserBuilder builder) {
        this.id = builder.id;
        this.login = builder.login;
        this.password = builder.password;
        this.role = builder.role;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
