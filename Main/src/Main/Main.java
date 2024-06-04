/*
INICIO DO CÓDIGO - SISTEMA DE FINANCIMANETO PUC
CRIADO EM: 21/05/24
FEITO POR: João Meneses
DISCIPLINA: Fundamentos da Programação Orientada a Objetos
DESCRIÇÃO: Sistema de Simulação de Financiamentos Imobiliários
Turma: 22
ÚLTIMA ATUALIZAÇÃO: 04/06/24

OBS: Decidi fazer em inglês para treinar a escrita e leitura da língua.


FINALIZAÇÃO DO CÓDIGO EM:

 */

// ==== Main class of the program. It contains the main method, where the main flow of the program is implemented. ==== //

package Main;

import Model.Financing;
import Util.UserInterface;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        UserInterface.welcomeMessage();
        ArrayList<Financing> financingsList = new ArrayList<>();

        double totalPropertyValue = 0;
        double totalFinancingValue = 0;

        for (int i = 0; i < 4; i++) {
            // Requesting the property value, annual interest rate and financing term
            double propertyValue = UserInterface.requestPropertyValue();
            double annualInterestRate = UserInterface.requestAnnualInterestRate();
            int financingTerm = UserInterface.requestFinancingTerm();

            // Creating a new financing object and adding it to the list
            Financing financing = new Financing(propertyValue, annualInterestRate, financingTerm);
            financingsList.add(financing);

            // Adding the property value and the total payment to the totals
            totalPropertyValue += propertyValue;
            totalFinancingValue += financing.totalPayment();
        }

        // Displaying the financing data for each financing
        for (Financing financing : financingsList) {
            financing.showAllFinancingData();
        }

        System.out.println("==== Beside you can see the data of the four properties you entered. ====\n");
        System.out.println("\nTotal of all properties: R$ " + String.format("%.2f", totalPropertyValue));
        System.out.println("Total of all financings: R$ " + String.format("%.2f", totalFinancingValue));

        UserInterface.goodbyeMessage();
    }
}