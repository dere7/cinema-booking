public class User {
    public String full_name, username, password;
    public Role role;

    public User(String full_name, String username, String password) {
        this.full_name = full_name;
        this.username = username;
        this.password = password;
        this.role = new Role("user");
    }

    public User(String full_name, String username, String password, Role role) {
        this.full_name = full_name;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
