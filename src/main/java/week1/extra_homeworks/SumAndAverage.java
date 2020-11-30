package week1.extra_homeworks;

import java.util.Scanner;

/*
5. Write a program in Java to input 5 numbers from keyboard and find their sum and average.

Test Data
Input the 5 numbers : 1 2 3 4 5
Expected Output :

Input the 5 numbers :
1
2
3
4
5
The sum of 5 no is : 15
The Average is : 3.0
 */

public class SumAndAverage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[5];



        int i = 0;

        while(i < 5) {

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

        System.out.println("The sum of 5 no is: " + sum);
        System.out.println("The Average is: " + average);
    }
}
