package application;

import application.ui.PrintOptions;
import com.sun.security.jgss.GSSUtil;
import models.dao.DaoFactory;
import models.dao.DepartmentDao;
import models.dao.SellerDao;
import models.entities.Department;
import models.entities.Seller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        int option = 1;
        while (option != 0) {
            clearConsole();
            PrintOptions.printOptionsPanel();
            option = sc.nextInt();

            if (option == 0) {
                continue;
            }

            switch (option) {
                case 1 -> {
                    while (option != 0) {
                        clearConsole();
                        PrintOptions.printDepartmentOptions();
                        option = sc.nextInt();

                        switch (option) {
                            case 0 -> {
                                System.out.println("Goodbye!");
                            }
                            case 1 -> {
                                clearConsole();
                                DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
                                List<Department> allDepartmentList = departmentDao.findAll();

                                System.out.println("=== All Departments ===");
                                allDepartmentList.forEach(System.out::println);
                                System.out.println("==========================");

                                System.out.println("\nPress enter to continue");
                                sc.nextLine();
                                sc.nextLine();
                            }
                            case 2 -> {
                                clearConsole();
                                DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
                                Department department;

                                System.out.println("=== Find Department By ID ===");
                                System.out.print("Enter the ID of the Department you want to find: ");

                                department = departmentDao.findById(sc.nextInt());

                                System.out.println("===========================");
                                if (department != null) {
                                    System.out.println(department);
                                }
                                else{
                                    System.out.println("Department not found!");
                                }
                                System.out.println("===========================");

                                System.out.println("\nPress enter to continue");
                                sc.nextLine();
                                sc.nextLine();
                            }
                            case 3 -> {

                            }
                            case 4 -> {

                            }
                            case 5 -> {

                            }
                            default -> {
                                clearConsole();
                                System.out.println("Invalid Option. Try again.");
                                Thread.sleep(800);
                            }
                        }
                    }
                }
                case 2 -> {
                    clearConsole();
                    PrintOptions.printSellerOptions();
                    option = sc.nextInt();

                    switch (option) {
                        case 0 -> {
                            System.out.println("Goodbye!");
                        }
                        case 1 -> {
                            clearConsole();
                            SellerDao sellerDao = DaoFactory.createSellerDao();
                            List<Seller> sellerList = sellerDao.findAll();

                            System.out.println("=== All Sellers ===");
                            sellerList.forEach(System.out::println);
                            System.out.println("===================");

                            System.out.println("\nPress enter to continue");
                            sc.nextLine();
                            sc.nextLine();
                        }
                        case 2 -> {

                        }
                        case 3 -> {

                        }
                        case 4 -> {

                        }
                        case 5 -> {

                        }
                        default -> {
                            clearConsole();
                            System.out.println("Invalid Option. Try again.");
                            Thread.sleep(800);
                        }
                    }
                }
                default -> {
                    clearConsole();
                    System.out.println("Invalid Option. Try again.");
                    Thread.sleep(800);
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
