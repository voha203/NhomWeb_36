package controller;

import com.sun.tools.javac.Main;
import dao.AdminDAO;
import dao.EmployeeDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Order;
import model.Product;
import model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AdminController", value = "/Admin")
public class AdminController extends HttpServlet {
    private AdminDAO adminDAO;
    private EmployeeDAO employeeDAO;
    private ProductDAO productDAO;
    private OrderDAO orderDAO;

    @Override
    public void init() throws ServletException {
        // Initialize the AdminDAO object
        this.adminDAO = new AdminDAO();
        this.employeeDAO = new EmployeeDAO();
        this.productDAO = new ProductDAO();
        this.orderDAO=new OrderDAO();
        // Assuming AdminDAO has a default constructor
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

        String userIdStr = request.getParameter("userId");

        // Kiểm tra nếu userId không phải là chuỗi trống và có thể chuyển thành số
        if (userIdStr != null && !userIdStr.isEmpty()) {
            try {
                int userId = Integer.parseInt(userIdStr);  // Cố gắng chuyển đổi thành int
                User employee = employeeDAO.getEmployeeById(userId); // Lấy thông tin nhân viên theo userId
                request.setAttribute("employee", employee); // Gửi thông tin nhân viên vào request để hiển thị trên form
            } catch (NumberFormatException e) {
                // Xử lý lỗi nếu userId không hợp lệ
                request.setAttribute("errorMessage", "Mã nhân viên không hợp lệ.");
            }
        }

        List<User> employees = employeeDAO.getAllEmployees();
        String role = (String) request.getSession().getAttribute("role");

        List<Product> product = productDAO.getAllProducts();
        request.setAttribute("products", product);

        List<Order> orders=orderDAO.getAllOrders();
        request.setAttribute("orders", orders);
        System.out.println(orders);



        List<User> filteredEmployees = filterEmployeesByRole(employees, role);
        request.setAttribute("employees", filteredEmployees);
        request.getRequestDispatcher("Admin.jsp").forward(request, response);
    }

    private List<User> filterEmployeesByRole(List<User> employees, String role) {
        // Filter employees based on the role (e.g., "admin" or "employee")
        List<User> filteredEmployees = new ArrayList<>();
        for (User employee : employees) {
            if ("Admin".equals(employee.getRole()) || "Employee".equals(employee.getRole())) {
                filteredEmployees.add(employee);
            }
        }
        return filteredEmployees;

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //  Kiểm tra yêu cầu xóa nhân viên
        String deleteUserIdStr = request.getParameter("deleteUserId");
        if (deleteUserIdStr != null && !deleteUserIdStr.isEmpty()) {
            try {
                int deleteUserId = Integer.parseInt(deleteUserIdStr);
                boolean isDeleted = employeeDAO.deleteEmployee(deleteUserId);
                request.setAttribute("message", isDeleted ? "Nhân viên đã được xóa thành công." : "Không thể xóa nhân viên.");
            } catch (NumberFormatException e) {
                request.setAttribute("message", "Mã nhân viên không hợp lệ.");
            }
        }

        // Handle update or add request
        String userIdStr = request.getParameter("userId");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String username = request.getParameter("tdm");
        String password = request.getParameter("mk");
        String email = request.getParameter("email");
        String role = request.getParameter("quyen");
        String status = request.getParameter("tt");

        if (userIdStr != null && !userIdStr.isEmpty()) {
            try {
                int userId = Integer.parseInt(userIdStr);
                boolean isUpdated = employeeDAO.updateEmployee(userId, name, address, phone, username, password, email, role, status);
                request.setAttribute("message", isUpdated ? "Cập nhật thông tin nhân viên thành công." : "Không thể cập nhật thông tin nhân viên.");
            } catch (NumberFormatException e) {
                request.setAttribute("message", "Mã nhân viên không hợp lệ.");
            }
        } else {
            // Add new employee
            boolean isAdded = employeeDAO.addEmployee(name, address, phone, username, password, email, role, status);
            request.setAttribute("message", isAdded ? "Thêm nhân viên thành công." : "Không thể thêm nhân viên.");
        }


        String deleteProductIdStr = request.getParameter("deleteProductId");
        if (deleteProductIdStr != null && !deleteProductIdStr.isEmpty()) {
            try {
                int deleteProductId = Integer.parseInt(deleteProductIdStr);
                boolean isDeleted = productDAO.deleteProduct(deleteProductId);
                request.setAttribute("message", isDeleted ? "Xóa sản phẩm thành công." : "Không thể xóa sản phẩm.");
            } catch (NumberFormatException e) {
                request.setAttribute("message", "Mã sản phẩm không hợp lệ.");
            }
        }


        String productIdStr = request.getParameter("productId");
        String productName = request.getParameter("productName");
        String imageUrl = request.getParameter("imageUrl");
        String description = request.getParameter("description");

        String stockStr = request.getParameter("stock");
        String priceStr = request.getParameter("price");
        String createdAt = request.getParameter("createdAt");

        if (productIdStr != null && !productIdStr.isEmpty()) {
            try {
                int productId = Integer.parseInt(productIdStr);
                int price = Integer.parseInt(priceStr);
                int stock = Integer.parseInt(stockStr);
                Product product = new Product(productId, productName, description, price, stock, imageUrl, createdAt, null);
                boolean isUpdated = productDAO.updateProduct(product);
                request.setAttribute("message", isUpdated ? "Cập nhật sản phẩm thành công." : "Không thể cập nhật sản phẩm.");
            } catch (NumberFormatException e) {
                request.setAttribute("message", "Dữ liệu không hợp lệ.");
            }
        } else {
            try {
                int price = Integer.parseInt(priceStr);
                int stock = Integer.parseInt(stockStr);
                Product product = new Product(0, productName, description, price, stock, imageUrl, createdAt, null);
                boolean isAdded = productDAO.addProduct(product);
                request.setAttribute("message", isAdded ? "Thêm sản phẩm thành công." : "Không thể thêm sản phẩm.");
            } catch (NumberFormatException e) {
                request.setAttribute("message", "Dữ liệu không hợp lệ.");
            }
        }




        doGet(request, response);

    }

}
            // Lấy action từ request



