
import java.util.Scanner;

/**
 * In diese Klasse wird der erste Teil unseres Textadventureprojekt programmiert
 *
 * @author Le Manh Duc Pham
 */
public class Unterwegs {
    Scanner movement = new Scanner(System.in);//eine Instanz der Klasse Scanner wird erzeugt
    String name, lieblingsessen;//Name und Lieblingsessen des Spielers werden als String-Variablen deklariert
    int choice;//Die Wahl oder die Eingabe des Spielers als Integer deklarieren
    int stamina;//Die Staminapunkte des Spielers
    double money;//Das Geld des Spielers
    int cafecount, seecount;//Die Anzahl der Besuche des Spielers im Café
    boolean essen;//Checken, ob der Spieler etwas gegessen hat
    boolean liebEssen;//Checken, ob der Spieler sein Lieblingsessen gefunden hat
    static boolean end1;//Checken, ob der erste Teil beendet

	/
    Der Konstruktor/

    public Unterwegs(String n, String le, int s, double m) {
        name = n;
        lieblingsessen = le;
        stamina = s;
        money = m;
    }
	/
    Setter der
    Staminapunkte-Variablen/

    public void setStamina(int a) {
        stamina = a;
    }
	/
    Setter der
    Geld-Variablen/

    public void setGeld(double b) {
        money = b;
    }
	/
    Zu dieser
    Methode gehören
    die Einleitung, Regeln
    und Geschichte/

    public void Intro1() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Einleitung");
        System.out.println("");
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("1. Regeln");
        System.out.println("- In diesem Teil sollen Sie nur eine ganze Zahl (Integer) für jede Wahl eingeben.");
        System.out.println("- Sie haben Stamina und für jede Bewegung zu Fuß werden Sie einen Staminapunkt verlieren.");
        System.out.println("- Sie werden verlieren, wenn Sie noch keine Staminapunkte haben.");
        System.out.println("- Sie haben auch Geld, Sache zu kaufen.");
        System.out.println("- Sie haben zuerst " + stamina + " Staminapunkte und " + money + " Euro.");
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("2. Geschichte");
        System.out.println("Hallo " + name + ", Sie sind ein Arzt und Sie sind ins Hochrisikogebiet angekommen");//Text
        System.out.println("Sie haben gerade den Flughafen verlassen und nach einem 20-Stunden-Flug sind Sie sehr hungrig.");
        System.out.println("");
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("3. Mission");
        System.out.println("- Sie mussen etwas essen(30%). Ihre Lieblingsessen ware am besten(20%)!");
        System.out.println("- Sie mussen nach dem Essen das Krankenhaus erreichen(50%).");
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Viel Glück");
    }
	/
    Diese Methode
    wird checken, ob
    der Spieler
    verloren hat/

    public int Check() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Ihre Staminapunkte: " + stamina);//Die restliche Staminapunkte drucken
        System.out.println("Ihr Geld: " + money);//Das restliche Geld drucken
        if (stamina == 0) {//Der Spieler wird verlieren, wenn er noch keine Staminapunkte hat
            System.out.println("Game Over. Sie haben noch keine Staminapunkte.");
            System.out.println("Möchten Sie noch einmal spielen?");
            System.out.println("");
            System.out.println("1. Ja");
            System.out.println("2. Nein");
            System.out.println("\n------------------------------------------------------------------\n");

            do {//eine do-while Schleife, falls der Spieler ein ungültige Zahl eingegeben hat
                choice = movement.nextInt();//die Zahleingabe wird gelesen und in der Variablen choice speichert
                switch (choice) {//switch-case
                    case 1://das Spiel neustarten
                        setStamina(Main.stamina);//die Staminapunkte wird rückgesetzt
                        setGeld(Main.money);//das Geld wird rückgesetzt
                        Kreuzung2();
                        break;
                    case 2://das Spiel verlassen
                        System.out.println("Danke fürs Spielen");
                        break;
                    default://falls ungültige Eingabe
                        System.out.println("Ungültig! Bitte geben Sie eine gültige ganze Zahl ein");
                }
            } while (choice < 1 || choice > 2);
            return 0;//der Wert 0 rückgeben, wenn Game Over
        } else {
            return 1;//der Wert 1 rückgeben, wenn der Spieler noch nicht verliert
        }
    }

    public void Kreuzung1() {
        if (Check() == 1) {//Der Spieler hat noch nicht verloren
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("Sie sind an der Strassengabelung.");
            System.out.println("Im Norden gibt es ein Park.");
            System.out.println("Im Osten legt die Flughafenkreuzung (Startpunkt).");
            System.out.println("Es gibt hier ein Bahnhof.");
            System.out.println("");
            System.out.println("In welcher Richtung mochten Sie gehen?");
            System.out.println("");
            System.out.println("1: Nord");
            System.out.println("2: Ost");
            System.out.println("3: Bahnhof");
            System.out.println("\n------------------------------------------------------------------\n");

            do {//eine do-while Schleife, falls der Spieler ein ungültige Zahl eingegeben hat
                choice = movement.nextInt();//die Zahleingabe wird gelesen und in der Variablen choice speichert
                switch (choice) {//switch-case
                    case 1:
                        stamina = stamina - 1;//Staminapunkte verlieren für jede Bewegung
                        Kreuzung5();
                        break;
                    case 2:
                        stamina = stamina - 1;
                        Kreuzung2();
                        break;
                    case 3:
                        Bahnhof();
                        break;
                    default:
                        System.out.println("Ungültig! Bitte geben Sie eine gültige ganze Zahl ein");
                }
            } while (choice < 1 || choice > 3);
        }
    }

    public void Kreuzung2() {
        if (Check() == 1) {
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("Sie sind an der Flughafenkreuzung (Startpunkt).");
            System.out.println("Im Norden gibt es Stadtzentrum.");
            System.out.println("Im Osten gibt es ein Markt.");
            System.out.println("Im Westen gibt es ein Bahnhof.");
            System.out.println("");
            System.out.println("In welcher Richtung mochten Sie gehen?");
            System.out.println("");
            System.out.println("1: Nord");
            System.out.println("2: Ost");
            System.out.println("3: West");
            System.out.println("\n------------------------------------------------------------------\n");

            do {
                choice = movement.nextInt();
                switch (choice) {
                    case 1:
                        stamina = stamina - 1;
                        Kreuzung6();
                        break;
                    case 2:
                        stamina = stamina - 1;
                        Kreuzung3();
                        break;
                    case 3:
                        stamina = stamina - 1;
                        Kreuzung1();
                        break;
                    default:
                        System.out.println("Ungültig! Bitte geben Sie eine gültige ganze Zahl ein");
                }
            } while (choice < 1 || choice > 3);
        }
    }

    public void Kreuzung3() {
        if (Check() == 1) {
            System.out.println("\n---------------…
                    [4:29 pm, 14 / 01 / 2022]Pham Duc: package test;
import java.util.Scanner;

            public class Main {
                static int stamina = 7;
                static double money = 20;

                public static void main(String[] args) {
                    int choice;
                    Scanner player = new Scanner(System.in);
                    System.out.println("Bitte geben Sie Ihren Name ein:");
                    String name = player.next();
                    System.out.println("Was ist Ihre Lieblingsessen?");
                    String lieblingsessen = player.next();

                    Unterwegs p1 = new Unterwegs(name, lieblingsessen, stamina, money);
                    p1.Intro1();
                    p1.Kreuzung2();

                    if (Unterwegs.end1 == true) {
                        System.out.println("\n------------------------------------------------------------------\n");
                        System.out.println("Bitte wahlen Sie den zweiten Teil:");
                        System.out.println("1. Untersuchung (Huys Teil)");
                        System.out.println("2. Impfung (Irinas Teil)");
                        System.out.println("\n------------------------------------------------------------------\n");

                        do {
                            choice = player.nextInt();
                            switch (choice) {
                                case 1:
                                    String[] Symptome = {"Husten", "Kopfschmerzen", "Muskel- und Gelenkschmerzen", "Schlafstörungen", "Atemnot", "Sodbrennen", "Krampfanfälle"};
                                    /* Zwei array, die unterschiedliche Zufallzahl enthalten.
                                     *Damit Patienten zufallig  zwei unterschiedliche Symptome haben .
                                     */
                                    int array1[] = new int[7];
                                    for (int i = 0; i < 6; i++) {
                                        array1[i] = (int) (array1.length * Math.random());
                                    }
                                    int array2[] = new int[7];
                                    for (int i1 = 0; i1 < 6; i1++) {
                                        array2[i1] = (int) (array2.length * Math.random());
                                        while (array2[i1] == array1[i1]) {
                                            array2[i1] = (int) (array2.length * Math.random());
                                        }
                                    }
                                    /*Instanzerzeugung und  Methodenaufruf
                                     */
                                    Untersuchung huy = new Untersuchung("A", Symptome[array1[0]], Symptome[array2[0]]);
                                    huy.Diagnose();
                                    Untersuchung huy2 = new Untersuchung("B", Symptome[array1[1]], Symptome[array2[1]]);
                                    huy2.Diagnose();
                                    Untersuchung huy3 = new Untersuchung("C", Symptome[array1[2]], Symptome[array2[2]]);
                                    huy3.Diagnose();
                                    Untersuchung huy4 = new Untersuchung("D", Symptome[array1[3]], Symptome[array2[3]]);
                                    huy4.Diagnose();
                                    Untersuchung huy5 = new Untersuchung("E", Symptome[array1[4]], Symptome[array2[4]]);
                                    huy5.Diagnose();

                                    if (Untersuchung.sterben == true) {
                                        Flucht.Erdgeschloss();
                                    }
                                    break;
                                case 2:

                                    // HIER WIRD SCANNER ERZEUGT
                                    Scanner type = new Scanner(System.in);

                                    //SPIEL WILL WEITER GEHEN  BIS GAME = FALSE IST.
                                    boolean game = true;

                                    System.out.println("""
                                            ___________________
                                            |Period zwischen erste und zweite Impfung: >=1 monaten   |
                                            |Alter:                                    >12 Jahre alt |
                                            |Temperatur:                               36-37 grad    |
                                            |Herzschlag                                60<=pulse<=100|
                                            |____________________|
                                            """);

                                    //hier WÄHREND SPIEL MITHILFE (WHILE SCHLEIFE), WIRD NACH JEDER PATIENT GESAMTE MENGE DER PATIENTEN GEGEBEN
                                    while (game) {

                                        int numberOfPatient = 0;
                                        if (Impfung.testPatient(type)) {
                                            numberOfPatient++;
                                            System.out.println(numberOfPatient);
                                        }
                                        //ERSTE FRAGEN Q1
                                        System.out.println("Möchten sie weitere Patient bekommen? (a)ja \n" +
                                                " (b)nein");
                                        String q1 = type.nextLine();

                                        // IM GANZE CODE ICH HABE BENUTZT (.EQUALS) BEDEUTUNG ZU GEBEN, WEIL SOLCHE SCHREIBWEISE(q2=="yes" oder ==a;) ist falsch und erzeugt error.
                                        //Außerdem ich finde.equals mehr elegante weg so zu codieren.)
                                        //in diese genaue fall equalsIgnoreCase sagt computer (.equals)- bedeutung zu ignorieren.

                                        if (q1.equals("b")) {

                                            //ZWEITE FRAGE Q2
                                            String q2 = """
                                                    Möchten sie Pause nehmen?\s
                                                    (a)ja\s
                                                    (b)Nein
                                                    """;

                                            System.out.println(q2);
                                            String antwort2 = type.nextLine();

                                            //WENN SPIELER PAUSE NEHMEN MOCHTE HAT ER SCHNEIDER RETENTIVITY LISTE.
                                            if (antwort2.equals("a")) {


                                                // DRITTE Q3 FRAGE
                                                String q3 = """
                                                        Was Möchten sie machen?\s
                                                        (a)Caffe trinken\s
                                                        (b)spazieren gehen
                                                        (c)in kantine essen
                                                        """;

                                                System.out.println(q3);
                                                String antwort3 = type.nextLine();


                                                switch (antwort3) {
                                                    case "a" -> System.out.println("Sie fühlen sich weniger müde. es ist Zeit wieder zu arbeiten.");
                                                    case "b" -> System.out.println("Wetter draußen ist sehr warm und schon. Sonne Scheint. Sie gucken auf Handuhr und sehen das es noch 14:00 ist. Ihre Arbeitstag endet um 18:00 Uhr. Nach 20 minuten Spaziergang müssen sie schon wieder arbeiten.");
                                                    case "c" -> {
                                                        System.out.println("Sie gehen ins Kantine aber es ist überfordert. Sie haben zwei Möglichkeiten entweder warten und 15 minuten von ihre Pause verlieren oder draußen fast food kaufen\n");

                                                        //VIERTE FRAGE Q4
                                                        String q4 = """
                                                                Möchten sie:(a)warten
                                                                (b)fast food essen
                                                                """;
                                                        System.out.println(q4);
                                                        String antwort4 = type.nextLine();
                                                        if (antwort4.equals("a")) {
                                                            System.out.println("Sie waren 15 minuten im schlange und am ende sie waren mehr müde geworden und haben kalte Essen bekommen. Jetzt sollen sie  wieder arbeiten.");

                                                        } else if (antwort4.equals("b")) {
                                                            System.out.println("sie haben niemals solche leckere essen gegessen. fast food enthältst viel Fett und energie deshalb sie fühlen sich nicht mehr müde, sondern voll mit kraft!");
                                                            System.out.println("Jetzt gehen sie wieder arbeiten.");
                                                        }
                                                    }
                                                }


                                                //Wenn Spieler keine Pause nehmen möchte und auch kein mehr patient, Spiel endet.
                                            } else {
                                                game = false;
                                                System.out.println("Heute haben sie " + numberOfPatient + " Patienten geimpft UND DAS IST DIE ENDE VON ARBEITSTAG");
                                                type.close();
                                            }

                                        } else {
                                            game = true;
                                        }


                                    }
                                    break;
                                default:
                                    System.out.println("Ungültig! Bitte geben Sie eine gültige ganze Zahl ein");
                            }
                        } while (choice < 1 || choice > 2);
                    }
                    player.close();
                }
            }
            import java.util.Scanner;

            public class Main {
                static int stamina = 7;
                static double money = 20;

                public static void main(String[]args) {
                    int choice;
                    Scanner player = new Scanner(System.in);
                    System.out.println("Bitte geben Sie Ihren Name ein:");
                    String name = player.next();
                    System.out.println("Was ist Ihre Lieblingsessen?");
                    String lieblingsessen = player.next();

                    Unterwegs p1 = new Unterwegs(name,lieblingsessen,stamina,money);
                    p1.Intro1();
                    p1.Kreuzung2();

                    if(Unterwegs.end1==true) {
                        System.out.println("\n------------------------------------------------------------------\n");
                        System.out.println("Bitte wahlen Sie den zweiten Teil:");
                        System.out.println("1. Untersuchung (Huys Teil)");
                        System.out.println("2. Impfung (Irinas Teil)");
                        System.out.println("\n------------------------------------------------------------------\n");

                        do {
                            choice = player.nextInt();
                            switch (choice) {
                                case 1:
                                    String[] Symptome = {"Husten", "Kopfschmerzen", "Muskel- und Gelenkschmerzen", "Schlafstörungen","Atemnot","Sodbrennen","Krampfanfälle"};
                                    /* Zwei array, die unterschiedliche Zufallzahl enthalten.
                                     *Damit Patienten zufallig  zwei unterschiedliche Symptome haben .
                                     */
                                    int array1[]= new int[7];
                                    for(int i =0;i<6;i++) {
                                        array1[i]=(int)(array1.length*Math.random());
                                    }
                                    int array2[]= new int[7];
                                    for(int i1=0;i1<6;i1++) {
                                        array2[i1]=(int)(array2.length*Math.random());
                                        while(array2[i1]==array1[i1]) {
                                            array2[i1]= (int)(array2.length*Math.random());
                                        }
                                    }
                                    /*Instanzerzeugung und  Methodenaufruf
                                     */
                                    Untersuchung huy = new Untersuchung("A", Symptome[array1[0]],Symptome[array2[0]]);
                                    huy.Diagnose();
                                    Untersuchung huy2 = new Untersuchung("B",Symptome[array1[1]],Symptome[array2[1]]);
                                    huy2.Diagnose();
                                    Untersuchung huy3 = new Untersuchung("C",Symptome[array1[2]],Symptome[array2[2]]);
                                    huy3.Diagnose();
                                    Untersuchung huy4 = new Untersuchung("D",Symptome[array1[3]],Symptome[array2[3]]);
                                    huy4.Diagnose();
                                    Untersuchung huy5 = new Untersuchung("E",Symptome[array1[4]],Symptome[array2[4]]);
                                    huy5.Diagnose();

                                    if(Untersuchung.sterben==true) {
                                        Flucht.Erdgeschloss();
                                    }
                                    break;
                                case 2:

                                    // HIER WIRD SCANNER ERZEUGT
                                    Scanner type = new Scanner(System.in);

                                    //SPIEL WILL WEITER GEHEN  BIS GAME = FALSE IST.
                                    boolean game = true;

                                    System.out.println("""
			                ___________________
			                |Period zwischen erste und zweite Impfung: >=1 monaten   |
			                |Alter:                                    >12 Jahre alt |
			                |Temperatur:                               36-37 grad    |
			                |Herzschlag                                60<=pulse<=100|
			                |____________________|
			                """);

                                    //hier WÄHREND SPIEL MITHILFE (WHILE SCHLEIFE), WIRD NACH JEDER PATIENT GESAMTE MENGE DER PATIENTEN GEGEBEN
                                    while (game) {

                                        int numberOfPatient = 0;
                                        if (Impfung.testPatient(type)) {
                                            numberOfPatient++;
                                            System.out.println(numberOfPatient);
                                        }
                                        //ERSTE FRAGEN Q1
                                        System.out.println("Möchten sie weitere Patient bekommen? (a)ja \n" +
                                                " (b)nein");
                                        String q1 = type.nextLine();

                                        // IM GANZE CODE ICH HABE BENUTZT (.EQUALS) BEDEUTUNG ZU GEBEN, WEIL SOLCHE SCHREIBWEISE(q2=="yes" oder ==a;) ist falsch und erzeugt error.
                                        //Außerdem ich finde.equals mehr elegante weg so zu codieren.)
                                        //in diese genaue fall equalsIgnoreCase sagt computer (.equals)- bedeutung zu ignorieren.

                                        if (q1.equals("b")) {

                                            //ZWEITE FRAGE Q2
                                            String q2 = """
			                        Möchten sie Pause nehmen?\s
			                        (a)ja\s
			                        (b)Nein
			                        """;

                                            System.out.println(q2);
                                            String antwort2 = type.nextLine();

                                            //WENN SPIELER PAUSE NEHMEN MOCHTE HAT ER SCHNEIDER RETENTIVITY LISTE.
                                            if (antwort2.equals("a")) {


                                                // DRITTE Q3 FRAGE
                                                String q3 = """
			                            Was Möchten sie machen?\s
			                            (a)Caffe trinken\s
			                            (b)spazieren gehen
			                            (c)in kantine essen
			                            """;

                                                System.out.println(q3);
                                                String antwort3 = type.nextLine();


                                                switch (antwort3) {
                                                    case "a" -> System.out.println("Sie fühlen sich weniger müde. es ist Zeit wieder zu arbeiten.");
                                                    case "b" -> System.out.println("Wetter draußen ist sehr warm und schon. Sonne Scheint. Sie gucken auf Handuhr und sehen das es noch 14:00 ist. Ihre Arbeitstag endet um 18:00 Uhr. Nach 20 minuten Spaziergang müssen sie schon wieder arbeiten.");
                                                    case "c" -> {
                                                        System.out.println("Sie gehen ins Kantine aber es ist überfordert. Sie haben zwei Möglichkeiten entweder warten und 15 minuten von ihre Pause verlieren oder draußen fast food kaufen\n");

                                                        //VIERTE FRAGE Q4
                                                        String q4 = """
			                                    Möchten sie:(a)warten
			                                    (b)fast food essen
			                                    """;
                                                        System.out.println(q4);
                                                        String antwort4 = type.nextLine();
                                                        if (antwort4.equals("a")) {
                                                            System.out.println("Sie waren 15 minuten im schlange und am ende sie waren mehr müde geworden und haben kalte Essen bekommen. Jetzt sollen sie  wieder arbeiten.");

                                                        } else if (antwort4.equals("b")) {
                                                            System.out.println("sie haben niemals solche leckere essen gegessen. fast food enthältst viel Fett und energie deshalb sie fühlen sich nicht mehr müde, sondern voll mit kraft!");
                                                            System.out.println("Jetzt gehen sie wieder arbeiten.");
                                                        }
                                                    }
                                                }


                                                //Wenn Spieler keine Pause nehmen möchte und auch kein mehr patient, Spiel endet.
                                            } else {
                                                game = false;
                                                System.out.println("Heute haben sie " + numberOfPatient + " Patienten geimpft UND DAS IST DIE ENDE VON ARBEITSTAG");
                                                type.close();
                                            }

                                        }else {
                                            game=true;
                                        }


                                    }
                                    break;
                                default:
                                    System.out.println("Ungültig! Bitte geben Sie eine gültige ganze Zahl ein");
                            }
                        } while (choice<1||choice>2);
                    }
                    player.close();
                }
            }
        }
    }
}
