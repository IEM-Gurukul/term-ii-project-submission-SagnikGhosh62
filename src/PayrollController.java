package controller;

import model.Employee;
import model.PartTimeEmployee;
import model.FullTimeEmployee;
import java.io.*;
import java.util.*;

public class PayrollController {
    private List<Employee> employees = new ArrayList<>();
    private final String FILE_PATH = "data/employees.csv";

    public void addEmployee(Employee e) {
        employees.add(e);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    // Persistent Storage Implementation
    public void saveToDatabase() {
    try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
        for (Employee e : employees) {
            if (e instanceof FullTimeEmployee) {
                writer.println(((FullTimeEmployee) e).toCsvRow() + ",FULL_TIME");
            } else if (e instanceof PartTimeEmployee) {
                writer.println(((PartTimeEmployee) e).toCsvRow());
            }
        }
    } catch (IOException e) {
        System.err.println("Database Error: " + e.getMessage());
    }
}
}