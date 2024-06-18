package Model;

// ==== Class to calculate the financing of a House ==== //
public class House extends Financing{

    //Attributes
    private final int mandatoryInsurance = 80;
    private final String builtUpArea;
    private final String landLength;

    //Constructor
    public House(double propertyValue, double annualInterestRate, int financingTerm, String builtUpArea, String landLength) {
        super(propertyValue, annualInterestRate, financingTerm);
        this.builtUpArea = builtUpArea;
        this.landLength = landLength;
    }

    // Getters
    public int getMandatoryInsurance() {
        return mandatoryInsurance;
    }

    public String getBuiltUpArea() {
        return builtUpArea;
    }

    public String getLandLength() {
        return landLength;
    }

    //Methods
    @Override
    public double monthlyPayment() {
        return (this.getPropertyValue() / (this.getFinancingTerm() * 12)) * (1 + (this.getAnnualInterestRate() / 12)) + this.mandatoryInsurance;
    }

    @Override
    public void showSpecificAttributes() {
        System.out.println("Built-up Area: " + this.getBuiltUpArea() + "m²");
        System.out.println("Land Length: " + this.getLandLength() + "m²");
    }

    @Override
    public String getType() {
        return "House";
    }
}
