package model;

public class FullTimeEmployee extends Employee {
    private double bonus;

    public FullTimeEmployee(String id, String name, double baseSalary, double bonus) {
        super(id, name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }

    public String toCsvRow() {
        return getId() + "," + getName() + "," + baseSalary + "," + bonus;
    }
}
