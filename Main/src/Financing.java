// ==== Class to calculate the financing of a property ==== //
class Financing {

    //Attributes
    double propertyValue;
    double annualInterestRate;
    int financingTerm;

    //Constructor
    public Financing(double propertyValue, double annualInterestRate, int financingTerm) {
        this.propertyValue = propertyValue;
        this.annualInterestRate = annualInterestRate;
        this.financingTerm = financingTerm;
    }

    //Methods
    public double monthlyPayment() {
        return (this.propertyValue / (this.financingTerm * 12)) * (1 + (this.annualInterestRate / 12));
    }

    public double totalPayment() {
        return monthlyPayment() * this.financingTerm * 12;
    }

}
