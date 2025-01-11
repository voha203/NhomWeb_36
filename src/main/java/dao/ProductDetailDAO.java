package dao;

import model.Image;
import model.Product;
import dao.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDetailDAO {

    public Product getProductDetails(int productId) {
        Product product = null;
        String sql = "SELECT * FROM products WHERE product_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, productId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                product = new Product();
                product.setProduct_id(rs.getInt("product_id"));
                product.setProduct_name(rs.getString("product_name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getInt("price"));
                product.setStock(rs.getInt("stock"));
                product.setImage_url(rs.getString("image_url"));
                product.setCreated_at(rs.getString("created_at"));
                product.setUpdated_at(rs.getString("updated_at"));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching product details: " + e.getMessage());
        }
        return product;
    }

    public List<String> getProductImages(int productId) {
        List<String> imageLinks = new ArrayList<>();
        String sql = "SELECT image_link FROM images WHERE product_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, productId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                imageLinks.add(rs.getString("image_link"));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching product images: " + e.getMessage());
        }
        return imageLinks;
    }

    public List<Product> getRandomProducts(int productId) {
        List<Product> randomProducts = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE product_id != ? ORDER BY RAND() LIMIT 5"; // Lấy 5 sản phẩm ngẫu nhiên

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, productId); // Tránh lấy sản phẩm hiện tại
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setProduct_id(rs.getInt("product_id"));
                product.setProduct_name(rs.getString("product_name"));
                product.setPrice(rs.getInt("price"));
                product.setImage_url(rs.getString("image_url"));
                randomProducts.add(product); // Thêm sản phẩm vào danh sách
            }
        } catch (SQLException e) {
            System.err.println("Error fetching random products: " + e.getMessage());
        }
        return randomProducts;
    }
}
