package week2.homeworks.exercise1;

/*
5. Display all the prime numbers lower than a given number, read the number from keyboard
 */

public class DisplayThePrime {

    public static void main(String[] args) {

        int number = 225; //change the value of number for testing.

        displayThePrime(number);
    }

    public static void displayThePrime(int number) {
        System.out.println("____________________________________________________________");



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
