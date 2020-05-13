import java.util.ArrayList;

public class Transactions {


    private static Transactions transactions;
    private final ArrayList<Transaction> TransactionsList;

    private Transactions() {
        TransactionsList = new ArrayList();
    }


    public static Transactions getTransactions() {
        if (transactions == null) {
            synchronized (Transactions.class) {
                if (transactions == null) {
                    transactions = new Transactions();
                }
            }
        }
        return transactions;
    }


    public void add(Transaction transaction) {
        TransactionsList.add(transaction);
    }

    public void print() {
        for (Transaction transaction : TransactionsList)
            System.out.println(transaction);
    }
}

