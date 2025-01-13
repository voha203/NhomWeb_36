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

}
