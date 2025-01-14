package model;

public class Login {
    private int id;
    private String username;
    private String email;
    private String password;

    public Login() {
    }

    public Login(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}