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
    }
