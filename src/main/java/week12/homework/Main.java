package week12.homework;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // 1. Write a method that can generate the first 100 numbers from Fibonacci series using Java 8 streams which returns the sequence as an array of int(BigInteger can fit all 100 Fobonacci numbers).
        // Am facut de 2 ori exercitiul asta. o data cu un List return, si odata cu void return si direct printate primele 100 de numere din sir.
        LinkedList<BigInteger> list = fibonacciReturn();
        fibonacciPrint();

    }

    public static LinkedList<BigInteger> fibonacciReturn() {
        LinkedList<BigInteger> bigIntegerList;

        bigIntegerList = Stream.iterate(new BigInteger[] {new BigInteger("0"), new BigInteger("1")}, s -> new BigInteger[] {s[1], s[0].add(s[1])})
                .limit(100)
                .map(s -> s[0])
                .collect(Collectors.toCollection(LinkedList::new));

        return bigIntegerList;

    }

    public  static void fibonacciPrint() {
        Stream.iterate(new BigInteger[] {new BigInteger("0"), new BigInteger("1")}, s -> new BigInteger[] {s[1], s[0].add(s[1])})
                .limit(100)
                .map(s -> s[0])
                .forEach(System.out::println);
    }


}
