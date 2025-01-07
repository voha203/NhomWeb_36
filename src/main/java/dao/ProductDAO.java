package dao;

import model.Product;
import dao.DatabaseConnection;  // Nhập lớp DatabaseConnection
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        // Sử dụng DatabaseConnection để lấy kết nối
        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement()) {

            String sql = "SELECT * FROM products";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getBigDecimal("price"));
                product.setStock(rs.getInt("stock"));
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log lỗi nếu kết nối không thành công
        }
        return productList;
    }
}
