package application.ui;

public class PrintOptions {
    public static void printOptionsPanel() {
        System.out.println("=== Options Panel ===");
        System.out.println("1. Department Options");
        System.out.println("2. Seller Options");
        System.out.println("0. Quit");
        System.out.println("=====================");
    }

    public static void printDepartmentOptions() {
        System.out.println("=== Department Options ===" +
                "\n1. Find All Departments" +
                "\n2. Find Department by ID" +
                "\n3. Insert new Department" +
                "\n4. Update Department" +
                "\n5. Delete Department" +
                "\n0. Quit" +
                "\n==========================");
    }

    public static void printSellerOptions() {
        System.out.println("=== Seller Options ===" +
                "\n1. Find All Sellers" +
                "\n2. Find Seller by ID" +
                "\n3. Find All Sellers by Department" +
                "\n4. Insert new Seller" +
                "\n5. Update Seller" +
                "\n6. Delete Seller" +
                "\n0. Quit" +
                "\n==========================");
    }
}
