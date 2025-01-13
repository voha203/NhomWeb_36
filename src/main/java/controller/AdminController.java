package controller;

import dao.AdminDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminController", value = "/Admin")
public class AdminController extends HttpServlet {
    private AdminDAO adminDAO;

    @Override
    public void init() throws ServletException {
        // Initialize the AdminDAO object
        this.adminDAO = new AdminDAO();  // Assuming AdminDAO has a default constructor
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy các số liệu từ cơ sở dữ liệu
        int totalRevenue = adminDAO.getTotalRevenue();
        int totalProducts = adminDAO.getTotalProducts();
        int totalOrders = adminDAO.getTotalOrdersInMonth();
        int totalSoldProducts = adminDAO.getTotalSoldProducts();


        // Đưa dữ liệu vào request để gửi đến trang JSP
        request.setAttribute("totalRevenue", totalRevenue);
        request.setAttribute("totalProducts", totalProducts);
        request.setAttribute("totalOrders", totalOrders);
        request.setAttribute("totalSoldProducts", totalSoldProducts);

        // Chuyển đến trang JSP
        request.getRequestDispatcher("Admin.jsp").forward(request, response);
    }
}
