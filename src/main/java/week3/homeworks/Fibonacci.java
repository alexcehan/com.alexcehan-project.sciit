package week3.homeworks;

/*
2. Write a Java method to print the first 25 terms of the Fibonacci series (without recursion).
 */

public class Fibonacci {

    public static void main(String[] args) {
        printFibonacci(25);

    }

    public static void printFibonacci(long number) {
        for (long i=0, j=0, k=1; i<number; i++) {
            System.out.println(j);
            System.out.println(k);

            j = j+k;
            k = j+k;
        }
    }
}
