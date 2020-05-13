public class Application {

    public static void main(String[] args) {
        
        Transactions.getTransactions().add(new Transaction("Ayanna Mcgregor","Solomon Weekly",340));
        Transactions.getTransactions().add(new Transaction("Latisha Koh","Mignon Romaine",430));
        Transactions.getTransactions().add(new Transaction("Ilene Bentler","Antonio Rall",540));
        Transactions.getTransactions().add(new Transaction("Rima Judon","Keitha Kwan",750));
        Transactions.getTransactions().add(new Transaction("Joanie Yarber","Jody Delara",120));

        Transactions.getTransactions().print();

    }
}
