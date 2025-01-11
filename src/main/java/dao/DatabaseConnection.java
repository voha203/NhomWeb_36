package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/web"; // Thay "your_database" bằng tên database của bạn
    private static final String USER = "root"; // Thay "root" bằng tên user của MySQL
    private static final String PASSWORD = ""; // Thay "password" bằng mật khẩu của bạn

//    public static Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(URL, USER, PASSWORD);
//    }


    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Đảm bảo driver được tải
        } catch (ClassNotFoundException e) {
            System.err.println("Driver không được tìm thấy: " + e.getMessage());
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void testConnection() {
        try (Connection connection = getConnection()) {
            if (connection != null) {
                System.out.println("Kết nối thành công!");
            }
        } catch (SQLException e) {
            System.err.println("Kết nối thất bại: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        testConnection();

    }
}
