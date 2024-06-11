package Model;

// ==== Class to calculate the financing of an Apartment ==== //
public class Land extends Financing{

    //Constructor
    public Land(double propertyValue, double annualInterestRate, int financingTerm) {
        super(propertyValue, annualInterestRate, financingTerm);
    }

    //Methods
    @Override
    public double monthlyPayment() {
        double basePayment = super.monthlyPayment();
        return basePayment * 1.02; // Adding a 2% increase
    }

    @Override
    public String getType() {
        return "Land";
    }
}