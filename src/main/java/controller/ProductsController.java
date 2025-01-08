package controller;

import dao.ProductDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ProductsController", value = "/Product")
public class ProductsController extends HttpServlet {
    ProductDAO dao;

    public ProductsController() {
        this.dao = new ProductDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = dao.getAllProducts();
        for (Product product : products) {
            System.out.println(product.toString());
        }
        request.setAttribute("products", products);
        request.getRequestDispatcher("Products.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}