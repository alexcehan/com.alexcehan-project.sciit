package week2.homeworks.exercise1;

/*
1. Calculate the sum of the first 100 prime numbers.
 */


public class SumOfFirst100PrimeNumbers {
    public static void main(String[] args) {

        int number = 100;

        displayTheSumOfSmallerPrimes(number); //change the value of number for testing
    }

    public static void displayTheSumOfSmallerPrimes(int number) {


        int sum = 0;
        int count = 0;
        for (int i = 2; count < number; i++) {
            if (isPrime(i)) {
                sum += i;
                count++;
            }
        }


        System.out.println("____________________________________________________________");
        System.out.println("\nThe sum of the first 100 prime numbers is: " + sum + "\n");
        System.out.println("____________________________________________________________");
    }


    //method created to check if a number is prime

    public static boolean isPrime(int number) {
        for (int i = 2; i < (number / 2 + 1); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
