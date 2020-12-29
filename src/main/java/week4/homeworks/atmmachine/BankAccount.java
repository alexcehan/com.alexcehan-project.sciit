package week4.homeworks.atmmachine;

import java.util.Random;

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

    public void transferMoney (double money, User user) {
        if (this.balance < money ) {
            System.out.println("You don't have enough funds");
        } else {
            this.balance = this.balance - money;
        }

        if (user != null) {
            user.bankAccount.balance +=money;
        }
    }



    private static String generateIban() {
        Random rn = new Random();
        int range = 99999999 - 10000000 + 1;
        int number = rn.nextInt(range) + 10000000;
        String tempIban = ("BANK2020RO" + number);


        return tempIban;
    }




}
