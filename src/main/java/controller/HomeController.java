package controller;

import dao.HomeDAO;
import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
import model.Review;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeController", urlPatterns = {"/Home"})
public class HomeController extends HttpServlet {
    private HomeDAO homeDAO;
    private ProductDAO productDAO;

    public HomeController(HomeDAO homeDAO, ProductDAO productDAO) {
        this.homeDAO = homeDAO;
        this.productDAO = productDAO;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy danh sách sản phẩm mới và bán chạy
            // Lấy danh sách sản phẩm mới và bán chạy
            List<Product> newProducts = homeDAO.getNewProducts();
            List<Product> bestSellingProducts = homeDAO.getBestSellingProducts();

            // Lấy các đánh giá hoặc phản hồi của khách hàng
            List<Review> testimonials = homeDAO.getTopThreeReviewsByProduct(); // Fetch all reviews or specific ones based on your logic

            // Đặt các sản phẩm và đánh giá vào request
            request.setAttribute("newProducts", newProducts);
            request.setAttribute("bestSellingProducts", bestSellingProducts);
            request.setAttribute("testimonials", testimonials); // Set testimonials for the JSP

            // Chuyển tiếp tới trang Home.jsp
            request.getRequestDispatcher("Home.jsp").forward(request, response);
        }

    }
