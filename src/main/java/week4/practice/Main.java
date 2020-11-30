package week4.practice;

public class Main {

    public static void main(String[] args) {

        Car dacia = new Car(180, 5, 4, 1.87);

        System.out.println(dacia.speed);

        if(dacia.speed > 150) {
            dacia.start();
        }

       int x = 23;

    }



}
