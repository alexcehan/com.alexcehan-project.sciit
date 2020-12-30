package week4.homeworks.atmmachine;

import java.util.ArrayList;
import java.util.Random;

public class User {



    public static ArrayList<User> userDatabase = new ArrayList<>();
    private String firsName;
    private String lastName;
    private String cnp;
    BankAccount bankAccount;

    private double totalBalance;
    ArrayList<BankAccount> allAccounts = new ArrayList<>();


    public User () {

    }



    public User(String firsName, String lastName, String cnp) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.cnp = cnp;
        generateBankAccounts(this); //metodele generateBankAccounts() si generateRandomBalance() sunt facute stric pentru generare de cate 3 conturi random si setare automat a unui sold random la fiecare user creat.




    }

    public static void generateBankAccounts(User user) {
        for (int i = 0; i < 3; i++) {
            user.allAccounts.add(new BankAccount());
            user.allAccounts.get(i).setBalance(generateRandomBalance());
        }
    }

    private static int generateRandomBalance() {
        Random rn = new Random();
        int range = 2000 - 0 + 1;
        int number = rn.nextInt(range) + 0;
        int randomBalance = number;
        return number;
    }

    public static void transferBetweenOwnAccounts(User user) {
        System.out.println("Select the account you want to transfer from: ");
        int numberOfAccount = 0;
        for (int i = 0; i < user.allAccounts.size(); i++) {
            if (user.allAccounts.get(i) != null) {
                numberOfAccount++;
            }
        }
        for (int i = 0; i < numberOfAccount; i++) {
            System.out.println((i+1) +". " + user.allAccounts.get(i).getIban() + " " + user.allAccounts.get(i).getBalance());
        }

        int userChoice = 0;
        userChoice = (Atm.validOption(0, numberOfAccount+1) - 1);
        BankAccount fromAccount = user.allAccounts.get(userChoice);

        System.out.println("Select the bank account you want to transfer to: ");
        int secondUserChoice = 0;
        secondUserChoice = (Atm.validOption(0, numberOfAccount+1) - 1);
        BankAccount destinationAccount = user.allAccounts.get(secondUserChoice);

        System.out.println("Enter the amount you want to transfer: ");
        double money = Atm.validOption(0, Integer.MAX_VALUE);
        if (fromAccount.getBalance() < money) {
            System.out.println("Insufficient funds!");
        } else {
            fromAccount.setBalance(fromAccount.getBalance() - money);
            destinationAccount.setBalance(destinationAccount.getBalance() + money);
        }



    }

    public double displayTotalBalance() {
        totalBalance = 0;
        for (int i = 0; i < allAccounts.size(); i++) {
            if(allAccounts.get(i)!= null) {
                totalBalance+=allAccounts.get(i).getBalance();
            }

        }
        return totalBalance;
    }

    public User checkIfUserExists(String cnp) {
        for (User user : userDatabase) {
            if (user.cnp.equals(cnp)) {
                return user;
            }
        }
        return null;

    }

    public User findAccount (String enteredBankAccount) {
        for(User user : userDatabase) {
            if (user.bankAccount.getIban().equals(enteredBankAccount)) {
                return user;
            }
        }

        return null;
    }


    public double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }





    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }
}
