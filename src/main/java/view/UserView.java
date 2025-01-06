package view;

import model.User;

import java.util.List;

public class UserView {
    public void displayUsers(List<User> users) {
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }
}
