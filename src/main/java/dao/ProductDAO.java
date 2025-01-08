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

        String sql = "SELECT * FROM products";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
             ResultSet rs =preparedStatement.executeQuery();

            while (rs.next()) {
                Product product = new Product();
            product.setLink(rs.getString("link"));

                product.setProductName(rs.getString("product_name"));
                product.setPrice(rs.getDouble("price"));

                // Xử lý thông tin ảnh


                productList.add(product);
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching products: " + e.getMessage());
            e.printStackTrace();
        }
        return productList;
    }
}
