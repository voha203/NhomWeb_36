package dao;

import model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {


    // Lấy danh sách sản phẩm
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setProduct_id(rs.getInt("product_id")); // Lấy giá trị product_id
                product.setProduct_name(rs.getString("product_name")); // Lấy giá trị product_name
                product.setDescription(rs.getString("description")); // Lấy giá trị description
                product.setPrice(rs.getInt("price")); // Lấy giá trị price (kiểu int)
                product.setStock(rs.getInt("stock")); // Lấy giá trị stock
                product.setImage_url(rs.getString("image_url")); // Lấy giá trị image_url
                product.setCreated_at(rs.getString("created_at")); // Lấy giá trị created_at
                product.setUpdated_at(rs.getString("updated_at")); // Lấy giá trị updated_at

                productList.add(product); // Thêm đối tượng Product vào danh sách
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching products: " + e.getMessage());
            e.printStackTrace();
        }
        return productList;
    }


    // Thêm sản phẩm mới
    public void addProduct(Product product) throws SQLException {
        String sql = "INSERT INTO products (product_name, description, price, stock, image_url, created_at) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet rs = preparedStatement.executeQuery();
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, product.getProduct_name());
                stmt.setString(2, product.getDescription());
                stmt.setInt(3, product.getPrice());
                stmt.setInt(4, product.getStock());
                stmt.setString(5, product.getImage_url());
                stmt.setString(6, product.getCreated_at());
                stmt.executeUpdate();
            }
        }
    }

    // Cập nhật sản phẩm
    public void updateProduct(Product product) throws SQLException {
        String sql = "UPDATE products SET product_name = ?, description = ?, price = ?, stock = ?, image_url = ?, updated_at = ? WHERE product_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet rs = preparedStatement.executeQuery();
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, product.getProduct_name()); // Sử dụng getter theo đúng quy ước
                stmt.setString(2, product.getDescription());
                stmt.setInt(3, product.getPrice());
                stmt.setInt(4, product.getStock());
                stmt.setString(5, product.getImage_url());
                stmt.setString(6, product.getUpdated_at());
                stmt.setInt(7, product.getProduct_id());
                stmt.executeUpdate(); // Thực thi câu lệnh
            }
        }
    }

    // Xóa sản phẩm
    public void deleteProduct(int productId) throws SQLException {
        String sql = "DELETE FROM products WHERE product_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet rs = preparedStatement.executeQuery();
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, productId);
                stmt.executeUpdate();
            }
        }
    }
}
