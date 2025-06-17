package application;

import application.ui.PrintOptions;
import models.dao.DaoFactory;
import models.dao.DepartmentDao;
import models.dao.SellerDao;
import models.entities.Department;
import models.entities.Seller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        int option = 1;
        while (option != 0) {
            clearConsole();
            PrintOptions.printOptionsPanel();
            System.out.print("select an option: ");
            option = sc.nextInt();

            if (option == 0) {
                clearConsole();
                System.out.print("Goodbye!");
                continue;
            }

            switch (option) {
                case 1 -> {
                    clearConsole();
                    PrintOptions.printDepartmentOptions();
                    System.out.print("select an option: ");
                    option = sc.nextInt();

                    switch (option) {
                        case 0 -> {
                            clearConsole();
                            System.out.print("Goodbye!");
                        }
                        case 1 -> {
                            clearConsole();
                            sc.nextLine();

                            DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
                            List<Department> allDepartmentList = departmentDao.findAll();

                            System.out.println("=== All Departments ===");
                            allDepartmentList.forEach(System.out::println);
                            System.out.println("==========================");

                            System.out.println("\nPress enter to continue");
                            sc.nextLine();
                        }
                        case 2 -> {
                            clearConsole();

                            DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
                            Department department;

                            System.out.println("=== Find Department by ID ===");
                            System.out.print("Enter the ID of the Department you want to find: ");

                            department = departmentDao.findById(sc.nextInt());
                            sc.nextLine();

                            System.out.println("===========================");
                            if (department != null) {
                                System.out.println(department);
                            } else {
                                System.out.println("Department not found!");
                            }
                            System.out.println("===========================");

                            System.out.println("\nPress enter to continue");
                            sc.nextLine();
                        }
                        case 3 -> {
                            clearConsole();
                            sc.nextLine();

                            DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
                            Department department;

                            System.out.println("=== Insertion of Department ===");
                            System.out.print("Insert the Name of the Department: ");

                            department = new Department(null, sc.nextLine());
                            departmentDao.insert(department);
                            System.out.println("===========================");

                            System.out.println("\nPress enter to continue");
                            sc.nextLine();
                        }
                        case 4 -> {
                            clearConsole();

                            DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
                            List<Department> allDepartmentList = departmentDao.findAll();

                            System.out.println("=== Update of Department by ID ===");

                            System.out.println("=== Existing departments ===");
                            allDepartmentList.forEach(System.out::println);
                            System.out.println("============================");

                            System.out.print("Enter the ID of the Department you want to update: ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter the new Name to the Department: ");
                            String name = sc.nextLine();
                            departmentDao.update(new Department(id, name));
                            System.out.println("=================================");

                            System.out.println("\nPress enter to continue");
                            sc.nextLine();
                        }
                        case 5 -> {
                            clearConsole();

                            DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
                            List<Department> allDepartmentList = departmentDao.findAll();

                            System.out.println("=== Delete Department by ID ===");
                            System.out.println("===============================");
                            allDepartmentList.forEach(System.out::println);
                            System.out.println("===============================");

                            System.out.print("Enter the ID of the Department you want to Delete: ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            departmentDao.deleteById(id);
                            System.out.println("==========================");

                            System.out.println("\nPress enter to continue");
                            sc.nextLine();
                        }
                        default -> {
                            clearConsole();
                            System.out.println("Invalid Option. Try again.");
                            Thread.sleep(800);
                            clearConsole();
                        }
                    }

                }
                case 2 -> {
                    clearConsole();
                    PrintOptions.printSellerOptions();
                    System.out.print("select an option: ");
                    option = sc.nextInt();

                    switch (option) {
                        case 0 -> {
                            clearConsole();
                            System.out.print("Goodbye!");
                        }
                        case 1 -> {
                            clearConsole();
                            sc.nextLine();

                            SellerDao sellerDao = DaoFactory.createSellerDao();
                            List<Seller> sellerList = sellerDao.findAll();

                            System.out.println("=== All Sellers ===");
                            sellerList.forEach(System.out::println);
                            System.out.println("===================");

                            System.out.println("\nPress enter to continue");
                            sc.nextLine();
                        }
                        case 2 -> {
                            clearConsole();

                            SellerDao sellerDao = DaoFactory.createSellerDao();
                            Seller seller;

                            System.out.println("=== Find Seller by ID ===");
                            System.out.print("Enter the ID of the Seller you want to find: ");

                            seller = sellerDao.findById(sc.nextInt());
                            sc.nextLine();

                            System.out.println("===========================");
                            if (seller != null) {
                                System.out.println(seller);
                            } else {
                                System.out.println("Seller not found!");
                            }
                            System.out.println("===========================");

                            System.out.println("\nPress enter to continue");
                            sc.nextLine();
                        }
                        case 3 -> {
                            clearConsole();

                            SellerDao sellerDao = DaoFactory.createSellerDao();
                            List<Seller> sellerList;

                            System.out.println("=== Find All Sellers by Department ===");
                            System.out.print("Enter the ID of the Department you want to find: ");

                            sellerList = sellerDao.findAllByDepartment(new Department(sc.nextInt(), null));
                            sc.nextLine();

                            System.out.println("===========================");
                            sellerList.forEach(System.out::println);
                            System.out.println("===========================");

                            System.out.println("\nPress enter to continue");
                            sc.nextLine();
                        }
                        case 4 -> {
                            clearConsole();
                            sc.nextLine();

                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                            SellerDao sellerDao = DaoFactory.createSellerDao();

                            DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
                            List<Department> allDepartmentList = departmentDao.findAll();

                            System.out.println("=== Insertion of Seller ===");
                            System.out.print("Insert the Name of the Seller: ");
                            String sellerName = sc.nextLine();
                            System.out.print("Insert the Email of the Seller: ");
                            String sellerEmail = sc.nextLine();
                            System.out.print("Insert the Birth Date of the Seller (yyyy-MM-dd): ");
                            LocalDate sellerBirthDate = LocalDate.parse(sc.nextLine(), formatter);
                            System.out.print("Insert the Base Salary of the Seller: ");
                            double sellerSalary = sc.nextDouble();

                            System.out.println("Insert the ID of the Department you want to add to seller.");
                            System.out.println("=== Existing Departments ===");
                            allDepartmentList.forEach(System.out::println);
                            System.out.println("============================");

                            System.out.print("Insert the Department ID: ");
                            int departmentId = sc.nextInt();
                            sc.nextLine();

                            sellerDao.insert(new Seller(null, sellerName, sellerEmail, sellerBirthDate,
                                    sellerSalary, new Department(departmentId, null)));
                            System.out.println("Seller Inserted Successfully!");
                            System.out.println("=============================");

                            System.out.println("\nPress enter to continue");
                            sc.nextLine();
                        }
                        case 5 -> {
                            clearConsole();

                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                            SellerDao sellerDao = DaoFactory.createSellerDao();
                            Seller seller;
                            List<Seller> sellerList = sellerDao.findAll();

                            DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
                            List<Department> allDepartmentList = departmentDao.findAll();

                            System.out.println("=== Update Seller by ID ===");
                            System.out.println("===========================");
                            sellerList.forEach(System.out::println);
                            System.out.println("===========================");

                            System.out.print("Enter the ID of the Seller you want to update: ");
                            int sellerId = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter the new Name of the Seller: ");
                            String sellerName = sc.nextLine();
                            System.out.print("Enter the new Email of the Seller: ");
                            String sellerEmail = sc.nextLine();
                            System.out.print("Enter the new Birth Date of the Seller(yyyy-MM-dd): ");
                            LocalDate sellerBirthDate = LocalDate.parse(sc.nextLine(), formatter);
                            System.out.print("Enter the new Base Salary of the Seller: ");
                            double sellerSalary = sc.nextDouble();

                            System.out.println("============================");
                            allDepartmentList.forEach(System.out::println);
                            System.out.println("============================");

                            System.out.print("Enter the ID of the Department for the new Seller: ");
                            int departmentId = sc.nextInt();
                            sc.nextLine();

                            seller = new Seller(sellerId, sellerName, sellerEmail, sellerBirthDate,
                                    sellerSalary, new Department(departmentId, null));
                            sellerDao.update(seller);
                            System.out.println("============================");

                            System.out.println("\nPress enter to continue");
                            sc.nextLine();
                        }
                        case 6 -> {
                            clearConsole();

                            SellerDao sellerDao = DaoFactory.createSellerDao();
                            List<Seller> allSellerList = sellerDao.findAll();

                            System.out.println("=== Delete Seller by ID ===");
                            System.out.println("===============================");
                            allSellerList.forEach(System.out::println);
                            System.out.println("===============================");

                            System.out.print("Enter the ID of the Seller you want to Delete: ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            sellerDao.deleteById(id);
                            System.out.println("==========================");

                            System.out.println("\nPress enter to continue");
                            sc.nextLine();
                        }
                        default -> {
                            clearConsole();
                            System.out.println("Invalid Option. Try again.");
                            Thread.sleep(800);
                            clearConsole();
                        }
                    }
                }
                default -> {
                    clearConsole();
                    System.out.println("Invalid Option. Try again.");
                    Thread.sleep(800);
                    clearConsole();
                }
            }
        }
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
