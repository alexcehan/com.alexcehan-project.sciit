package week2.homeworks;

import java.util.Scanner;

/*
7. Write a Java program to calculate the average value of array elements.
 */

public class AverageValueInArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many integers do you want to add to the array? ");

        int lengthOfArray = scanner.nextInt();
        int[] array = new int[lengthOfArray];



        int i = 0;

        while(i < lengthOfArray) {

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

        int sum = 0;

        for (i=0; i< array.length; i++) {
            sum += array[i];
        }

        double average = (1.0 * sum / array.length);

        System.out.println("The average value of the array elements is: " + average);
    }
}
