package Model;

// ==== Class to calculate the financing of an Apartment ==== //
public class Land extends Financing{

    //Attributes
    private final String zoneType;

    //Constructor
    public Land(double propertyValue, double annualInterestRate, int financingTerm, String zoneType) {
        super(propertyValue, annualInterestRate, financingTerm);
        this.zoneType = zoneType;
    }

    // Getters
    public String getZoneType() {
        return zoneType;
    }

    //Methods
    @Override
    public double monthlyPayment() {
        return (this.getPropertyValue() / (this.getFinancingTerm() * 12)) * (1 + (this.getAnnualInterestRate() / 12)) * 1.02; //Adding a 2% increase
    }

    @Override
    public void showSpecificAttributes() {
        System.out.println("Zone Type: " + this.getZoneType());
    }

    @Override
    public String getType() {
        return "Land";
    }
}