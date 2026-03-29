package view;

public class ConsoleView {
    public void showMenu() {
        System.out.println("\n--- PAYROLL MANAGEMENT SYSTEM ---");
        System.out.println("1. Add Full-Time Employee");
        System.out.println("2. Add Part-Time Employee");
        System.out.println("3. Display All Records");
        System.out.println("4. Save & Exit");
        System.out.print("Select choice: ");
    }

    public void displayMessage(String msg) {
        System.out.println(">> " + msg);
    }
}