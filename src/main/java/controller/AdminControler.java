package controller;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.AdminDAO;


import java.io.IOException;
import java.util.*;

public class AdminControler {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    AdminDAO dao = new AdminDAO();

        // Lấy các số liệu từ cơ sở dữ liệu
        double totalRevenue = dao.getTotalRevenue();
        int totalProducts = dao.getTotalProducts();
        int totalOrders = dao.getTotalOrders();
        int totalSoldProducts = dao.getTotalSoldProducts();

        // Đưa dữ liệu vào request để gửi đến trang JSP
        request.setAttribute("totalRevenue", totalRevenue);
        request.setAttribute("totalProducts", totalProducts);
        request.setAttribute("totalOrders", totalOrders);
        request.setAttribute("totalSoldProducts", totalSoldProducts);

        // Chuyển đến trang JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin.jsp");
        dispatcher.forward(request, response);
    }
}

