package Model;

// ==== Class to calculate the financing of an Apartment ==== //
public class Apartment extends Financing{

    public Apartment(double propertyValue, double annualInterestRate, int financingTerm) {
        super(propertyValue, annualInterestRate, financingTerm);
    }

    @Override
    public double monthlyPayment() {
        double propertyValue = this.getPropertyValue();
        double annualInterestRate = this.getAnnualInterestRate() / 100; // Convert the annual interest rate from percentage to decimal
        double monthlyRate = annualInterestRate / 12;
        int months = this.getFinancingTerm() * 12;

        double numerator = propertyValue * Math.pow(1 + monthlyRate, months) * monthlyRate;
        double denominator = Math.pow(1 + monthlyRate, months) - 1;

        return numerator / denominator;
    }

    @Override
    public String getType() {
        return "Apartment";
    }
}
