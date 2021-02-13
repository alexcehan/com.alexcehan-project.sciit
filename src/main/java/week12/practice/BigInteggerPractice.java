package week12.practice;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BigInteggerPractice {

    public static void main(String[] args) {

        List<BigInteger> bigIntegerList;

        bigIntegerList = Stream.iterate(new BigInteger[] {new BigInteger("0"), new BigInteger("1")}, s -> new BigInteger[] {s[1], s[0].add(s[1])})
                .limit(100)
                .map(s -> s[0])
                .collect(Collectors.toCollection(LinkedList::new));



        for (BigInteger big : bigIntegerList) {
            System.out.println(big);
        }

        bigIntegerList.forEach(s -> System.out.println(s));


    }
}
