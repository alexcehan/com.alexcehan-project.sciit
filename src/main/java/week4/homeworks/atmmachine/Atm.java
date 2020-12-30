package week4.homeworks.atmmachine;

import java.util.Scanner;

public class Atm {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        generateAccountsForTesting();
        System.out.println("Sunt 2 useri creati default si detalille lor sunt afisate la inceputul programului" +
                " pentru testare.\nIn continuare se poate interactiona cu programul conform optiunilor de mai jos.\n" +
                "Am ales sa nu lucrez deloc cu import Date aici asa ca datele de expirare se foloseste in schimb" +
                "\nun double de tip yyyy.mm iar pentru current date un double cu valoarea 2021.01" +
                "\nLa fiecare user creat se genereaza automat 3 conturi si cate un card atasat fiecarui cont." +
                "\ntot random se genereaza si suma de bani care se afla in fiecare cont si data de expirare (pentru diversitate)" +
                "\n____________________________________________________________________\n\n");


        User currentUser = new User();
        boolean atmRunning = true;
        boolean userSelected = false;
        int userChoice = 0;



        while (atmRunning) {
            while (!userSelected) {

                System.out.println("1. Existing client.");
                System.out.println("2. New Client.");
                System.out.println("3. Quit. (The program will be closed.)");
                userChoice = validOption(0, 4);



                if (userChoice == 1) {
                    currentUser = existentUser();
                    if (currentUser != null) {
                        userSelected = true;
                    }
                } else if (userChoice == 2){
                    try {
                        currentUser = createNewUser();
                        User.userDatabase.add(currentUser);
                        for (BankAccount bankAccount : currentUser.allAccounts) {
                            bankAccount.setBalance(0.0);
                            bankAccount.card.setExpirationDate(2024.01);
                        }
                        System.out.println("\n\nThe account was created, you can now manage it from the main menu!\n\n");
                        Thread.sleep(2500);
                        System.out.println("");
                    }catch (NullPointerException e) {
                        System.out.println("This CNP is already in our database.");
                    }


                } else {
                    atmRunning = false;
                    System.out.println("Have a nice day!");
                    return;
                }

            }


            System.out.println("1. Account details");
            System.out.println("2. Cash withdrawal.");
            System.out.println("3. Deposit cash.");
            System.out.println("4. Bank transfer.");
            System.out.println("5. Transfer betwwen own accounts.");
            System.out.println("6. POS Payment.");
            System.out.println("7. Manage cards.");
            System.out.println("8. Quit. (The program won't be closed.)");
            userChoice = validOption(0, 9);


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
                    BankAccount.bankTransfer(currentUser);
                    break;
                case 5:
                    User.transferBetweenOwnAccounts(currentUser);
                    break;

                case 6:
                    Pos.makePayment(currentUser);
                    break;


                case 7:
                    Card.manageCards(currentUser);
                    break;

                case 8:
                    System.out.println("Have a good day!");
                    userSelected = false;
                    break;
            }


        }



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



    public static User createNewUser() {
        System.out.println("Let's create your account!");
        System.out.println("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter your last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter your CNP: ");
        String cnp = scanner.nextLine();

        for (User user : User.userDatabase) {
            if (user.getCnp().equals(cnp)) {

                return null;
            }

        }


        return new User(firstName, lastName, cnp);
    }


    public static int validOption(int min, int max) {
        int userChoice = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                userChoice = scanner.nextInt();
                scanner.nextLine();
                if (userChoice > min && userChoice < max) {
                    break;
                } else {
                    System.out.println("Please enter a valid option.");
                }
            } else {
                System.out.println("Please enter a valid option.");
                scanner.nextLine();
            }
        }


        return userChoice;

    }

    public static int validOption(int min, int max, String random) {
        int userChoice = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                userChoice = scanner.nextInt();
                if (userChoice > min && userChoice < max) {
                    break;
                } else {
                    System.out.println("Please enter a valid pin code of 4 digits.");
                }
            } else {
                System.out.println("Please enter a valid pin code of 4 digits.");
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

        System.out.format("%-20s %-20s %-11s","IBAN CODE", "CARD NAME", "BALANCE");
        System.out.println("");
        System.out.println("-------------------------------------------------------------------------------------");
        for (int i = 0; i < numberOfAccount; i++) {
            String ibanOutput = user.allAccounts.get(i).getIban();
            String balanceOutput = Double.toString(user.allAccounts.get(i).getBalance());
            String labelOutput = user.allAccounts.get(i).card.getLabel();
            String cardNumberOutput = user.allAccounts.get(i).card.getCardNumber();
            String cvvOutput = Integer.toString(user.allAccounts.get(i).card.getCvvCode());
            String dateOutput = Double.toString(user.allAccounts.get(i).card.getExpirationDate());

            System.out.format("%-20s %-20s %9s\n",ibanOutput, labelOutput, balanceOutput);
        }

        System.out.format("%-20s %30s", "Total Balance: ", Double.toString(user.displayTotalBalance()));


        System.out.println("");
        System.out.println("____________________________________________________________________________________");

    }

    public static void generateAccountsForTesting() {
        User.userDatabase.add(new User("Alex", "Cehan", "1900608643523"));
        User.userDatabase.add(new User("Ion", "Popescu", "1850101435465"));



        System.out.println();



        for(User user : User.userDatabase) {
            System.out.println("____________________________________________________________________");
            System.out.println(user.getFirsName() + " " + user.getLastName() + "          CNP:" + user.getCnp());
            System.out.println("");
            String ibanOutput = "IBAN CODE";
            String labelOutput = "BALANCE";
            String balanceOutput = "CARD NAME";
            System.out.format("%-20s %-20s %-10s",ibanOutput, labelOutput, balanceOutput);
            System.out.println("\n--------------------------------------------------------------------");
            for (BankAccount bankAccount : user.allAccounts) {

                ibanOutput = bankAccount.getIban();
                balanceOutput = Double.toString(bankAccount.getBalance());
                labelOutput = bankAccount.card.getLabel();
                System.out.format("%-20s %-20s %-10s",ibanOutput, labelOutput, balanceOutput);
                System.out.println();
            }
            System.out.println("\n");
            System.out.format("%-20s %-25s %-5s %-9s","CARD NAME", "CARD NUMBER", "CVV", "EXPIRATION DATE\n");
            for (BankAccount bankAccount : user.allAccounts) {
                ibanOutput = bankAccount.getIban();
                balanceOutput = Double.toString(bankAccount.getBalance());
                labelOutput = bankAccount.card.getLabel();
                String cardNumberOutput = bankAccount.card.getCardNumber();
                String cvvOutput = Integer.toString(bankAccount.card.getCvvCode());
                String dateOutput = Double.toString(bankAccount.card.getExpirationDate());

                System.out.format("%-20s %-25s %-5s %-9s",labelOutput, cardNumberOutput, cvvOutput, dateOutput);
                System.out.println();

            }

            System.out.println("____________________________________________________________________");
        }
    }



}
