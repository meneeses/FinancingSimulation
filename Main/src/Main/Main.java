/*
INICIO DO CÓDIGO - SISTEMA DE FINANCIAMENTO PUC
CRIADO EM: 21/05/24
FEITO POR: João Meneses
DISCIPLINA: Fundamentos da Programação Orientada a Objetos
DESCRIÇÃO: Sistema de Simulação de Financiamentos Imobiliários
Turma: 22
ÚLTIMA ATUALIZAÇÃO: 11/06/24

OBS: Decidi fazer em inglês para treinar a escrita e leitura da língua.


FINALIZAÇÃO DO CÓDIGO EM:

*/

package Main;

import Model.Apartment;
import Model.Financing;
import Model.House;
import Model.Land;
import Util.UserInterface;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        UserInterface.welcomeMessage();
        ArrayList<Financing> financingList = new ArrayList<>();

        double totalPropertyValue = 0;
        double totalFinancingValue = 0;

        // Requesting the property value, annual interest rate and financing term from the user for one financing
        double propertyValue = UserInterface.requestPropertyValue();
        double annualInterestRate = UserInterface.requestAnnualInterestRate();
        int financingTerm = UserInterface.requestFinancingTerm();

        // Creating a new financing object and adding it to the list
        Financing financing = new Financing(propertyValue, annualInterestRate, financingTerm);
        financingList.add(financing);

        // Adding the property value and the total payment to the totals
        totalPropertyValue += propertyValue;
        totalFinancingValue += financing.totalPayment();

        // Creating and adding the other financings with data provided directly in the code
        financingList.add(new House(200000, 10, 15));
        financingList.add(new House(300000, 4, 20));
        financingList.add(new Apartment(150000, 6, 25));
        financingList.add(new Apartment(250000, 9, 30));
        financingList.add(new Land(100000, 5, 10));

        // Adding the property values and the total payments of the other financing to the totals
        for (int i = 1; i < financingList.size(); i++) {
            totalPropertyValue += financingList.get(i).getPropertyValue();
            totalFinancingValue += financingList.get(i).totalPayment();
        }

        // Displaying the financing data for each financing
        for (Financing fin : financingList) {
            System.out.println("\n\nType: " + fin.getType());
            fin.showAllFinancingData();
        }

        System.out.println("\nTotal of all properties: R$ " + String.format("%.2f", totalPropertyValue));
        System.out.println("Total of all financing: R$ " + String.format("%.2f", totalFinancingValue));

        UserInterface.goodbyeMessage();
    }
}