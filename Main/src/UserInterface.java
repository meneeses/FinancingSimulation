import java.util.Scanner;

// ==== Class responsible for the user interface of the program. It contains methods that display messages to the user and request input from the user. ==== //
public class UserInterface {
    public static double propertyValue;
    public static double annualInterestRate;
    public static int financingTerm;
    static Scanner scan = new Scanner(System.in);

    public static void welcomeMessage() {
        System.out.println(" ==== Welcome to the Real Estate Financing System! ==== \n");
    }

    public static void goodbyeMessage() {
        System.out.println("\nThank you for using the Real Estate Financing System!");
    }

    public static void requestPropertyValue() {
        System.out.println("Enter the property value: ");
        propertyValue = scan.nextDouble();
    }

    public static void requestFinancingTerm() {
        System.out.println("Enter the financing term (in years): ");
        financingTerm = scan.nextInt();
    }

    public static void requestAnnualInterestRate() {
        System.out.println("Enter the annual interest rate: ");
        annualInterestRate = scan.nextDouble();
    }
}
