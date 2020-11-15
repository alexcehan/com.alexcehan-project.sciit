package week2.homeworks;

import java.util.Scanner;

/*
2. Write a Java program that reads a number in inches, converts it to meters.
Note: One inch is 0.0254 meter.
Test Data
Input a value for inch: 1000
Expected Output :
1000.0 inch is 25.4 meters
 */

public class ConvertInches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double inches = 0.0;

        System.out.println("Enter the value in inches: ");

        boolean flag = true;

        while(flag) {
            if(scanner.hasNextDouble()) {
                inches = scanner.nextDouble();
                flag = false;
            } else {
                scanner.nextLine();
                System.out.println("Please enter a valid value!");
            }


        }
        System.out.println(inches + " inch is " + (inches * 0.0254) + " meter.");
    }
}
