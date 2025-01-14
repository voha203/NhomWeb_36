package dao;

import model.User;
import dao.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDAO {


    public List<User> getAllEmployees() {
        List<User> employees = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                User user = new User(
                        rs.getInt("user_id"),
                        rs.getString("user_name"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getString("username"),
                        rs.getString("password_hash"),
                        rs.getString("email"),
                        rs.getString("role"),
                        rs.getString("status")
                );
                employees.add(user);
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching new products: " + e.getMessage());
            e.printStackTrace();
        }
        return employees;
    }

    public boolean deleteEmployee(int userId) {
        String sql = "DELETE FROM users WHERE user_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, userId);
            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0; // Nếu có ít nhất 1 dòng bị xóa, trả về true
        } catch (SQLException e) {
            System.err.println("Error while deleting employee: " + e.getMessage());
            e.printStackTrace();
        }
        return false; // Trả về false nếu không xóa được
    }

    public boolean addEmployee(String user_name, String address, String phone, String username, String password_hash, String email, String role, String status) {
        String sql = "INSERT INTO users (user_name, address, phone, username, password_hash, email, role, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, user_name);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, username);
            preparedStatement.setString(5, password_hash);
            preparedStatement.setString(6, email);
            preparedStatement.setString(7, role);
            preparedStatement.setString(8, status);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Phương thức lấy nhân viên theo userId
    public User getEmployeeById(int userId) {
        User employee = null;
        String sql = "SELECT * FROM users WHERE user_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();

            // Nếu tìm thấy kết quả
            if (rs.next()) {
                employee = new User(
                        rs.getInt("user_id"),
                        rs.getString("user_name"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getString("username"),
                        rs.getString("password_hash"),
                        rs.getString("email"),
                        rs.getString("role"),
                        rs.getString("status")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching employee by ID: " + e.getMessage());
            e.printStackTrace();
        }
        return employee;
    }

    // Phương thức cập nhật thông tin nhân viên
    public boolean updateEmployee(int userId, String name, String address, String phone, String username, String password, String email, String role, String status) {
        String sql = "UPDATE users SET user_name = ?, address = ?, phone = ?, username = ?, password_hash = ?, email = ?, role = ?, status = ? WHERE user_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Set các giá trị cho PreparedStatement
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, username);
            preparedStatement.setString(5, password);
            preparedStatement.setString(6, email);
            preparedStatement.setString(7, role);
            preparedStatement.setString(8, status);
            preparedStatement.setInt(9, userId); // Set giá trị user_id

            // Thực thi câu lệnh cập nhật
            int rowsAffected = preparedStatement.executeUpdate();

            // Nếu có ít nhất 1 dòng bị ảnh hưởng, trả về true
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error while updating employee: " + e.getMessage());
            e.printStackTrace();
        }
        return false; // Trả về false nếu không thể cập nhật
    }





}

