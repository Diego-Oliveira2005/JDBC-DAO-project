package application;

import models.dao.DaoFactory;
import models.dao.SellerDao;
import models.dao.impl.SellerDaoJDBC;
import models.entities.Department;
import models.entities.Seller;

import java.time.LocalDate;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("==== TEST 1: seller findById ====");
        Seller seller = sellerDao.findById(1);
        System.out.println(seller);

        System.out.println("==== TEST 2: seller findAllByDepartment ====");
        Department department = new Department(2, null);
        List<Seller> sellerList = sellerDao.findAllByDepartment(department);
        sellerList.forEach(System.out::println);

        System.out.println("==== TEST 3: seller findAll ====");
        List<Seller> allSellerList = sellerDao.findAll();
        allSellerList.forEach(System.out::println);

        System.out.println("==== TEST 4: seller Insert ====");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", LocalDate.now(), 4000.00, department);
        sellerDao.insert(newSeller);
        System.out.println("inserted! New id = " + newSeller.getId());
    }
}
