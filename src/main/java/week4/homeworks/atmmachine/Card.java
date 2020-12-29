package week4.homeworks.atmmachine;

import java.util.Random;

public class Card {
    private String cardNumber;
    private double expirationDate;
    private int cvvCode;
    private String label;
    private static int cardCount = 0;


    public Card () {
        cardNumber = generateCardNumber();
        expirationDate = generateExpirationDate();
        cvvCode = generateCvvCode();
        label = generateLabel();
    }

    public Card(String label) {
        cardNumber = generateCardNumber();
        expirationDate = generateExpirationDate();
        cvvCode = generateCvvCode();
        this.label = label;
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
}
