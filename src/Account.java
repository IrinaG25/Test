import java.util.Scanner;

public class Account {

    public double balance;


    public Account(double balance) {
        this.balance = balance;

    }

    public double depositFee(double deposit) {
        balance = balance + (deposit - (deposit * 10 / 100));
        return balance;
    }

    public double withdrawFee(double withdraw) {
        balance = balance - (withdraw + (withdraw * 5 / 100));
        return balance;
    }

    public void setNewBalance(double b) {

        balance = b;

    }

    public double getNewBalance() {

        return balance;
    }


}
