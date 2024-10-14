package org.example;

import java.lang.runtime.SwitchBootstraps;
import java.util.Scanner;

public class Calculator {

    Scanner scanner = new Scanner(System.in);
    public void start () {
        System.out.println("Insert the first number");
        double num1 = scanner.nextDouble();
        System. out.println("Insert the second number");
        double num2 = scanner.nextDouble();
        System. out.println("Select an option: + - x /: ");
        String option = scanner.next();
        double result;
        switch (option) {
            case "+":
                result = add(num1, num2);
                break;
            case "-":
                result = subtract(num1, num2);
                break;
            case "x":
                result = multiply(num1,num2);
                break;
            case "/":
                if(num2 != 0){
                    result = divide(num1, num2);
                }else{
                    throw new ArithmeticException("División por cero.");
                }
                break;
            default:
                throw new IllegalArgumentException("Operator not valid");
        }
        System.out.println("The result is: "+result);
    }

    public double add (double num1, double num2){
       return num1 + num2;
    }

    public double subtract (double num1, double num2){
        return num1 - num2;
    }

    public double multiply (double num1, double num2){
        return num1 * num2;
    }

    public double divide (double num1, double num2){
        return num1 / num2;
    }
}
