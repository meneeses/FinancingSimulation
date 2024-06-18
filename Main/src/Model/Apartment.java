package Model;

// ==== Class to calculate the financing of an Apartment ==== //
public class Apartment extends Financing{

    //Attributes
    private final int parkingSpaces;
    private final int floorNumber;

    //Constructor
    public Apartment(double propertyValue, double annualInterestRate, int financingTerm, int parkingSpaces, int floorNumber) {
        super(propertyValue, annualInterestRate, financingTerm);
        this.parkingSpaces = parkingSpaces;
        this.floorNumber = floorNumber;
    }

    // Getters
    public int getParkingSpaces() {
        return parkingSpaces;
    }
    public int getFloorNumber() {
        return floorNumber;
    }

    //Methods
    @Override
    // Calculate the monthly payment for an apartment financing
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
    public void showSpecificAttributes() {
        System.out.println("Parking Spaces: " + this.getParkingSpaces());
        System.out.println("Floor Number: " + this.getFloorNumber() + "°");
    }

    @Override
    public String getType() {
        return "Apartment";
    }
}
