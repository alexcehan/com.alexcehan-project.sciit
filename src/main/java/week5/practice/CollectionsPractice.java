package week5.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionsPractice {
    public static void main(String[] args) {
        Set<String> someHashSet = new HashSet<>();
        someHashSet.add("Alex");
        someHashSet.add("Irina");
        someHashSet.add("Alex");


        for (String name: someHashSet) {
            System.out.println(name);
        }

        System.out.println(someHashSet.remove("Gheorghe"));
        System.out.println(someHashSet.remove("Gheorghe"));
        System.out.println(someHashSet.remove("Alex"));

        List<Integer> integerList = new ArrayList<>();
    }
}
