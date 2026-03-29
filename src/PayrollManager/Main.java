import controller.PayrollController;
import model.*;
import view.ConsoleView;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PayrollController controller = new PayrollController();
        ConsoleView view = new ConsoleView();

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                view.showMenu();
                try {
                    int choice = Integer.parseInt(sc.nextLine());
                    if (choice == 4) {
                        controller.saveToDatabase();
                        view.displayMessage("Data saved. Exiting...");
                        break;
                    }

                    if (choice == 1 || choice == 2) {
                        System.out.print("ID: "); String id = sc.nextLine();
                        System.out.print("Name: "); String name = sc.nextLine();

                        switch (choice) {
                            case 1 -> {
                                System.out.print("Base: "); 
                                double base = Double.parseDouble(sc.nextLine());
                                System.out.print("Bonus: "); 
                                double bonus = Double.parseDouble(sc.nextLine());
                                controller.addEmployee(new FullTimeEmployee(id, name, base, bonus));
                            }
                            case 2 -> {
                                System.out.print("Rate: "); 
                                double rate = Double.parseDouble(sc.nextLine());
                                System.out.print("Hours: "); 
                                int hours = Integer.parseInt(sc.nextLine());
                                controller.addEmployee(new PartTimeEmployee(id, name, rate, hours));
                            }
                        }
                    } else if (choice == 3) {
                        controller.getEmployees().forEach(System.out::println);
                    }
                } catch (NumberFormatException e) {
                    view.displayMessage("Invalid input! Please enter numeric values.");
                }
            }
        }
    }
}