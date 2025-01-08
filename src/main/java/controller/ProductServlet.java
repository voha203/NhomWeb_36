package controller;

import dao.ProductDAO;
import jakarta.servlet.annotation.WebServlet;
import model.Product;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy danh sách sản phẩm từ ProductDAO
        List<Product> products = productDAO.getAllProducts();
        // Truyền danh sách sản phẩm vào request
        request.setAttribute("products", products);
        // Chuyển tiếp đến trang JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("Product.jsp");
        dispatcher.forward(request, response);
    }
}
