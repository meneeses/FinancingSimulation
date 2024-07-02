package Util;

import Model.Apartment;
import Model.Financing;
import Model.House;
import Model.Land;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveAndLoadFinancingData {

    // Save the financing data to a file
    public static void saveFinancingData(ArrayList<Financing> financingList) {
        SerializeFinancingList.serializeFinancingList(financingList);
    }

    // Verify if the file exists
    public static boolean verifyFile() {
        File file = new File("src/Data/financingData.ser");
        return file.exists();
    }

    // Load the financing data from a file
    public static void loadAndDisplayFinancingData() {
        if (!verifyFile()) {
            System.out.println("\nThe file does not exist.");
            return;
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("\nDo you want to view previous financings? (yes/no)");
        String response = scan.nextLine();

        if (response.equalsIgnoreCase("yes")) {
            System.out.println("\nHere's the previous financing data:");
            ArrayList<Financing> financingList = SerializeFinancingList.deserializeFinancingList();

            if (financingList != null && !financingList.isEmpty()) {
                for (Financing fin : financingList) {
                    System.out.println("\nType: " + fin.getClass().getSimpleName());
                    System.out.println("Property Value: R$" + fin.getPropertyValue());
                    System.out.println("Annual Interest Rate: " + fin.getAnnualInterestRate() + "%");
                    System.out.println("Financing Term: " + fin.getFinancingTerm());

                    if (fin instanceof House) {
                        House house = (House) fin;
                        System.out.println("Built-up Area: " + house.getBuiltUpArea() + "m²");
                        System.out.println("Land Length: " + house.getLandLength() + "m²");
                    } else if (fin instanceof Apartment) {
                        Apartment apartment = (Apartment) fin;
                        System.out.println("Parking Spaces: " + apartment.getParkingSpaces());
                        System.out.println("Floor Number: " + apartment.getFloorNumber() + "°");
                    } else if (fin instanceof Land) {
                        Land land = (Land) fin;
                        System.out.println("Zone Type: " + land.getZoneType());
                    }
                    System.out.println("-----------------------------------");
                }
            } else {
                System.out.println("\nNo previous financing data found.");
            }
        }
    }
}