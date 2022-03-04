public class Anabari extends Account {

    int percent;

    public Anabari(double balance, int percent) {
        super(balance);
        this.percent = percent;

    }

    @Override
    public double depositFee(double deposit) {
        balance = balance + deposit;
        return balance;
    }

    @Override
    public double withdrawFee(double withdraw) {
        balance = (balance + (withdraw * percent / 100)) - withdraw;
        return balance;
    }

    public void blabla() {

    }
}
