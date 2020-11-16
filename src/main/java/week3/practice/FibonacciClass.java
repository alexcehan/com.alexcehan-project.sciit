package week3.practice;

public class FibonacciClass {

    public static void main(String[] args) {
        int n = fibonacci(4);
        System.out.println(n);
    }

    public static int fibonacci (int n) {

        System.out.println(n);
        if (n == 0 || n == 1) {
            return n;
        }


        return fibonacci(n-1) + fibonacci(n-2);
    }
}
