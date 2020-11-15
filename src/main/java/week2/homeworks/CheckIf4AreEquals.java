package week2.homeworks;

import java.util.Scanner;

/*
3. Write a Java program that accepts four integer from the user and prints equal if all four are equal, and not equal otherwise.

Sample Output:
Input first number: 25
Input second number: 37
Input third number: 45
Input fourth number: 23
Numbers are not equal!
 */

public class CheckIf4AreEquals {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] array = new int[4];



        int i = 0;

        while(i < 4) {

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

        if ((array[0] == array[1]) && (array[2] == array[3]) && (array[1] == array[2])) {
            System.out.println("The numbers are equal!");
        } else {
            System.out.println("The numbers are not equal!");
        }
    }
}
