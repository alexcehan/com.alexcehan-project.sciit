package week12.homework.transactions;


import lombok.Data;

@Data
public class Transaction {
    private final int value;
    private final int year;
    private final Trader trader;

    @Override
    public String toString() {
        return "Transaction{" +
                "value=" + value +
                ", year=" + year +
                ", trader=" + trader +
                '}';
    }
}
