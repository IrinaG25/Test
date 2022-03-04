import java.util.Scanner;

public abstract class Account {

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

    double name() {  //default
        return 0;
    }
}

interface Account1 {
    public final static int A = 1;

    double name(String a); //public abstract
}

interface Account2 {
    public final static int A = 1;

    double name(String a); //public abstract
}

class Abc{

}