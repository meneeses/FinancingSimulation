package Model;

// ==== Class to calculate the financing of a House ==== //
public class House extends Financing{

    //Attributes
    private final String builtUpArea;
    private final String landLength;
    protected final int mandatoryInsurance = 80;

    //Constructor
    public House(double propertyValue, double annualInterestRate, int financingTerm, String builtUpArea, String landLength) {
        super(propertyValue, annualInterestRate, financingTerm);
        this.builtUpArea = builtUpArea;
        this.landLength = landLength;
    }

    public String getBuiltUpArea() {
        return builtUpArea;
    }

    public String getLandLength() {
        return landLength;
    }

    //Methods
    @Override
    // Calculate the monthly payment for a house financing with a mandatory insurance of R$ 80
    public double monthlyPayment() {
        return (this.getPropertyValue() / (this.getFinancingTerm() * 12)) * (1 + (this.getAnnualInterestRate() / 12)) + mandatoryInsurance;
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
