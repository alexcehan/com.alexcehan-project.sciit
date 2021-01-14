package week7.homeworks;

import java.util.Comparator;

public class PersonComparatorByNameAndAge  implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {

        if (o1.getName().equals(o2.getName())) {
            if (o1.getAge() > o2.getAge()) {
                return -1;
            }

            if (o1.getAge() < o2.getAge()) {
                return 1;
            }

        } else{
            return (o1.getName().compareTo(o2.getName()));
        }

        return 0;

    }


}
