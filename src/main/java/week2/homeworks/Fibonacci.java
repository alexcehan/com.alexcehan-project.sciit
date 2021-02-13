package week2.homeworks;

/*
2. Write a Java method to print the first 25 terms of the Fibonacci series (without recursion).
 */

import java.math.BigInteger;

public class Fibonacci {

    public static void main(String[] args) {
        printFibonacci(10000);

    }

    public static void printFibonacci(long number) {
        BigInteger j = new BigInteger("0");
        BigInteger k = new BigInteger("1");
        for (int i=0; i<number; i++) {
            System.out.println(j);
            System.out.println(k);

            j = j.add(k);
            k = k.add(j);
        }
    }
}
