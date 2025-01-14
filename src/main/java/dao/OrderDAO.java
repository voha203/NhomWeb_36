package dao;

import model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    // Lấy danh sách tất cả đơn hàng từ bảng orders
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders"; // Chỉ lấy dữ liệu từ bảng orders

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            // Duyệt qua từng dòng kết quả trả về
            while (rs.next()) {
                Order order = new Order();
                order.setOrder_id(rs.getInt("order_id"));
                order.setUser_id(rs.getInt("user_id"));
                order.setName(rs.getString("name"));
                order.setPhone(rs.getInt("phone"));
                order.setAddress(rs.getString("address"));
                order.setTotal_amount(rs.getInt("total_amount"));
                order.setOrder_status(rs.getString("order_status"));
                order.setOrder_date(rs.getString("order_date"));

                orders.add(order); // Thêm đơn hàng vào danh sách
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching orders: " + e.getMessage());
            e.printStackTrace();
        }
        return orders; // Trả về danh sách các đơn hàng
    }

    public static void main(String[] args) {
        try {
            OrderDAO orderDAO = new OrderDAO();
            List<Order> orders = orderDAO.getAllOrders();
            for (Order order : orders) {
                System.out.println(order);
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
