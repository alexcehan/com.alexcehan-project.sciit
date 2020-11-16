package week1.homeworks;

import java.util.Scanner;

/*
11. Print the number of days specific to each month in year.
input: Month (string) of index of the month(1, 2, ... 12)
output: 31, 30, 28
 */

public class NumberOfDaysInMonth {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        int number = 0;

        System.out.println("Enter the index of the month (1-12): ");

        while (flag) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                flag = false;
                scanner.nextLine();
                if ((number < 1) || (number > 12)) {
                    System.out.println("Please enter a number between 1 and 12!");
                    flag = true;
                }
            } else {
                scanner.nextLine();
                System.out.println("Please enter a valid value!");
            }
        }

        switch (number){
            case 1:
                System.out.println("January has 31 days.");
                break;
            case 2:
                System.out.println("What year? ");
                int year = 0;
                flag = true;
                while (flag) {
                    if (scanner.hasNextInt()) {
                        year = scanner.nextInt();
                        flag = false;
                        if ((year < 1) || (year > 9999)) {
                            System.out.println("Please enter a valid year! ");
                            flag = true;
                        }
                    } else {
                        System.out.println("Please enter a valid value!");
                        scanner.nextLine();

                    }
                }

                if(isLeapYear(year)) {
                    System.out.println("February in " + year + " has 29 days!") ;
                } else {
                    System.out.println("February in " + year + " has 28 days!") ;
                }


                break;
            case 3:
                System.out.println("March has 31 days.");
                break;
            case 4:
                System.out.println("April has 30 days.");
                break;
            case 5:
                System.out.println("May has 31 days.");
                break;
            case 6:
                System.out.println("June has 30 days.");
                break;
            case 7:
                System.out.println("July has 31 days.");
                break;
            case 8:
                System.out.println("August has 31 days.");
                break;
            case 9:
                System.out.println("September has 30 days.");
                break;
            case 10:
                System.out.println("Octomber has 31 days.");
                break;
            case 11:
                System.out.println("November has 30 days.");
                break;
            case 12:
                System.out.println("December has 31 days.");
                break;
            default:
                System.out.println("Invalid month");
                break;
                //never reached
        }


    }


    public static boolean isLeapYear(int year) {
        if ((year % 100 == 0) && (year % 400 != 0)) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
