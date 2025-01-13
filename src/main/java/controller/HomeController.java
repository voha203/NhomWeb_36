package controller;

import dao.HomeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeController", urlPatterns = {"/Home"})
public class HomeController extends HttpServlet {
    private HomeDAO homeDAO;

    @Override
    public void init() throws ServletException {
        // Khởi tạo DAO khi Servlet được load
        this.homeDAO = new HomeDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy danh sách sản phẩm mới và bán chạy
        List<Product> newProducts = homeDAO.getNewProducts();
        List<Product> bestSellingProducts = homeDAO.getBestSellingProducts();

        // Đặt danh sách sản phẩm vào request
        request.setAttribute("newProducts", newProducts);
        request.setAttribute("bestSellingProducts", bestSellingProducts);

        // Chuyển tiếp tới trang Home.jsp
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
