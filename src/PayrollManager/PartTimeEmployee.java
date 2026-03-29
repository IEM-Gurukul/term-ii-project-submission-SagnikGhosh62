package model;

public class PartTimeEmployee extends Employee {
    private final double hourlyRate;
    private final int hoursWorked;

    public PartTimeEmployee(String id, String name, double rate, int hours) {
        super(id, name, 0);
        this.hourlyRate = rate;
        this.hoursWorked = hours;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    public String toCsvRow() {
        return getId() + "," + getName() + "," + hourlyRate + "," + hoursWorked + ",PART TIME";
    }
}