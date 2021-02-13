package week12.homework.transactions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        /**
         * Pentru a avea un pic mai mult farmec metodele am creat o lista random de 1000 de transactii pe care am importat-o
         * aici . Lista se afla si in csv-ul transactionData.csv din pachetul transactions.
         */


        LinkedList<Transaction> transactions = createTransactionsList();



        // What are all the unique cities where the traders work?
        // Deoarece m-am cam chinuit un pic la partea cu 'orase distincte', pe baza unor indicatii online am scris aici metoda
        // distinctByKey(), face ce am nevoie dar trebuie sa recunosc ca nu am reusit sa o inteleg cum functioneaza.
        printUniqueCities(transactions);

        //Find all traders from Cambridge and sort them by name.
        printTradersFromCambridge(transactions);


        //Return a string of all traders’ names sorted alphabetically.
        System.out.println(returnAStringOfAllNamesTraders(transactions));

        //Are any traders based in Milan?
        System.out.println(checkIfAnyTradersAreFromMilan(transactions));

        //Print all transactions’ values from the traders living in Cambridge.
         printTransactionsValueFromCambridge(transactions);

        //What’s the highest value of all the transactions?
        System.out.println(returnHighestTransactionValue(transactions));

        //Find the transaction with the smallest value.
        System.out.println(retunnTheSmallesTransactionValue(transactions));






    }

    public static int retunnTheSmallesTransactionValue(LinkedList<Transaction> list) {
        Stream <Transaction> transactionStream = list.stream();
        Transaction transaction1 = transactionStream
                .min(Comparator.comparing(transaction -> transaction.getValue()))
                .get();


        return transaction1.getValue();
    }

    public static int returnHighestTransactionValue(LinkedList<Transaction> list) {


        Stream <Transaction> transactionStream = list.stream();
         Transaction transaction1 = transactionStream
                 .max(Comparator.comparing(transaction -> transaction.getValue()))
                 .get();


         return transaction1.getValue();



    }

    public static void printTransactionsValueFromCambridge(LinkedList<Transaction> list) {
        Stream <Transaction> transactionStream = list.stream();
        transactionStream
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .forEach(transaction -> System.out.println(transaction.getValue()));
    }

    public static boolean checkIfAnyTradersAreFromMilan(LinkedList<Transaction> list) {
        Stream <Transaction> transactionStream = list.stream();
        return transactionStream.anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));







        //return false;
    }

    public static String returnAStringOfAllNamesTraders(LinkedList<Transaction> list) {
        String namesString = "";
        LinkedList<String> nameList = new LinkedList<>();
        Stream <Transaction> transactionStream = list.stream();
        transactionStream
                .sorted(Comparator.comparing(transaction -> transaction.getTrader().getName()))
                .forEach(transaction -> nameList.add(transaction.getTrader().getName()));

        for(String name : nameList) {
            namesString += name + ",";
        }

        return namesString;
    }

    public static void printTradersFromCambridge(LinkedList<Transaction> list) {
        Stream <Transaction> transactionStream = list.stream();
        transactionStream
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(transaction -> transaction.getTrader().getName()))
                .forEach(transaction -> System.out.println(transaction.getTrader().getName()));
    }

    public static void printUniqueCities(LinkedList<Transaction> list) {
        Stream <Transaction> transactionStream = list.stream();
                transactionStream
                        .filter(distinctByKey(s -> s.getTrader().getCity()))
                        .sorted(Comparator.comparing(transaction -> transaction.getTrader().getCity()))
                        .forEach(s -> System.out.println(s.getTrader().getCity()));



    }

    public static LinkedList<Transaction> createTransactionsList() {
        String srcFile = "src/main/java/week12/homework/transactions/transactionsData.csv";
        LinkedList<Transaction> transactionLinkedList = new LinkedList<>();

        try (Stream<String> stream = Files.lines(Paths.get(srcFile))) {
            //String[] line;
            stream
                    .skip(1)
                    .map(line -> line.split(","))
                    .forEach(line -> transactionLinkedList.add(new Transaction(Integer.parseInt(line[1]), Integer.parseInt(line[3]), new Trader(line[0], line[2]))));


        } catch (IOException e) {
            e.printStackTrace();
        }

        return transactionLinkedList;
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

}

