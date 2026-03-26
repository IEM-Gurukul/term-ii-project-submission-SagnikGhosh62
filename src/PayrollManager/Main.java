import controller.PayrollController;
import model.FullTimeEmployee;
import model.PartTimeEmployee;
import view.ConsoleView;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PayrollController controller = new PayrollController();
        ConsoleView view = new ConsoleView();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            view.showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1: // Full-Time
                    view.displayHeader("Adding Full-Time Employee");
                    System.out.print("Enter ID: "); String ftId = scanner.nextLine();
                    System.out.print("Enter Name: "); String ftName = scanner.nextLine();
                    System.out.print("Monthly Salary: "); double base = scanner.nextDouble();
                    System.out.print("Monthly Bonus: "); double bonus = scanner.nextDouble();
                    
                    controller.addEmployee(new FullTimeEmployee(ftId, ftName, base, bonus));
                    view.displayMessage("Full-Time record added!");
                    break;

                case 2: // Part-Time
                    view.displayHeader("Adding Part-Time Employee");
                    System.out.print("Enter ID: "); String ptId = scanner.nextLine();
                    System.out.print("Enter Name: "); String ptName = scanner.nextLine();
                    System.out.print("Hourly Rate: "); double rate = scanner.nextDouble();
                    System.out.print("Hours Worked: "); int hours = scanner.nextInt();
                    
                    controller.addEmployee(new PartTimeEmployee(ptId, ptName, rate, hours));
                    view.displayMessage("Part-Time record added!");
                    break;

                case 3: // View All
                    view.displayHeader("Current Payroll Records");
                    if (controller.getEmployees().isEmpty()) {
                        view.displayMessage("No employees found in system.");
                    } else {
                        // This loop demonstrates Polymorphism
                        controller.getEmployees().forEach(e -> System.out.println(e.toString()));
                    }
                    break;

                case 4: // Save and Exit
                    controller.saveToDatabase();
                    view.displayMessage("Data saved to data/employees.csv. System closing...");
                    running = false;
                    break;

                case 5:
                    view.displayMessage("Exiting without saving.");
                    running = false;
                    break;

                default:
                    view.displayMessage("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}