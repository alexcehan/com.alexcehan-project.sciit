package week4.practice;

public class Car extends Vehicle implements CarBehavior{

    @Override
    public void start() {
        System.out.println("vroom! vroom!");


    }

    @Override
    public void stop() {

    }

    public Car (int speed, int numberOfDoors, int numberOfWheels, double weight) {
        super.speed = speed;
        super.numberOfDoors = numberOfDoors;
        super.numberOfWheels = numberOfWheels;
        super.weight = weight;


    }



}
