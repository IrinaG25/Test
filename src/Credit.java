public class Credit extends Account {
    int percent;

    public Credit(double balance) {
        super(balance);
    }

    @Override
    public double withdrawFee(double withdraw) {
        balance = balance - withdraw;
        return balance;
    }
}
