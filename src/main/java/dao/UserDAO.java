package dao;

import model.User;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.*;

public class UserDAO {

    // Thêm người dùng mới (đăng ký)
    public boolean registerUser(User user) {
        String sql = "INSERT INTO users (user_name, address, phone, username, password_hash, email, role, status, created_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Mã hóa mật khẩu trước khi lưu
            String hashedPassword = BCrypt.hashpw(user.getPassword_hash(), BCrypt.gensalt());
            preparedStatement.setString(1, user.getUser_name());
            preparedStatement.setString(2, user.getAddress());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setString(4, user.getUsername());
            preparedStatement.setString(5, hashedPassword);
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setString(7, user.getRole());
            preparedStatement.setString(8, user.getStatus());
            preparedStatement.setString(9, user.getCreated_at());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error while registering user: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // Kiểm tra đăng nhập
    public User loginUser(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String storedPasswordHash = rs.getString("password_hash");
                if (BCrypt.checkpw(password, storedPasswordHash)) {
                    // Trả về thông tin người dùng nếu mật khẩu đúng
                    User user = new User(
                            rs.getInt("user_id"),
                            rs.getString("user_name"),
                            rs.getString("address"),
                            rs.getString("phone"),
                            rs.getString("username"),
                            storedPasswordHash,
                            rs.getString("email"),
                            rs.getString("role"),
                            rs.getString("status")
                    );
                    return user;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error while logging in: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    // Thay đổi mật khẩu khi quên mật khẩu
    public boolean changePassword(String username, String newPassword) {
        String sql = "UPDATE users SET password_hash = ? WHERE username = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());
            preparedStatement.setString(1, hashedPassword);
            preparedStatement.setString(2, username);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error while changing password: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}
