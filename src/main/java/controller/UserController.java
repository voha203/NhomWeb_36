package controller;

import dao.UserDao;
import model.User;
import view.UserView;

import java.util.List;

public class UserController {
    private final UserDao userDao;
    private final UserView userView;

    public UserController(UserDao userDAO, UserView userView) {
        this.userDao = userDAO;
        this.userView = userView;
    }

}
