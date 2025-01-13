package dao;


import model.Image;
import model.Product;
import dao.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class HomeDAO {

    public List<Product> getNewProducts() {
        List<Product> newProducts = new ArrayList<>();
        String sql = "SELECT * FROM products ORDER BY created_at DESC LIMIT 5";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setProduct_id(rs.getInt("product_id"));
                product.setProduct_name(rs.getString("product_name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getInt("price"));
                product.setStock(rs.getInt("stock"));
                product.setImage_url(rs.getString("image_url"));
                product.setCreated_at(rs.getString("created_at"));
                product.setUpdated_at(rs.getString("updated_at"));

                newProducts.add(product);
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching new products: " + e.getMessage());
            e.printStackTrace();
        }
        return newProducts;
    }

    // Phương thức lấy danh sách sản phẩm bán chạy
    public List<Product> getBestSellingProducts() {
        List<Product> bestSellingProducts = new ArrayList<>();
        String sql = "SELECT * FROM products ORDER BY stock DESC LIMIT 5";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setProduct_id(rs.getInt("product_id"));
                product.setProduct_name(rs.getString("product_name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getInt("price"));
                product.setStock(rs.getInt("stock"));
                product.setImage_url(rs.getString("image_url"));
                product.setCreated_at(rs.getString("created_at"));
                product.setUpdated_at(rs.getString("updated_at"));

                bestSellingProducts.add(product);
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching best-selling products: " + e.getMessage());
            e.printStackTrace();
        }
        return bestSellingProducts;
    }
}
