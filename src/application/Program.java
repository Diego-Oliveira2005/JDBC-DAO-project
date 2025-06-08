package application;

import models.entities.Department;
import models.entities.Seller;

import java.time.LocalDateTime;

public class Program {
    public static void main(String[] args) {
        Department obj = new Department(1, "Books");
        Seller seller = new Seller(24, "Bob", "bob@gmail.com", LocalDateTime.now(), 3000.00, obj);
        System.out.println(seller);
    }
}
