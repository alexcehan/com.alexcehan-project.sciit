package week12.homework.smallApplication;


public class Human {
    private String firstName;
    private String lastName;
    private final int year;
    private final int month;
    private final int day;


    public Human(String firstName, String lastName, int day, int month, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYear() {
        return year;
    }



    public int getDay() {
        return day;
    }



    public int getMonth() {
        return month;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + day + " " + month + " " + year;
    }
}
