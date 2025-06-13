package application;

import models.dao.DaoFactory;
import models.dao.DepartmentDao;
import models.dao.SellerDao;
import models.entities.Department;
import models.entities.Seller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int option = 1;
        while (option != 0) {
            System.out.println("=== Options Panel ===");
            System.out.println("1. Department Options");
            System.out.println("2. Seller Options");
            System.out.println("0. Quit");
            System.out.println("=====================");
            option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    clearConsole();
                    System.out.println("=== Department Options ===");
                    System.out.println("1. Find All Departments");
                    System.out.println("2. Find Department by ID");
                    System.out.println("3. Insert new Department");
                    System.out.println("4. Update Department");
                    System.out.println("5. Delete Department");
                    System.out.println("0. Quit");
                    System.out.println("==========================");
                    option = sc.nextInt();
                }
                case 2 -> {
                    clearConsole();
                    System.out.println("=== Seller Options ===");
                    System.out.println("1. Find All Sellers");
                    System.out.println("2. Find All Sellers by Department ID");
                    System.out.println("3. Find Seller by ID");
                    System.out.println("4. Insert new Seller");
                    System.out.println("5. Update Seller");
                    System.out.println("6. Delete Seller");
                    System.out.println("0. Quit");
                    System.out.println("==========================");
                    option = sc.nextInt();
                }
            }
        }
        /*SellerDao sellerDao = DaoFactory.createSellerDao();
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("==== TEST 1: seller findById ====");
        Seller seller = sellerDao.findById(1);
        System.out.println(seller);

        System.out.println("\n==== TEST 2: seller findAllByDepartment ====");
        Department dep = new Department(2, null);
        List<Seller> sellerList = sellerDao.findAllByDepartment(dep);
        sellerList.forEach(System.out::println);

        System.out.println("\n==== TEST 3: seller findAll ====");
        List<Seller> allSellerList = sellerDao.findAll();
        allSellerList.forEach(System.out::println);

        System.out.println("\n==== TEST 4: seller Insert ====");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", LocalDate.now(), 4000.00, dep);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("\n==== TEST 5: seller Update ====");
        seller = sellerDao.findById(1);
        seller.setName("Mario Cadabra");
        sellerDao.update(seller);
        System.out.println("Update completed!");

        System.out.println("\n==== TEST 6: seller Delete ====");
        System.out.println("Insert Id for deleting test");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed!");

        System.out.println("\n==== TEST 7: Department findById ====");
        Department department = departmentDao.findById(1);
        System.out.println(department);

        System.out.println("\n==== TEST 8: Department findAll ====");
        List<Department> departmentList = departmentDao.findAll();
        departmentList.forEach(System.out::println);

        System.out.println("\n==== TEST 9: Department Insert ====");
        Department newDepartment = new Department(null, "Linpus");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id = " + newDepartment.getId());

        System.out.println("\n==== TEST 10: Department Update ====");
        department = departmentDao.findById(2);
        department.setName("sungalunga");
        departmentDao.update(department);
        System.out.println("Update completed!");

        System.out.println("\n==== TEST 11: Department Delete ====");
        System.out.println("Insert Id for deleting test");
        id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed!");*/
    }
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
