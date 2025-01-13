package model;


import com.sun.tools.javac.Main;

public class User {
    private int user_id;
    private String user_name;
    private String address;
    private String phone;
    private String username;
    private String password_hash;
    private String email;
    private String role;
    private String status;
    private String created_at;
    private String updated_at;

    public User(int user_id, String user_name, String address, String phone, String username, String password_hash, String email, String role, String status) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.address = address;
        this.phone = phone;
        this.username = username;
        this.password_hash = password_hash;
        this.email = email;
        this.role = role;
        this.status = this.status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole_id(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", password_hash='" + password_hash + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }

}