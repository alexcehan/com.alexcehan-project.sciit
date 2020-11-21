package week3.practice.inheritance;

public class PlayWithShapes {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Shape circleShape = new Circle();
        Shape rectangleShape = new Rectangle();
        Shape triagleShape = new Triangle();



        System.out.println(circle.getColor());
        circle.draw();
    }
}
