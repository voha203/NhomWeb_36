package controller;

import dao.AdminDAO;
import dao.UserDAO;
import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
import model.User;
import java.io.IOException;

@WebServlet(name = "UserController", value = "/Login")
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
        String createdAt = java.time.LocalDateTime.now().toString(); // Thời gian tạo tài khoản

        // Tạo đối tượng User
        User user = new User(0, userName, address, phone, username, password, email, role, status);
        user.setCreated_at(createdAt);

        // Gọi phương thức đăng ký người dùng từ UserDAO
        if (dao.registerUser(user)) {
            response.sendRedirect("Login.jsp"); // Redirect đến trang login sau khi đăng ký thành công
        } else {
            response.getWriter().println("Đăng ký thất bại!"); // Thông báo khi đăng ký thất bại
        }
    }

    // Đăng nhập
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Kiểm tra đăng nhập thông qua UserDAO
        User user = dao.loginUser(username, password);
        if (user != null) {
            // Lưu thông tin người dùng vào session nếu đăng nhập thành công
            request.getSession().setAttribute("user", user);
            response.sendRedirect("home.jsp"); // Redirect đến trang home sau khi đăng nhập thành công
        } else {
            response.getWriter().println("Sai tên đăng nhập hoặc mật khẩu!"); // Thông báo khi đăng nhập thất bại
        }
    }

    // Thay đổi mật khẩu
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String newPassword = request.getParameter("new_password");

        if (dao.changePassword(username, newPassword)) {
            response.getWriter().println("Thay đổi mật khẩu thành công!");
        } else {
            response.getWriter().println("Thay đổi mật khẩu thất bại!");
        }
    }

    // Xử lý các phương thức khác (nếu có)
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        // Xử lý xóa người dùng (nếu cần)
    }
}
