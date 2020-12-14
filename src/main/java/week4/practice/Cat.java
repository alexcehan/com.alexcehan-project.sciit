package week4.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class Cat {
    String name;

    public Cat(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

        ArrayList<Cat> cats = new ArrayList<>();

        Cat thomas = new Cat("Thomas");
        Cat behemoth = new Cat("Behemoth");
        Cat lionel = new Cat("Lionel Messi");
        Cat fluffy = new Cat ("Fluffy");

        cats.add(thomas);
        cats.add(behemoth);
        cats.add(lionel);
        cats.add(fluffy);

        Cat[] catsArray = cats.toArray(new Cat[0]);

        System.out.println(Arrays.toString(catsArray));
    }
}
