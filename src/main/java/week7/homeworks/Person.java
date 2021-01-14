package week7.homeworks;

public class Person  {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;

    }

//    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//
//
//
//
//    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + age;
    }

    @Override
    public boolean equals(Object obj) {
        Person per = (Person) obj;

        if (this.name.equals(per.name) && this.age == per.age) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public String toString() {
        return (this.name + " - age: " + this.age);
    }


}
