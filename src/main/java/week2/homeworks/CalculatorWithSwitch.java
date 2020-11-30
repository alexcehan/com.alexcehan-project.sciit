package week2.homeworks;

import java.util.Scanner;

/*
7. Change the implementation of the calculator
from the previous meeting to not stop after one calculation. (Hint: put switch inside a while loop)
 */

public class CalculatorWithSwitch {

    public static void main(String[] args) {
        useCalculatorWithSwitch();
    }

    public static void useCalculatorWithSwitch() {
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


            switch (operation) {
                case "+":
                    System.out.println(a + " + " + b + " = " + (a + b));
                    break;
                case "-":
                    System.out.println(a + " - " + b + " = " + (a - b));
                    break;
                case "*":
                    System.out.println(a + " * " + b + " = " + (a * b));
                    break;
                default:
                    System.out.println(a + " / " + b + " = " + (1.0* a / b));
                    break;
            }




            System.out.println("Do you want to perform another calculation?(y/n): ");
            String checkIfCalculatorStop = scanner.next();
            if (checkIfCalculatorStop.equals("n")) {
                calculatorFlag = false;
            }



        }
    }
}
