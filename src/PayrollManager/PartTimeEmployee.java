package model;

public class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String id, String name, double hourlyRate, int hoursWorked) {
        // We pass 0 as baseSalary to the super constructor because 
        // part-time pay is calculated purely by hours.
        super(id, name, 0); 
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    // Polymorphism in action: This implementation is different 
    // from FullTimeEmployee's calculation.
    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    public String toCsvRow() {
        return getId() + "," + getName() + "," + hourlyRate + "," + hoursWorked + ",PART_TIME";
    }
}