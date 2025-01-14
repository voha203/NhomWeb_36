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

    @Override
    public void init() throws ServletException {
        // Initialize the DAO objects here
        this.homeDAO = new HomeDAO();  // Assuming HomeDAO has a default constructor
        this.productDAO = new ProductDAO();  // Assuming ProductDAO has a default constructor
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the list of new and best-selling products
        List<Product> newProducts = homeDAO.getNewProducts();
        List<Product> bestSellingProducts = homeDAO.getBestSellingProducts();

        // Get the customer reviews or testimonials
        List<Review> testimonials = homeDAO.getTopThreeReviewsByProduct(); // Fetch the top 3 reviews or adjust this method as needed

        // Set the products and reviews as request attributes
        request.setAttribute("newProducts", newProducts);
        request.setAttribute("bestSellingProducts", bestSellingProducts);
        request.setAttribute("testimonials", testimonials); // Pass testimonials to the JSP

        // Forward the request to Home.jsp
        request.getRequestDispatcher("Home.jsp").forward(request, response);
    }
}
