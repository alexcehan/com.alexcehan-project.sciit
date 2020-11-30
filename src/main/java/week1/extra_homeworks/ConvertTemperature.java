package week1.extra_homeworks;

import java.util.Scanner;

/*
1. Write a Java program to convert temperature from Fahrenheit to Celsius degree.
Test Data
Input a degree in Fahrenheit: 212
Expected Output:
212.0 degree Fahrenheit is equal to 100.0 in Celsius
 */

public class ConvertTemperature {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double temperature = 0.0;

        System.out.println("Enter the value in Fahrenheit to convert");

        boolean flag = true;

        while(flag) {
            if(scanner.hasNextDouble()) {
                temperature = scanner.nextDouble();
                flag = false;
            } else {
                scanner.nextLine();
                System.out.println("Please enter a valid value!");
            }
        }

        System.out.println(temperature + " degree Fahrenheit is equal to " + ((temperature - 32)/1.8) + " in Celsius");
    }
}
