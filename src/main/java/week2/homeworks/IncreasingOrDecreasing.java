package week2.homeworks;

import java.util.Scanner;

/*
6. Write a program that accepts three numbers from the user and prints "increasing" if the numbers are in increasing order,
 "decreasing" if the numbers are in decreasing order, and "Neither increasing or decreasing order" otherwise.

Test Data
Input first number: 1524
Input second number: 2345
Input third number: 3321
Expected Output :

Increasing order
 */

public class IncreasingOrDecreasing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = new int[3];
        int i = 0;

        while(i < 3) {
            System.out.println("Enter value: ");
            if(scanner.hasNextInt()) {
                array[i] = scanner.nextInt();
                scanner.nextLine();
                i++;
            } else {
                scanner.nextLine();
                System.out.println("Please enter a valid value!");
            }
        }


        if((array[0] < array[1]) && (array[1] < array[2])) {
            System.out.println("increasing order");
        } else if ((array[0] > array[1]) && (array[1] > array[2])) {
            System.out.println("Decreasing order");
        } else {
            System.out.println("Neither increasing or decreasing order");
        }
    }
}
