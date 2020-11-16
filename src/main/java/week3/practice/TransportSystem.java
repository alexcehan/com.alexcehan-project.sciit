package week3.practice;

public class TransportSystem {

    public static void main(String[] args) {
        Car car = new Car();
        //System.out.println(car.color);
        //car.color = "red";
        //System.out.println(car.color);


        System.out.println(car.getColor());
        car.setColor("red");
        System.out.println(car.getColor());

        Car car2 = new Car(200, "buggy", "red" );

        System.out.println(car2.getColor());

        Audi audi = new Audi();
        audi.getColor();


    }
}
