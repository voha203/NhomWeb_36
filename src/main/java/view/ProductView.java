package view;

import model.Product;
import model.User;

import java.util.List;

public class ProductView {
    public void displayProducts(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("No users found.");
        } else {
            for (Product product : products) {
                System.out.println(products);
            }
        }
    }
}

