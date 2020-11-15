package week2.homeworks;

import java.util.Scanner;

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
