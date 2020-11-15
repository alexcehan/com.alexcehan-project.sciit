package week1.homeworks;

import java.util.Scanner;

/*
4. Check if a number is palindrom ( e.g palindrom 1221, 34143), read the number from keyboard.
 */

public class CheckIfPalindrom {

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

        int checkNumber = 0;
        int initialNumber = number;

        while (number != 0) {
            checkNumber = (checkNumber * 10 + (number % 10));
            number /= 10;

        }

        if (initialNumber == checkNumber) {
            System.out.println("The number is a palindrome!");
        } else {
            System.out.println("The number is not a palindrome!");
        }

        System.out.println("____________________________________________________________");
    }
}
