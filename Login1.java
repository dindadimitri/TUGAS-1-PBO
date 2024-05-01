package pbotugas1;

public class Login1 {
    private String username_user, password_user, username_admin, password_admin;
    public void login1() {
        username_user = "username";
        password_user = "username";
        username_admin = "admin";
        password_admin = "admin";
    }

    public String getUsername_user() {
        setUsername_user(username_user);
        return username_user;
    }

    public void setUsername_user(String username_user) {
        this.username_user = username_user;
    }

    public String getPassword_user() {
        setPassword_user(password_user);
        return password_user;
    }

    public void setPassword_user(String password_user) {
        this.password_user = password_user;
    }

    public String getUsername_admin() {
        setUsername_admin(username_admin);
        return username_admin;
    }

    public void setUsername_admin(String username_admin) {
        this.username_admin = username_admin;
    }

    public String getPassword_admin() {
        setPassword_admin(password_admin);
        return password_admin;
    }

    public void setPassword_admin(String password_admin) {
        this.password_admin = password_admin;
    }
}