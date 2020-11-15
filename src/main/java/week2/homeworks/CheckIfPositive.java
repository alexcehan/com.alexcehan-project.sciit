package week2.homeworks;

import java.util.Scanner;

/*
4. Write a Java program to get a number from the user and print whether it is positive or negative.

Test Data
Input number: 35
Expected Output :
Number is positive
 */

public class CheckIfPositive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;

        System.out.println("Enter a valid number: ");

        boolean flag = true;

        while (flag) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                flag = false;
            } else {
                scanner.nextLine();
                System.out.println("Please enter a valid value!");
            }
        }
        if (number >= 0) {
            System.out.println("Number is positive");
        } else {
            System.out.println("Number is negative");
        }
    }
}
