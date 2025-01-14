package controller;

import dao.UserDAO;
import model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserController", value = "/User")
public class UserController extends HttpServlet {
    private UserDAO dao;

    public UserController() {
        this.dao = new UserDAO();
    }

    // Đăng ký người dùng
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("user_name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = "user"; // Giả sử mặc định là người dùng bình thường
        String status = "active"; // Trạng thái kích hoạt

        User user = new User(0, userName, address, phone, username, password, email, role, status);
        if (dao.registerUser(user)) {
            response.sendRedirect("login.jsp"); // Redirect đến trang login sau khi đăng ký
        } else {
            response.getWriter().println("Đăng ký thất bại!");
        }
    }

    // Đăng nhập
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = dao.loginUser(username, password);
        if (user != null) {
            request.getSession().setAttribute("user", user); // Lưu thông tin người dùng vào session
            response.sendRedirect("home.jsp");
        } else {
            response.getWriter().println("Sai tên đăng nhập hoặc mật khẩu!");
        }
    }
}
