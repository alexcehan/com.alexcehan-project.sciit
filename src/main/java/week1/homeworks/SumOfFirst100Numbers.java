package week1.homeworks;

/*
1. Calculate the sum of the first 100 prime numbers.
 */


public class SumOfFirst100Numbers {
    public static void main(String[] args) {

        int sum = 0;
        for(int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("____________________________________________________________");
        System.out.println("\nThe sum of the first 100 numbers is: " + sum + "\n");
        System.out.println("____________________________________________________________");
    }
}
