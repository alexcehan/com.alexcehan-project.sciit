package week4.homeworks.atmmachine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Pos {
    private double paymentAmount;
    private static int receipesCount = 1;

    public static void makePayment(User user) throws InterruptedException {
        System.out.println("Enter the payment value: ");
        double paymentAmount = 0.0;
        Scanner scanner = new Scanner(System.in);
        try {
            paymentAmount = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid value!");
            return;
        }

        System.out.println("Select the card you want to make the payment with: ");
        int numberOfAccount = 0;
        for (int i = 0; i < user.allAccounts.size(); i++) {
            if (user.allAccounts.get(i) != null) {
                numberOfAccount++;
            }
        }
        for (int i = 0; i < numberOfAccount; i++) {
            System.out.println((i +1) +". " + user.allAccounts.get(i).card.getLabel()  + " " + user.allAccounts.get(i).getBalance());
        }

        int userChoice = Atm.validOption(0, numberOfAccount + 1);

        System.out.println("\n\n\n\n");
        System.out.println("___________________________");
        for (int i = 0; i < 5; i++) {
            System.out.println("*");
            Thread.sleep(400);

        }

        if (paymentAmount > user.allAccounts.get(userChoice -1).getBalance()) {
            System.out.println("Payment incomplete.");

            System.out.println("Insufficient funds!");
        } else {
            System.out.println("Payment succesfull!");
            Thread.sleep(2000);
            System.out.println("\n\n");
            System.out.println("____________________________________________________________");
            System.out.println("Scoala Infdorma de IT");
            System.out.println("\n");
            System.out.println("Total payment " + paymentAmount);
            System.out.println("TVA " + (paymentAmount * 0.19));
            System.out.println("");
            System.out.println(user.allAccounts.get(userChoice-1).card.getLabel());
            System.out.println("*Pin Verified");
            System.out.print("A/C No. ");
            char[] cardNumber = user.allAccounts.get(userChoice-1).card.getCardNumber().toCharArray();
            for (int i = 0; i < 19; i++) {
                if ((i == 4) || (i == 9) || (i == 14)) {
                    System.out.print(" ");
                } else if (i < 15) {
                    System.out.print("*");
                } else {
                    System.out.print(cardNumber[i]);
                }
             }
            System.out.println("");
            user.allAccounts.get(userChoice -1).setBalance(user.allAccounts.get(userChoice -1).getBalance() - paymentAmount);

            System.out.println("30/12/2020       15:44:40");
            System.out.println("EPS NO. " + receipesCount );
            System.out.println("\nPLEASE KEEP THIS COPY FOR YOUR RECORDS");
            System.out.println("____________________________________________________________");
        }


    }
}
