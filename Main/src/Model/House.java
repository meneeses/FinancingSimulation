package Model;

import Util.SurchargeGreaterThanInterestException;

import java.util.Objects;

// ==== Class to calculate the financing of a House ==== //
public class House extends Financing{

    //Attributes
    private final String builtUpArea;
    private final String landLength;
    protected double mandatoryInsurance = 80;

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

    // Check if the mandatory insurance exceeds the annual interest rate
    private void checkSurchargeExceedsInterest(double annualInterestRate, double mandatoryInsurance) throws SurchargeGreaterThanInterestException {
        throw new SurchargeGreaterThanInterestException("\nThe mandatory insurance exceeds the annual interest rate. The mandatory insurance was set to the annual interest rate.");
    }


    @Override
    // Calculate the monthly payment for a house financing with a mandatory insurance of R$ 80
    public double monthlyPayment() {
        try {
            if (mandatoryInsurance > (this.getAnnualInterestRate())) {
                checkSurchargeExceedsInterest(this.getAnnualInterestRate(), mandatoryInsurance);
            }
        } catch (SurchargeGreaterThanInterestException e) {
            System.out.println(e.getMessage());
            mandatoryInsurance = this.getAnnualInterestRate();
        }
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

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (!(o instanceof House house)) return false;
        return Objects.equals(builtUpArea, house.builtUpArea) &&
                Objects.equals(landLength, house.landLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), builtUpArea, landLength);
    }

}
