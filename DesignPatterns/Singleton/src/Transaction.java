public class Transaction {

    final private String from, to;
    final private Integer amount;

    public Transaction(String from, String to, Integer amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }


    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Integer getAmount() {
        return amount;
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "from:'" + from + '\'' +
                ", to:'" + to + '\'' +
                ", amount:" + amount +
                "}";
    }
}
