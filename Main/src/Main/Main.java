/*
INICIO DO CÓDIGO - SISTEMA DE FINANCIAMENTO PUCPR
CRIADO EM: 21/05/24
FEITO POR: João Meneses
DISCIPLINA: Fundamentos da Programação Orientada a Objetos
DESCRIÇÃO: Sistema de Simulação de Financiamentos Imobiliários
Turma: 22
ÚLTIMA ATUALIZAÇÃO: 02/07/24

OBS: Decidi fazer em inglês para treinar a escrita e leitura da língua.


FINALIZAÇÃO DO CÓDIGO EM:

*/

package Main;

import Model.Apartment;
import Model.Financing;
import Model.House;
import Model.Land;
import Util.SaveAndLoadFinancingData;
import Util.SerializeFinancingList;
import Util.UserInterface;
import java.util.ArrayList;

import static Util.SaveAndLoadFinancingData.loadAndDisplayFinancingData;


public class Main {
    public static void main(String[] args) {


        UserInterface.welcomeMessage();

        loadAndDisplayFinancingData();

        ArrayList<Financing> financingList = new ArrayList<>();

        double totalPropertyValue = 0;
        double totalFinancingValue = 0;
        int choice;

        // Loop to simulate multiple financings
        do {
            choice = UserInterface.requestPropertyType();

            if (choice >= 1 && choice <= 3) {

                // Requesting the property value, annual interest rate and financing term from the user for one financing
                double propertyValue = UserInterface.requestPropertyValue();
                double annualInterestRate = UserInterface.requestAnnualInterestRate();
                int financingTerm = UserInterface.requestFinancingTerm();

                // Creating a new financing object based on the user's choice
                if (choice == 1) {
                    String builtUpArea = UserInterface.requestBuiltUpArea();
                    String landLength = UserInterface.requestLandLength();
                    financingList.add(new House(propertyValue, annualInterestRate, financingTerm, builtUpArea, landLength));
                }

                if (choice == 2) {
                    int parkingSpaces = UserInterface.requestParkingSpaces();
                    int floorNumber = UserInterface.requestFloorNumber();
                    financingList.add(new Apartment(propertyValue, annualInterestRate, financingTerm, parkingSpaces, floorNumber));
                }

                if (choice == 3) {
                    String zoneType = UserInterface.requestZoneType();
                    financingList.add(new Land(propertyValue, annualInterestRate, financingTerm, zoneType));
                }

                // Adding the property value and the total payment to the totals
                totalPropertyValue += propertyValue;
                totalFinancingValue += financingList.get(financingList.size() - 1).totalPayment();

                // Displaying the financing data for the current financing
                Financing fin = financingList.get(financingList.size() - 1);
                System.out.println("\nType: " + fin.getType());
                fin.showSpecificAttributes();
                fin.showAllFinancingData();

                // Asking the user if they want to continue simulating
                String continueSimulation = UserInterface.requestContinueSimulation();
                if (continueSimulation.equalsIgnoreCase("no")) {
                    break;
                }
            }
        } while (choice != 4);

        // Displaying the total values of all the simulated financings
        System.out.println("\nTotal of all properties simulated: R$ " + String.format("%.2f", totalPropertyValue));
        System.out.println("Total of all financing simulated: R$ " + String.format("%.2f", totalFinancingValue));


        // Saving the financing data to a file
        SaveAndLoadFinancingData.saveFinancingData(financingList);
        System.out.println("\nFinancing data saved successfully.");

        // Serializing the financing list
        SerializeFinancingList.serializeFinancingList(financingList);

        UserInterface.goodbyeMessage();
    }
}