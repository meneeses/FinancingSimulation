package Model;

// ==== Class to calculate the financing of a House ==== //
public class House extends Financing{

    //Attributes
    private final int mandatoryInsurance = 80;

    //Constructor
    public House(double propertyValue, double annualInterestRate, int financingTerm) {
        super(propertyValue, annualInterestRate, financingTerm);
    }

    // Getters
    public int getMandatoryInsurance() {
        return mandatoryInsurance;
    }

    //Methods
    @Override
    public double monthlyPayment() {
        return (this.getPropertyValue() / (this.getFinancingTerm() * 12)) * (1 + (this.getAnnualInterestRate() / 12)) + this.mandatoryInsurance;
    }

    @Override
    public String getType() {
        return "House";
    }
}
