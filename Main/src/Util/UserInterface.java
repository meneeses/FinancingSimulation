package Util;

import java.util.InputMismatchException;
import java.util.Scanner;

// ==== Class responsible for the user interface of the program. It contains methods that display messages to the user and request input from the user. ==== //
public class UserInterface {

    static Scanner scan = new Scanner(System.in);

    // Methods
    public static void welcomeMessage() {
        System.out.println("\n ==== Welcome to the Real Estate Model.Financing System! ==== \n");
        System.out.println("Please, enter the property you want to simulate the financing.");
    }

    public static void goodbyeMessage() {
        System.out.println("\nThank you for using the Real Estate Financing System!");
    }

    public static int requestPropertyType() {
        int choice = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("\nWould you like to simulate:\n1. House\n2. Apartment\n3. Land\n4. Exit\n");
                choice = scan.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scan.next(); // discard the invalid input
            }
        }
        return choice;
    }

        public static double requestPropertyValue() {
        double propertyValue;
        do {
            System.out.println("\nEnter the property value: ");
            try {
                propertyValue = scan.nextDouble();
                if (propertyValue <= 0) {
                    System.out.println("\nThe property value must be greater than zero. Please enter a valid value.");
                } else {
                    return propertyValue;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid value. Please enter a valid value.");
                scan.next();
            }
        } while (true);
    }

    public static int requestFinancingTerm() {
        int financingTerm;
        do {
            System.out.println("\nEnter the financing term (in years): ");
            try {
                financingTerm = scan.nextInt();
                if (financingTerm <= 0 || financingTerm >= 35) {
                    System.out.println("\nThe financing term must be greater than zero and less than or equal to 35 years. Please enter a valid value.");
                } else {
                    return financingTerm;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid value. Please enter a valid value.");
                scan.next();
            }
        } while (true);
    }

    public static double requestAnnualInterestRate() {
        double annualInterestRate;
        do {
            System.out.println("\nEnter the annual interest rate: ");
            try {
                annualInterestRate = scan.nextDouble();
                if (annualInterestRate <= 0) {
                    System.out.println("\nThe annual interest rate must be greater than zero. Please enter a valid value.");
                } else {
                    return annualInterestRate;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid value. Please enter a valid value.");
                scan.next();
            }
        } while (true);
    }

    // Ask the user for the built-up area of the house
    public static String requestBuiltUpArea() {
        System.out.println("\nEnter the built-up area: ");
        return scan.next();
    }
    // Ask the user for the land length
    public static String requestLandLength() {
        System.out.println("\nEnter the land length: ");
        return scan.next();
    }

    // Ask the user for the number of parking spaces
    public static int requestParkingSpaces() {
        int parkingSpaces;
        do {
            System.out.println("\nEnter the number of parking spaces: ");
            try {
                parkingSpaces = scan.nextInt();
                if (parkingSpaces <= 0) {
                    System.out.println("\nThe number of parking spaces must be greater than zero. Please enter a valid value.");
                } else {
                    return parkingSpaces;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid value. Please enter a valid value.");
                scan.next();
            }
        } while (true);
    }
    // Ask the user for the floor number
    public static int requestFloorNumber() {
        int floorNumber;
        do {
            System.out.println("\nEnter the floor number: ");
            try {
                floorNumber = scan.nextInt();
                if (floorNumber <= 0) {
                    System.out.println("\nThe floor number must be greater than zero. Please enter a valid value.");
                } else {
                    return floorNumber;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid value. Please enter a valid value.");
                scan.next();
            }
        } while (true);
    }

    // Ask the user for the zone type
    public static String requestZoneType() {
        System.out.println("\nEnter the zone type: (e.g. residential, commercial)");
        return scan.next();
    }

    // Ask the user if they want to perform another simulation
    public static String requestContinueSimulation() {
        try {
            System.out.println("\nWould you like to perform another simulation? (yes/no)");
            return scan.next();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            scan.next(); // discard the invalid input
        }
        return scan.next();
    }
}


