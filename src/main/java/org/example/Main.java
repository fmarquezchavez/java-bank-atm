package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String accountNumber = "12345678";
        double balance =  1500.50;
        String pin = "1234";
        String status = "";
        ArrayList<String> transactionHistory = new ArrayList<>();
        balance = deposit(balance, 500, transactionHistory );
        balance = withdraw(balance, 5000, transactionHistory);
        status = (balance > 0 )? "Credit" : "Debt" ;
        System.out.println("User status:" + status);
        authenticateUser("1234",pin);
        System.out.println("Balance: $"+ balance);
        System.out.println("History transactions: ");
        transactionHistory.forEach(transaction -> System.out.println("*" + transaction));
        ATM atm = new ATM();
        atm.start();
    }

    public static  boolean authenticateUser (String inputPin, String currentPin){
        int attempts = 0;
        while (attempts <3) {
            if (currentPin.equals(inputPin)){
                System.out.println("Authenticated user");
                return true;
            }else{
                attempts ++;
                System.out.println("Failed attemp");
            }
        }
        return false;
    }

    public static double deposit (double balance, double deposit, ArrayList<String> transactionHistory){
        balance += deposit;
        transactionHistory.add("Amount added: $"+deposit);
        return balance;
    }

    public static double withdraw (double balance, double withdraw, ArrayList<String>transactionHistory){
        if(balance>=withdraw){
            balance-=withdraw;
            transactionHistory.add("Amount withdrawed: $"+ withdraw);
        }else{
            transactionHistory.add("Failed withdraw, insufficient balance: $"+balance + " to withdraw $" +withdraw);
        }
        return balance;
    }
}


