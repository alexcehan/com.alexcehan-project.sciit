package week2.homeworks;

/*
8. Calculate and display the factorial of a given number n. (ex: 4! = 1*2*3*4)

Am impus introducerea unui numar mai mic sau egal cu 20 pentru ca daca am inteles corect
20 e cel mai mare numar a carui factorial poate fi incadrat in Long.MAX_VALUE
 */


public class CalculateTheFactorial {




    public static void main(String[] args) {

        int number = 20;
        returnFactorial(number);

    }

    public static void returnFactorial(long number) {
        boolean flag = true;
        while(flag) {

            long factorialNumber = 1L;

            for (long i = number; i > 0; i--) {
                factorialNumber *=i;
            }

            System.out.println("The factorial of " + number + " is " + factorialNumber);
            flag = false;
        }
    }
}
