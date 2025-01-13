package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static dao.DatabaseConnection.getConnection;


public class AdminDAO {

        // Truy vấn tổng doanh thu trong tháng
        public int getTotalRevenue() {
            String sql = "SELECT SUM(total_amount) AS total_revenue FROM orders WHERE order_date >= CURDATE() - INTERVAL 1 MONTH";
            try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                if (rs.next()) {
                    return rs.getInt("total_revenue");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return 0;
        }

        // Truy vấn tổng số lượng sản phẩm hiện có
        public int getTotalProducts() {
            String sql = "SELECT COUNT(*) AS total_products FROM products";
            try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                if (rs.next()) {
                    return rs.getInt("total_products");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return 0;
        }

        // Truy vấn số lượt bán được trong tháng
        public int getTotalOrdersInMonth() {
            String sql = "SELECT COUNT(DISTINCT orders.order_id) AS total_sales " +
                    "FROM orders " +
                    "JOIN order_status ON orders.status_id = order_status.status_id " +
                    "WHERE orders.order_date >= CURDATE() - INTERVAL 1 MONTH " +
                    "AND order_status.status_name = 'Đã giao'";

            try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                if (rs.next()) {
                    return rs.getInt("total_sales");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return 0;
        }


    // Truy vấn tổng số sản phẩm đã bán trong tháng
        public int getTotalSoldProducts() {
            String sql = "SELECT SUM(quantity) AS total_sold FROM order_details JOIN orders ON orders.order_id = order_details.order_id WHERE orders.order_date >= CURDATE() - INTERVAL 1 MONTH";
            try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                if (rs.next()) {
                    return rs.getInt("total_sold");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return 0;
        }
    }


