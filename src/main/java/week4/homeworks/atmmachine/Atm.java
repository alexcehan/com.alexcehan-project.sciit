package week4.homeworks.atmmachine;

import java.util.Scanner;

public class Atm {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        User.userDatabase.add(new User("Alex", "Cehan", "1900608073835"));
        User.userDatabase.add(new User("Irina", "Cehan", "1900212435465"));
        User currentUser = new User();
        boolean atmRunning = true;
        boolean userSelected = false;
        int userChoice = 0;



        while (atmRunning) {
            while (!userSelected) {

                System.out.println("1. Client existent.");
                System.out.println("2. Client nou.");
                userChoice = validOption(0, 3);



                if (userChoice == 1) {
                    currentUser = existentUser();
                    if (currentUser != null) {
                        userSelected = true;
                    }
                } else {
                    currentUser = createNewUser();
                    User.userDatabase.add(currentUser);
                }

            }


            System.out.println("1. Detalii cont.");
            System.out.println("2. Retragere numerar.");
            System.out.println("3. Depunere numerar.");
            System.out.println("4. Transfer bancar.");
            System.out.println("5. Transfer intre conturi proprii");
            System.out.println("6. Plata POS.");
            System.out.println("7. Creare Card Bancar nou.");
            System.out.println("8. Quit.");
            userChoice = validOption(0, 8);


            switch (userChoice) {
                case 1:
                    printAccountDetails(currentUser);
                    break;
                case 2:
                    System.out.println("Enter the amount you want to withdraw: ");
                    double moneyAmountWithdrawal = validOption(0, Integer.MAX_VALUE);
                    currentUser.bankAccount.withdrawMoney(moneyAmountWithdrawal);
                    break;
                case 3:
                    BankAccount.depositMoney(currentUser);
                    break;
                case 4:
                    User toTransfer = findUser();
                    System.out.println("Enter the amount you want to transfer: ");
                    double moneyToTransfer = validOption(0, Integer.MAX_VALUE);
                    break;
                case 5:
                    User.transferBetweenOwnAccounts(currentUser);
                    break;

                case 6:
                    Pos.makePayment(currentUser);
                    break;

                case 7:
                    createNewCard(currentUser);
                    break;

                case 8:
                    System.out.println("Have a good day!");
                    atmRunning = false;
                    break;
            }


        }


        User newUser = new User("Alexandru", "Cehan", "1900608073835");

//        System.out.println(newUser.bankAccount.getIban());
//        System.out.println(newUser.card.getCardNumber());
//        System.out.println(newUser.card.getExpirationDate());
//        System.out.println(newUser.card.getCvvCode());


    }

    public static void createNewCard(User user) {
        boolean flag = true;

        while (flag) {

            System.out.println("How to you want to name this card? ");
            String label = scanner.nextLine();
            System.out.println("Are you sure you want to call the card: " + label);
            System.out.println("1. Yes.");
            System.out.println("2. No.");
            System.out.println("3. Cancel.");

            int userChoice = validOption(0, 4);
            switch (userChoice) {
                case 1:
                    user.allAccounts.add(new BankAccount(label));
                    flag = false;
                case 2:
                    break;
                default:
                    flag = false;
            }
        }

    }

    public static User existentUser() {
        String userCnp = "";
        System.out.println("Enter your CNP: ");
        userCnp = scanner.nextLine();
        User enteredUser = new User();
        enteredUser = enteredUser.checkIfUserExists(userCnp);
        if (enteredUser == null) {
            System.out.println("This CNP doesn't exist in our database.");
        } else {
            System.out.println("Hello " + enteredUser.getFirsName());
        }

        return enteredUser;

    }

    public static User findUser() {
        String userString = "";
        System.out.println("Enter the Bank Account of the person you want to transfer to: ");
        userString = scanner.nextLine();
        User enteredUser = new User();
        enteredUser = enteredUser.findAccount(userString);
        if (enteredUser == null) {
            System.out.println("We don't have any information about this account. Make the transfer at own risk");
        } else {
            System.out.println("This account belongs to " + enteredUser.getFirsName() + " " + enteredUser.getLastName());
        }

        return enteredUser;


    }

    public static User createNewUser() {
        System.out.println("Let's create your account!");
        System.out.println("Enter your firs name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter your last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter your CNP: ");
        String cnp = scanner.nextLine();

        return new User(firstName, lastName, cnp);
    }


    public static int validOption(int min, int max) {
        int userChoice = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                userChoice = scanner.nextInt();
                if (userChoice > min && userChoice < max) {
                    break;
                } else {
                    System.out.println("Please enter a valid option.");
                }
            } else {
                System.out.println("Please enter a valid option.");
            }
        }
        scanner.nextLine();

        return userChoice;

    }

    public static void printAccountDetails(User user) {
        System.out.println("____________________________________________________________________________________");
        System.out.println("");
        System.out.println("First Name: " + user.getFirsName());
        System.out.println("Last Name: " + user.getLastName());
        System.out.println("");
        int numberOfAccount = 0;
        for (int i = 0; i < user.allAccounts.size(); i++) {
            if (user.allAccounts.get(i) != null) {
                numberOfAccount++;
            }
        }
        for (int i = 0; i < numberOfAccount; i++) {
            System.out.println((i +1) +". " + user.allAccounts.get(i).getIban()+" "+ user.allAccounts.get(i).card.getLabel() + " " + user.allAccounts.get(i).getBalance());
        }
        System.out.println("Total Balance: " + user.displayTotalBalance());


        System.out.println("");
        System.out.println("____________________________________________________________________________________");

    }



}
