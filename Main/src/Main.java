/*
INICIO DO CÓDIGO - SISTEMA PUC
CRIADO EM: 21/05/24
FEITO POR: João Meneses
DISCIPLINA: Fundamentos da Programação Orientada a Objetos
DESCRIÇÃO: Sistema de Simulação de Financiamentos Imobiliários
Turma: 01
ÚLTIMA ATUALIZAÇÃO: 30/04/24

FINALIZAÇÃO DO CÓDIGO EM:

 */

// ==== Main class of the program. It contains the main method, where the main flow of the program is implemented. ==== //

public class Main {
    public static void main(String[] args) {
        UserInterface.welcomeMessage();
        UserInterface.requestPropertyValue();
        UserInterface.requestAnnualInterestRate();
        UserInterface.requestFinancingTerm();
        Financing financing = new Financing(UserInterface.propertyValue, UserInterface.annualInterestRate, UserInterface.financingTerm);
        System.out.println("Monthly payment: " + financing.monthlyPayment());
        System.out.println("Total payment: " + financing.totalPayment());
        UserInterface.goodbyeMessage();
    }

}