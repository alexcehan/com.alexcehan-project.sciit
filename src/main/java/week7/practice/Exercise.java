package week7.practice;

import week7.homeworks.Person;

public class Exercise {
    public static void main(String[] args) {
        String str1 = "Alex";
        String str2 = "Vlad";
        Person person1 = new Person("Alex",30);
        Person person2 = new Person("Alex", 21);

        System.out.println(person1.equals(person2));

        System.out.println(str2.compareTo(str1));
    }
}
