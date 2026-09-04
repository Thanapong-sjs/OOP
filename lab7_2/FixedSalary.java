package lab7_2;

public class FixedSalary extends Employee {
    private double monthlySalary;

    public FixedSalary(String firstName, String lastName, String securityNumber, double monthlySalary) {
        super(firstName, lastName, securityNumber);
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    @Override
    public double earnings() {
        return monthlySalary;
    }
}