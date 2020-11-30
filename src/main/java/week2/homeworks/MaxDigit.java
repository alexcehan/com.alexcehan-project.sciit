package week2.homeworks;

/*
3. Display the max digit from a number, read the number from keyboard.
 */

public class MaxDigit {
    public static void main(String[] args) {

        int number = 54534674; //change the value of number for testing.
        displayTheMaxDigit(number);
    }

    public static void displayTheMaxDigit(int number) {
        System.out.println("____________________________________________________________");

        int maxDigit = 0;

        while (number != 0) {
            if ((number % 10) > maxDigit) {
                maxDigit = (number % 10);

            }
            number /= 10;
        }

        System.out.println("The maxi digit of the entered number is " + maxDigit);


        System.out.println("____________________________________________________________");
    }
}
