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

        SellerDao sellerDao = DaoFactory.createSellerDao();
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
        System.out.println("Inset Id for deleting test");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed!");

        System.out.println("\n==== TEST 7: Department findById ====");
        Department department = departmentDao.findById(1);
        System.out.println(department);
    }
}
