package week4.homeworks.atmmachine;

import java.util.Random;

public class Card {
    private String cardNumber;
    private double expirationDate;
    private int cvvCode;
    private String label;
    private int codePin = 1234;
    private static int cardCount = 0;







    public Card () {
        cardNumber = generateCardNumber();
        expirationDate = generateExpirationDate();
        cvvCode = generateCvvCode();
        label = generateLabel();
    }

    public Card(String label) {
        cardNumber = generateCardNumber();
        expirationDate = 2024.01;
        cvvCode = generateCvvCode();
        this.label = label;

        System.out.println("The PIN Code for this card is: 1234 . Change it in Manage Cards section.");
    }

    public int getCodePin() {
        return codePin;
    }

    public void setCodePin(int codePin) {
        this.codePin = codePin;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    private static String generateLabel() {
        switch (cardCount) {
            case 0:
                cardCount++;
                return "Visa";

            case 1:
                cardCount++;
                return "MasterCard";
            case 2:
                cardCount++;
                return "Maestro";
            default:
                cardCount = 0;
                return "American Express";
        }
    }
    private static String generateCardNumber() {
        String cardNumber = "";
        Random rn = new Random();
        int range = 9999 - 1000 + 1;

        for (int i = 0; i < 4; i++) {
            int number = rn.nextInt(range) + 1000;
            cardNumber+= number;

            if(i != 3) {
                cardNumber+= (" ");
            }
        }
        return cardNumber;
    }


    private static double generateExpirationDate(){
        double expirationDate = 0.0;
        Random rn = new Random();
        int year = 0;
        int month = 0;

        int range = 2023 - 2018 + 1;

        year = rn.nextInt(range) + 2018;

        range = 12 - 1 + 1;
        month = rn.nextInt(range) + 1;

        expirationDate = (year * 1.0) + (1.0* month / 100);


        return expirationDate;
    }



    private static int generateCvvCode() {
        int cvvCode = 0;
        Random rn = new Random();
        int range = 999 - 100 + 1;

        cvvCode = rn.nextInt(range) + 100;


        return cvvCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(double expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getCvvCode() {
        return cvvCode;
    }

    public void setCvvCode(int cvvCode) {
        this.cvvCode = cvvCode;
    }

    public static void manageCards (User user) {
        System.out.println("Default pin code for every card is 1234. We strongly suggest to change it.\n\n");
        int numberOfAccount = 0;
        for (int i = 0; i < user.allAccounts.size(); i++) {
            if (user.allAccounts.get(i) != null) {
                numberOfAccount++;
            }
        }
        System.out.format("%-4s %-22s %-24s %-16s %5s\n","Nr", "CARD NAME","CARD NUMBER", "EXPIRATION DATE", "CVV");

        System.out.println("-------------------------------------------------------------------------------------");

        for (int i = 0; i < numberOfAccount; i++) {

            String ibanOutput = user.allAccounts.get(i).getIban();
            String balanceOutput = Double.toString(user.allAccounts.get(i).getBalance());
            String labelOutput = user.allAccounts.get(i).card.getLabel();
            String cardNumberOutput = user.allAccounts.get(i).card.getCardNumber();
            String cvvOutput = Integer.toString(user.allAccounts.get(i).card.getCvvCode());
            String dateOutput = Double.toString(user.allAccounts.get(i).card.getExpirationDate());

            System.out.format("%2d. %-22s %-25s %-16s %5s\n",(i+1), labelOutput,cardNumberOutput, dateOutput, cvvOutput);


        }

        System.out.println("\n\n\n");

        System.out.println("1. Create new card.");
        System.out.println("2. Change pin code");
        System.out.println("3. Cancel");

        int userChoice = Atm.validOption(0, 4);
        if(userChoice == 1) {
            Atm.createNewCard(user);
        } else if(userChoice == 2) {
            System.out.println("Select card: ");
            numberOfAccount = 0;
            for (int i = 0; i < user.allAccounts.size(); i++) {
                if (user.allAccounts.get(i) != null) {
                    numberOfAccount++;
                }
            }
            for (int i = 0; i < numberOfAccount; i++) {

                System.out.println((i +1) +". " +user.allAccounts.get(i).card.getLabel());

            }

            userChoice = Atm.validOption(0, numberOfAccount+1) - 1;

            System.out.println("Enter the current code pin: ");
            int curentPin = Atm.validOption(999, 10000);
            if (curentPin == user.allAccounts.get(userChoice).card.getCodePin()) {
                System.out.println("Enter the new code pin: ");
                int newPin = Atm.validOption(999, 10000);
                user.allAccounts.get(userChoice).card.setCodePin(newPin);
                System.out.println("Pin Code was succesfully changed!");
                return;
            } else {
                System.out.println("Wrong pin code");
                System.out.println("Operation aborted.");
                return;
            }


        } else {
            return;
        }




    }
}
