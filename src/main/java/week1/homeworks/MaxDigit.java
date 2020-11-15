package week1.homeworks;

import java.util.Scanner;

/*
3. Display the max digit from a number, read the number from keyboard.
 */

public class MaxDigit {
    public static void main(String[] args) {


        System.out.println("____________________________________________________________");

        Scanner scanner = new Scanner(System.in);



        int number = 0;

        while(true) {
           System.out.println("Enter a number: ");
           if(scanner.hasNextInt()) {
               number = scanner.nextInt();
               break;
           } else {
               System.out.println("Please enter a valid integer");
               scanner.nextLine();
           }
        }


        scanner.nextLine();
        int maxDigit = 0;

        while (number != 0) {
            if ((number % 10) > maxDigit) {
                maxDigit = (number % 10);

            }
            number /= 10;
        }

        System.out.println("The maxi digit of the entered number is " + maxDigit);






        System.out.println("____________________________________________________________");
    }
}
