/*
INICIO DO CÓDIGO - SISTEMA DE FINANCIMANETO PUC
CRIADO EM: 21/05/24
FEITO POR: João Meneses
DISCIPLINA: Fundamentos da Programação Orientada a Objetos
DESCRIÇÃO: Sistema de Simulação de Financiamentos Imobiliários
Turma: 22
ÚLTIMA ATUALIZAÇÃO: 27/05/24

FINALIZAÇÃO DO CÓDIGO EM:

 */

// ==== Main class of the program. It contains the main method, where the main flow of the program is implemented. ==== //

package Main;

import Model.Financing;
import Util.UserInterface;

public class Main {
    public static void main(String[] args) {
        UserInterface.welcomeMessage();

        // Requesting the property value, annual interest rate and financing term
        double propertyValue = UserInterface.requestPropertyValue();
        double annualInterestRate = UserInterface.requestAnnualInterestRate();
        int financingTerm = UserInterface.requestFinancingTerm();

        // Creating a new financing object and displaying the monthly and total payment
        Financing financing = new Financing(propertyValue, annualInterestRate, financingTerm);
        financing.showAllFinancingData();
        UserInterface.goodbyeMessage();
    }

}