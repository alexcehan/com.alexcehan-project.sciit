package week6.homeworks.atmmachine;

import java.util.Random;
import java.util.Scanner;

public class BankAccount {
    private String iban;
    private double balance;
    Card card;

    public BankAccount() {
        iban = generateIban();
        balance = 0.0;
        this.card = new Card();

    }

    public BankAccount(String label) {
        iban = generateIban();
        balance = 0.0;
        this.card = new Card(label);
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdrawMoney (double money) {
        if (money > this.balance) {
            System.out.println("Insufficient funds!");
        } else {
            this.balance = this.balance - money;
            System.out.println("Your withdrawal request was succesfull!");
        }
    }

    public static void depositMoney (User user) {
        System.out.println("In which account you want to make the deposit? ");
        int numberOfAccount = 0;
        for (int i = 0; i < user.allAccounts.size(); i++) {
            if (user.allAccounts.get(i) != null) {
                numberOfAccount++;
            }
        }
        for (int i = 0; i < numberOfAccount; i++) {
            System.out.println((i +1) +". " + user.allAccounts.get(i).getIban()+" "+ user.allAccounts.get(i).card.getLabel() );
        }

        int userChoice = Atm.validOption(0, numberOfAccount + 1);
        System.out.println("What is the amount you want to deposit? ");
        int userDeposit = Atm.validOption(-1, Integer.MAX_VALUE);
        user.allAccounts.get(userChoice-1).setBalance(user.allAccounts.get(userChoice-1).getBalance() + userDeposit);


        System.out.println("Your deposit request was succesfull!");
    }





    private static String generateIban() {
        Random rn = new Random();
        int range = 99999999 - 10000000 + 1;
        int number = rn.nextInt(range) + 10000000;
        String tempIban = ("BANK2020RO" + number);


        return tempIban;
    }

    public static void bankTransfer(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the bank account you want to trasfer the money from: ");

        int numberOfAccount = 0;
        for (int i = 0; i < user.allAccounts.size(); i++) {
            if (user.allAccounts.get(i) != null) {
                numberOfAccount++;
            }
        }
        for (int i = 0; i < numberOfAccount; i++) {
            System.out.println((i +1) +". " + user.allAccounts.get(i).getIban()+" "+ user.allAccounts.get(i).getBalance());
        }

        int userChoice = Atm.validOption(0, numberOfAccount + 1);

        System.out.println("Enter the amount you want to transfer: ");
        int moneyToTransfer = Atm.validOption(0, Integer.MAX_VALUE);

        if (moneyToTransfer > user.allAccounts.get(userChoice-1).getBalance()) {
            System.out.println("Insuficient funds!");
            System.out.println("Operation aborted");
            return;
        }

        System.out.println("Enter the iban of the account you want to transfer money to: ");

        String userIban = scanner.nextLine();
        for (User user1 : User.userDatabase) {
            int index = 0;
            for(BankAccount bankAccount : user1.allAccounts) {

                if(bankAccount.getIban().equals(userIban)) {
                    System.out.println("The iban was found in our databse. Money will be transfered in " + user1.getFirsName() + " " + user1.getLastName() + " account.");
                    user.allAccounts.get(userChoice - 1).setBalance(user.allAccounts.get(userChoice-1).getBalance() - moneyToTransfer);
                    user1.allAccounts.get(index).setBalance(user1.allAccounts.get(index).getBalance() + moneyToTransfer);
                    System.out.println("Money transfer was executed.");
                    return;


                }
                index++;
            }


        }
        System.out.println("We don't have any information about this account. If you decide to proced with transfer, you take full responsibility for it");
        System.out.println("Do you want to continue the transfer? \n1. Yes. \n2. No");
        int userChoice2 = Atm.validOption(0, 3);
        if (userChoice2 == 1) {
            user.allAccounts.get(userChoice - 1).setBalance(user.allAccounts.get(userChoice-1).getBalance() - moneyToTransfer);
            System.out.println("Money transfer was executed.");
        } else {
            System.out.println("Operation aborted!");
        }


    }




}
