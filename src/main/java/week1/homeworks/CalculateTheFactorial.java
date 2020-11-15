package week1.homeworks;

import java.util.Scanner;

/*
8. Calculate and display the factorial of a given number n. (ex: 4! = 1*2*3*4)

Am impus introducerea unui numar mai mic sau egal cu 20 pentru ca daca am inteles corect
20 e cel mai mare numar a carui factorial poate fi incadrat in Long.MAX_VALUE
 */



public class CalculateTheFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean flag = true;
        while(flag) {
            long number = 0L;
            long factorialNumber = 1L;

            System.out.println("Please enter a valid positive number between 1 and 20: ");
            if(scanner.hasNextLong()) {
                number = scanner.nextLong();
                if ((number < 1) || (number >20)) {
                    continue;
                }
            } else {
                scanner.nextLine();
                continue;
            }

            for (long i = number; i > 0; i--) {
                factorialNumber *=i;
            }

            System.out.println("The factorial of " + number + " is " + factorialNumber);
            flag = false;
        }
    }
}
