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
    public boolean addProduct(Product product) {
        String sql = "INSERT INTO products (product_name, description, price, stock, image_url, created_at) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, product.getProduct_name());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setInt(3, product.getPrice());
            preparedStatement.setInt(4, product.getStock());
            preparedStatement.setString(5, product.getImage_url());
            preparedStatement.setString(6, product.getCreated_at());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error while adding product: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // Cập nhật sản phẩm
    public boolean updateProduct(Product product) {
        String sql = "UPDATE products SET product_name = ?, description = ?, price = ?, stock = ?, image_url = ?, updated_at = ? WHERE product_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, product.getProduct_name());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setInt(3, product.getPrice());
            preparedStatement.setInt(4, product.getStock());
            preparedStatement.setString(5, product.getImage_url());
            preparedStatement.setString(6, product.getUpdated_at());
            preparedStatement.setInt(7, product.getProduct_id());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error while updating product: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // Xóa sản phẩm
    public boolean deleteProduct(int productId) {
        String sql = "DELETE FROM products WHERE product_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, productId);
            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error while deleting product: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // Lấy sản phẩm theo ID
    public Product getProductById(int productId) {
        Product product = null;
        String sql = "SELECT * FROM products WHERE product_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, productId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                product = new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("description"),
                        rs.getInt("price"),
                        rs.getInt("stock"),
                        rs.getString("image_url"),
                        rs.getString("created_at"),
                        rs.getString("updated_at")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching product by ID: " + e.getMessage());
            e.printStackTrace();
        }
        return product;
    }
}
