import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account class1 = null;

        System.out.println("What  kind of account would you like to open?");
        System.out.println("1)Anabari;\n 2)Everyday;\n 3)Credit;\n 4)Vip");
        int answer = sc.nextInt();
        if (answer == 1) {
            class1 = new Anabari(3000, 10);
        } else if (answer == 2) {
            class1 = new Everyday(2000);
        } else if (answer == 3) {
            class1 = new Credit(3000);
        } else {
            class1 = new Vip(2000);
        }

        if (class1 != null) {
            double a = class1.depositFee(500);

            System.out.println(a);
            System.out.println("balance: " + class1.balance);
        }
    }
}

