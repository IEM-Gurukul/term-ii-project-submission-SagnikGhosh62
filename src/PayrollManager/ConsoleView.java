package view;

public class ConsoleView {
    
    public void showMenu() {
        System.out.println("\n========================================");
        System.out.println("      PAYROLL MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println(" 1. Add Full-Time Employee");
        System.out.println(" 2. Add Part-Time Employee");
        System.out.println(" 3. Display All Employees (Polymorphism)");
        System.out.println(" 4. Save to CSV & Exit");
        System.out.println(" 5. Exit without Saving");
        System.out.println("========================================");
        System.out.print("Select an option: ");
    }

    public void displayMessage(String message) {
        System.out.println(">> " + message);
    }

    public void displayHeader(String title) {
        System.out.println("\n--- " + title + " ---");
    }
}