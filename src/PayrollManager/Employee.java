package model;

import java.io.Serializable;

public abstract class Employee implements Serializable {
    private final String id;
    private final String name;
    protected double baseSalary;

    public Employee(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getId() { return id; }
    public String getName() { return name; }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Salary: " + calculateSalary();
    }
}