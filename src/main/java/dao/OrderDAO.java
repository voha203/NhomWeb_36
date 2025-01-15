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
                order.setPhone(rs.getString("phone"));
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

    public boolean addOrder(String name1, String phone1, String address1, int total_amount, String order_status, String order_date) {
        String sql = "INSERT INTO orders ( name, phone, address, total_amount, order_status, order_date) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {


            preparedStatement.setString(1, name1);
            preparedStatement.setString(2, phone1);
            preparedStatement.setString(3, address1);
            preparedStatement.setInt(4, total_amount);
            preparedStatement.setString(5, order_status);
            preparedStatement.setString(6, order_date);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error while adding order: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateOrder(int orderId, int userId, String name1, String phone1, String address1, int totalAmount, String orderStatus, String orderDate) {
        String sql = "UPDATE orders SET  name = ?, phone = ?, address = ?, total_amount = ?, order_status = ?, order_date = ? WHERE order_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {


            preparedStatement.setString(1, name1);
            preparedStatement.setString(2, phone1);
            preparedStatement.setString(3, address1);
            preparedStatement.setInt(4, totalAmount);
            preparedStatement.setString(5, orderStatus);
            preparedStatement.setString(6, orderDate);
            preparedStatement.setInt(7, orderId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error while updating order: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteOrder(int orderId) {
        String sql = "DELETE FROM orders WHERE order_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, orderId);
            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error while deleting order: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

        // Phương thức lấy đơn hàng theo orderId
        public Order getOrderById(int orderId) {
            Order order = null;
            String sql = "SELECT * FROM orders WHERE order_id = ?";

            try (Connection connection = DatabaseConnection.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                // Set giá trị cho PreparedStatement
                preparedStatement.setInt(1, orderId);

                // Thực hiện câu lệnh truy vấn
                ResultSet rs = preparedStatement.executeQuery();

                // Nếu tìm thấy kết quả
                if (rs.next()) {
                    order = new Order(
                            rs.getInt("order_id"),
                            rs.getInt("user_id"),
                            rs.getString("name"),
                            rs.getString("phone"),
                            rs.getString("address"),
                            rs.getInt("total_amount"),
                            rs.getString("order_status"),
                            rs.getString("order_date")
                    );
                }
            } catch (SQLException e) {
                System.err.println("Error while fetching order by ID: " + e.getMessage());
                e.printStackTrace();
            }

            return order; // Trả về đơn hàng, nếu không tìm thấy thì trả về null
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
