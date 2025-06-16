package application.ui;

public class PrintOptions {
    public static void printOptionsPanel() {
        System.out.println("""
                
                === Options Panel ===\
                
                1. Department Options\
                
                2. Seller Options\
                
                0. Quit\
                
                =====================\
                
                Select an option:\s""");
    }

    public static void printDepartmentOptions() {
        System.out.println("""
                === Department Options ===\
                
                1. Find All Departments\
                
                2. Find Department by ID\
                
                3. Insert new Department\
                
                4. Update Department\
                
                5. Delete Department\
                
                0. Quit\
                
                ==========================\
                
                Select an option:\s""");
    }

    public static void printSellerOptions() {
        System.out.println("""
                === Seller Options ===\
                
                1. Find All Sellers\
                
                2. Find Seller by ID\
                
                3. Find All Sellers by Department\
                
                4. Insert new Seller\
                
                5. Update Seller\
                
                6. Delete Seller\
                
                0. Quit\
                
                ==========================\
                
                Select an option:\s""");
    }
}
