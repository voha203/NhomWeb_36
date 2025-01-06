import dao.DatabaseConnection;
import controller.UserController;
import dao.UserDao;
import view.UserView;

public class main {
    public static void main(String[] args) {
        DatabaseConnection.testConnection();
        UserDao userDAO = new UserDao();
        UserView userView = new UserView();
        UserController userController = new UserController(userDAO, userView);

        userController.displayAllUsers();
    }
}
