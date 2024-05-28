package Util;

import java.util.InputMismatchException;
import java.util.Scanner;

// ==== Class responsible for the user interface of the program. It contains methods that display messages to the user and request input from the user. ==== //
public class UserInterface {

    static Scanner scan = new Scanner(System.in);

    // Methods
    public static void welcomeMessage() {
        System.out.println("\n ==== Welcome to the Real Estate Model.Financing System! ==== ");
    }

    public static void goodbyeMessage() {
        System.out.println("\nThank you for using the Real Estate Model.Financing System!");
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
            System.out.println("\nEnter the financing term (in years): \n");
            try {
                financingTerm = scan.nextInt();
                if (financingTerm <= 0) {
                    System.out.println("\nThe financing term must be greater than zero. Please enter a valid value.");
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
}

