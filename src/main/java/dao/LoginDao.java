package dao;

import model.Login;
import java.sql.*;
class LoginDAO {
    private Connection connection;

    public LoginDAO(Connection connection) {
        this.connection = connection;
    }

    public Login login(String email, String password) {
        Login user = null;
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password); // Lưu ý: Mật khẩu ở đây cần hash trong thực tế.
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user = new Login(
                            rs.getInt("user_id"),
                            rs.getString("username"),
                            rs.getString("email"),
                            rs.getString("password")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}

