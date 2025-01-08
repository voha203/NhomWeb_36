package controller;

import dao.ProductDAO;
import model.Product;
import view.ProductView;

import java.util.List;

public class ProductController {
    private final ProductDAO productDAO;
    private final ProductView productView;

    public ProductController(ProductDAO productDAO, ProductView productView) {
        this.productDAO = productDAO;
        this.productView = productView;
    }

    public void displayAllProducts() {
        // Lấy danh sách sản phẩm từ ProductDAO
        List<Product> products = productDAO.getAllProducts();

        // Gọi phương thức của ProductView để hiển thị sản phẩm
        productView.displayProducts(products);
    }
}
