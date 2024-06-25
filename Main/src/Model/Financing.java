package Model;

// ==== Class to calculate the financing of a property ==== //
public abstract class Financing {

    //Attributes
    private final double propertyValue;
    private final double annualInterestRate;
    private final int financingTerm;

    //Constructor
    public Financing(double propertyValue, double annualInterestRate, int financingTerm) {
        this.propertyValue = propertyValue;
        this.annualInterestRate = annualInterestRate;
        this.financingTerm = financingTerm;
    }

    // Getters
    public double getPropertyValue() {
        return propertyValue;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getFinancingTerm() {
        return financingTerm;
    }


    // ==== METHODS =====

    //Abstract Method to calculate the monthly payment
    public abstract double monthlyPayment();

    //Abstract Method to show the specific attributes of each type of property
    public abstract void showSpecificAttributes();

    //Abstract Method to get the type of the property
    public abstract String getType();

    //Method to calculate the total payment
    public double totalPayment() {
        return monthlyPayment() * this.financingTerm * 12;
    }

    //Method to show all financing data
    public void showAllFinancingData() {
        System.out.println("Property Value: R$ " + String.format("%.2f", this.getPropertyValue()));
        System.out.println("Annual Interest Rate: " + String.format("%.2f", this.getAnnualInterestRate())+"%");
        System.out.println("Financing Term: " + this.getFinancingTerm() + " years");
        System.out.println("\nMonthly Payment: R$ " + String.format("%.2f", this.monthlyPayment()));
        System.out.println("Total Payment: R$ " + String.format("%.2f", this.totalPayment()));
    }
}
