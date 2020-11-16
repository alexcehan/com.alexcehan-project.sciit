package week3.practice;

public class Car {

    private int speed;
    private String name;
    private String color;
    public void accelerate() {

    }

    public void start() {

    }

    public void stop(){

    }


    public Car() {
    }

    public Car(int speed, String name, String color) {
        this.speed = speed;
        this.name = name;
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color.equals("red")) {
            return;
        }
        this.color = color;
    }
}
