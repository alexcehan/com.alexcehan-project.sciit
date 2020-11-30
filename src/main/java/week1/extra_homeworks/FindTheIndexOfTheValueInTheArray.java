package week1.extra_homeworks;

import java.util.Scanner;

/*
9. Write a Java program to find the index of an array element.
Deoarece enuntul problemei seamana destul de mult cu cel de la problema 8, am folosit in cea mai mare parte codul
de acolo.
 */

public class FindTheIndexOfTheValueInTheArray {

    public static void main(String[] args) {

        //Deoarece si enuntul problemei era destul de vag, am creat in main() un array random fara sa il mai fac din imputul userului
        int[] array = {12, 32, 54, 65, 76, 465, 3245, 2324, 1244, 43, 341, 143, 17, 5, 198, 17};

        Scanner scanner = new Scanner(System.in);
        int number = 0;

        System.out.println("Enter the value you want to check if is in the array: ");

        boolean flag = true;

        while (flag) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                flag = false;
            } else {
                scanner.nextLine();
                System.out.println("Please enter a valid value!");
            }
        }

        //am folosit si aici metoda checkValue() si am adaugat si acest IF pentru a acoperi situatiile ipotetice
        //in care valoarea verifica nu exista deloc in array SAU exista de mai multe ori.

        if (checkValue(number, array)) {
            for(int i = 0; i < array.length; i++) {
                if (number == array[i]) {
                    System.out.println("The index of the value " + number + " in the array is " + i);
                }
            }
        } else {
            System.out.println("The value wasn't found in the array.");
        }
    }

    public static boolean checkValue (int number, int[] array) {
        for (int j : array) {
            if (number == j) {
                return true;
            }
        }
        return false;
    }
}
