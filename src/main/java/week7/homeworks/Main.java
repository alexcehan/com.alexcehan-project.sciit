package week7.homeworks;

import java.util.*;

public class Main {
    @SuppressWarnings("unchecked")

    public static void main(String[] args) {


        Set<Person> personSet = new TreeSet<>(new PersonComparatorByNameAndAge());

        Person person1 = new Person("Alex", 30);
        Person person2 = new Person("Alex", 21);
        Person person3 = new Person("Vlad", 30);
        Person person4 = new Person("Alex", 30);

        personSet.add(person1);
        personSet.add(person2);
        personSet.add(person3);
        personSet.add(person4);

        for (Person person : personSet) {
            System.out.println(person);
        }

        //Sfarsitul exercitiului 1
        System.out.println("_____________________________________________________________________________");
        System.out.println();

        HashMap<Person, List<Hobby>> personListHashMap = new HashMap<>();






        if (!personListHashMap.containsKey(person1)) {
            personListHashMap.put(person1, new ArrayList<Hobby>());
            personListHashMap.get(person1).add(new Hobby("Rock Climbing", 4, "Italia", "Germania"));
        }


        if (!personListHashMap.containsKey(person2)) {
            personListHashMap.put(person2, new ArrayList<Hobby>());
            personListHashMap.get(person2).add(new Hobby("Rock Climbing", 4, "Italia", "Germania"));
        }

        if (!personListHashMap.containsKey(person3)) {
            personListHashMap.put(person3, new ArrayList<Hobby>());
            personListHashMap.get(person3).add(new Hobby("Sky Diving", 4, "Italia", "Germania", "Franta", "SUA"));
            personListHashMap.get(person3).add(new Hobby("Rock Climbing", 4, "Italia", "Germania"));
        }

        if (!personListHashMap.containsKey(person1)) {
            personListHashMap.put(person4, new ArrayList<Hobby>());
            personListHashMap.get(person4).add(new Hobby("Tennis", 3, "China"));
            personListHashMap.get(person4).add(new Hobby("Swim", 4, "Australia"));
        }







        Set set = personListHashMap.entrySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();

            System.out.println( mentry.getKey());
            ArrayList<Hobby> hobbyArrayList = (ArrayList<Hobby>) mentry.getValue();
            for (Hobby hobby1 : hobbyArrayList) {
                System.out.println(hobby1);
            }

            System.out.println();


        }



    }




}
