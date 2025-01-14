package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CustomerDAO {

    // Lấy tất cả khách hàng
    public List<User> getAllCustomers() {
        List<User> customers = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE role = 'Customer'";  // Lọc chỉ lấy những khách hàng

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                // Chuyển dữ liệu từ ResultSet sang đối tượng User và thêm vào danh sách
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
                customers.add(user);
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching customers: " + e.getMessage());
            e.printStackTrace();
        }
        return customers;
    }

    // Xóa khách hàng theo ID
    public User getCustomerById(int customerId) {
        User customer = null;
        String sql = "SELECT * FROM users WHERE user_id = ? AND role = 'Customer'";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, customerId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                customer = new User(
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
            e.printStackTrace();
        }
        return customer;
    }

    // Delete customer
    public boolean deleteCustomer(int customerId) {
        String sql = "DELETE FROM users WHERE user_id = ? AND role = 'Customer'";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, customerId);
            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Add new customer
    public boolean addCustomer(String userName, String address, String phone, String username, String passwordHash, String email, String status) {
        String sql = "INSERT INTO users (user_name, address, phone, username, password_hash, email, role, status) VALUES (?, ?, ?, ?, ?, ?, 'Customer', ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, username);
            preparedStatement.setString(5, passwordHash);
            preparedStatement.setString(6, email);
            preparedStatement.setString(7, status);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Update customer details
    public boolean updateCustomer(int customerId, String userName, String address, String phone, String username, String passwordHash, String email, String status) {
        String sql = "UPDATE users SET user_name = ?, address = ?, phone = ?, username = ?, password_hash = ?, email = ?, status = ? WHERE user_id = ? AND role = 'Customer'";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, username);
            preparedStatement.setString(5, passwordHash);
            preparedStatement.setString(6, email);
            preparedStatement.setString(7, status);
            preparedStatement.setInt(8, customerId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAO();
        System.out.println(customerDAO.getAllCustomers());
    }
}

