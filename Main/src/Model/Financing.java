package Model;

// ==== Class to calculate the financing of a property ==== //
public class Financing {

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

    public String getType() {
        return "Not specified";
    }

    //Methods
    public double monthlyPayment() {
        return (this.propertyValue / (this.financingTerm * 12)) * (1 + (this.annualInterestRate / 12));
    }

    public double totalPayment() {
        return monthlyPayment() * this.financingTerm * 12;
    }

    public void showAllFinancingData() {
        System.out.println("Property Value: R$ " + String.format("%.2f", this.getPropertyValue()));
        System.out.println("Annual Interest Rate: " + String.format("%.2f", this.getAnnualInterestRate())+"%");
        System.out.println("Financing Term: " + this.getFinancingTerm() + " years");
        System.out.println("\nMonthly Payment: R$ " + String.format("%.2f", this.monthlyPayment()));
        System.out.println("Total Payment: R$ " + String.format("%.2f", this.totalPayment()));
    }
}
