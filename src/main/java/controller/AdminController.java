package controller;

import dao.AdminDAO;
import dao.EmployeeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
import model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AdminController", value = "/Admin")
public class AdminController extends HttpServlet {
    private AdminDAO adminDAO;
    private EmployeeDAO employeeDAO;

    @Override
    public void init() throws ServletException {
        // Initialize the AdminDAO object
        this.adminDAO = new AdminDAO();
        this.employeeDAO = new EmployeeDAO(); // Assuming AdminDAO has a default constructor
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


        List<User> employees = employeeDAO.getAllEmployees();
        System.out.println(employees.toString());

        String role = (String) request.getSession().getAttribute("role");

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

}