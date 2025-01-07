import dao.DatabaseConnection;
import controller.*;
import dao.*;
import model.Product;
import view.*;

public class main {
    public static void main(String[] args) {


//        UserDao userDAO = new UserDao();
//        UserView userView = new UserView();
//        UserController userController = new UserController(userDAO, userView);
//        userController.displayAllUsers();
        ProductDAO productDAO = new ProductDAO();
        ProductView productView = new ProductView();
        ProductController productController = new ProductController(productDAO, productView);
        productController.displayAllProducts();


    }
}
