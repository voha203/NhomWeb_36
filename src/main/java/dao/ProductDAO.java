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
                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                product.setStock(rs.getInt("stock"));

                // Xử lý link của sản phẩm
                product.setLink(rs.getString("link"));

                // Nếu bảng có thông tin về hình ảnh, bạn có thể tạo đối tượng Image và gán cho sản phẩm
                // Giả sử bạn có cột 'image_id' và 'image_url' trong bảng 'products' để lưu thông tin hình ảnh
                String imageUrl = rs.getString("image_url"); // giả sử có cột 'image_url' trong bảng products
                Image image = new Image(rs.getInt("image_id"), imageUrl); // Tạo đối tượng Image
                product.setImage(image); // Gán hình ảnh vào sản phẩm

                productList.add(product);
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching products: " + e.getMessage());
            e.printStackTrace();
        }
        return productList;
    }
}
