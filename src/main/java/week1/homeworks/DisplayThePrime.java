package week1.homeworks;

import java.util.Scanner;

/*
5. Display all the prime numbers lower than a given number, read the number from keyboard
 */

public class DisplayThePrime {

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

        System.out.println("The prime numbers smaller than the givin number are: ");
        for(int i = number - 1; i != 1; i--) {
            if(isPrime(i)) {
                System.out.println(i);
            }
        }




        System.out.println("____________________________________________________________");
    }

    public static boolean isPrime(int number) {
        for(int i = 2; i < (number / 2 + 1); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
