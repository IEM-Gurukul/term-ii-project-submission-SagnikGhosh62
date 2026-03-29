package controller;

import model.*;
import java.io.*;
import java.util.*;

public class PayrollController {
    private final List<Employee> employees = new ArrayList<>();
    private final String FILE_PATH = "data/Employees.csv";

    public void addEmployee(Employee e) {
        employees.add(e);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void saveToDatabase() {
    File file = new File(FILE_PATH);
    File parentDir = file.getParentFile();
    
    // Automatically create the 'data' folder if it doesn't exist
    if (parentDir != null && !parentDir.exists()) {
        parentDir.mkdirs();
    }

    try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
        for (Employee e : employees) {
            switch (e) {
                case PartTimeEmployee pt -> writer.println(pt.toCsvRow());
                case FullTimeEmployee ft -> 
                    // Formatting FullTime data for the CSV
                    writer.println(ft.getId() + "," + ft.getName() + "," + ft.calculateSalary() + ",FULL TIME");
                default -> {}
            }
        }
    } catch (IOException e) {
        System.err.println("Error saving data: " + e.getMessage());
    }
}
}