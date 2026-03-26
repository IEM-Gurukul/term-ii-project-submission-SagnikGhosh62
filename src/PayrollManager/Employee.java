package model;

import java.io.Serializable;

public abstract class Employee implements Serializable {
    private String id;
    private String name;
    protected double baseSalary;

    public Employee(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }

    // Polymorphism: This will be implemented differently by subclasses
    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Total Salary: " + calculateSalary();
    }
}