package dao;

import model.Image;
import model.Product;
import dao.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM products"; // Lưu ý, bạn cần đảm bảo có cột 'link' trong bảng 'products'

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setProduct_id(rs.getInt("product_id"));
                product.setProduct_name(rs.getString("product_name"));
                product.setPrice(rs.getDouble("price"));
                product.setImage_url(rs.getString("image_url"));

                productList.add(product);
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching products: " + e.getMessage());
            e.printStackTrace();
        }
        return productList;
    }
}
