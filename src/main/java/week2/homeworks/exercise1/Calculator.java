package week2.homeworks.exercise1;

import java.util.Scanner;

/*
6. Change the implementation of the calculator from the previous meeting to use only if-else instead of switch.
 */

public class Calculator {

    public static void main(String[] args) {




        useCalculator();
    }

    public static void useCalculator() {
        Scanner scanner = new Scanner(System.in);
        boolean calculatorFlag = true;

        while (calculatorFlag) {
            System.out.println("Enter the value of the first integer: ");
            int a = scanner.nextInt();
            System.out.println("Enter the value of the second integer: ");
            int b = scanner.nextInt();
            scanner.nextLine();

            boolean flag = true;
            String[] operators = {"+", "-", "*", "/"};

            System.out.println("What operation do you want to perform? (+, -, *, /): ");
            String operation = "";
            while(flag) {
                System.out.println("Please enter a valid operator: ");
                //flag = false;
                operation = scanner.nextLine();
                for (String operator:operators) {
                    if(operation.equals(operator)) {
                        flag = false;
                        break;
                    }
                }

            }


            if (operation.equals("+")) {
                System.out.println(a + " + " + b + " = " + (a + b));
            } else if (operation.equals("-")) {
                System.out.println(a + " - " + b + " = " + (a - b));
            } else if (operation.equals("*")) {
                System.out.println(a + " * " + b + " = " + (a * b));
            } else {
                System.out.println(a + " / " + b + " = " + (1.0* a / b));
            }


            System.out.println("Do you want to perform another calculation?(y/n): ");
            String checkIfCalculatorStop = scanner.next();
            if (checkIfCalculatorStop.equals("n")) {
                calculatorFlag = false;
            }



        }
    }
}
