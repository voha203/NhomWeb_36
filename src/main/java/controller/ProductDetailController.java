package controller;

import dao.ProductDAO;
import dao.ProductDetailDAO;
import model.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductsDetailController", value = "/Detail")
public class ProductDetailController extends HttpServlet {
    ProductDetailDAO productDetailDAO;
    ProductDAO productDAO;


    public ProductDetailController(ProductDetailDAO productDetailDAO, ProductDAO productDAO) {
        this.productDetailDAO = productDetailDAO;
        this.productDAO = productDAO;
    }

    public ProductDetailController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy ID sản phẩm từ yêu cầu URL
        String productIdParam = request.getParameter("product_id");

        if (productIdParam != null) {
            int productId = Integer.parseInt(productIdParam);

            // Lấy thông tin chi tiết sản phẩm từ cơ sở dữ liệu
            ProductDetailDAO productDAO = new ProductDetailDAO();
            Product product = productDAO.getProductDetails(productId);

            // Lấy các hình ảnh thu nhỏ cho sản phẩm
            List<String> thumbnailImages = productDAO.getProductImages(productId);

            // Lấy các sản phẩm ngẫu nhiên (5 sản phẩm)
            List<Product> relatedProducts = productDAO.getRandomProducts(productId);

            // Đặt thông tin vào request để sử dụng trong JSP
            request.setAttribute("product", product);
            request.setAttribute("imageUrls", thumbnailImages);
            request.setAttribute("relatedProducts", relatedProducts);

            // Chuyển hướng đến trang chi tiết sản phẩm
            RequestDispatcher dispatcher = request.getRequestDispatcher("/productDetails.jsp");
            dispatcher.forward(request, response);
        } else {
            // Nếu không có product_id, chuyển hướng về trang lỗi hoặc danh sách sản phẩm
            response.sendRedirect("errorPage.jsp");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
