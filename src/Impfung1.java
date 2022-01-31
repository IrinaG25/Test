import java.util.Scanner;

public class Impfung1 {
    public static void main(String[] args) {
Impfung1 testpatient = new Impfung1();

        // HIER WIRD SCANNER ERZEUGT
        Scanner type = new Scanner(System.in);
        testpatient.testPatient(type);
        //SPIEL WILL WEITER GEHEN  BIS GAME = FALSE IST.
        boolean game = true;

        System.out.println("""
                _______
                |Period zwischen erste und zweite Impfung: >=1 monaten   |
                |Alter:                                    >12 Jahre alt |
                |Temperatur:                               36-37 grad    |
                |________________________________________________________|
                """);

//hier WÄHREND SPIEL MITHILFE (WHILE SCHLEIFE), WIRD NACH JEDER PATIENT GESAMTE MENGE DER PATIENTEN GEGEBEN
        while (game) {

            int numberOfPatient = 0;
            if (testPatient(type)) {
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

            }

        }


    }


    private static boolean testPatient(Scanner sc) {
        Patient patient = new Patient();

        System.out.println("_________");
        System.out.println("|Sie haben ein patient untersucht bitte geben sie die Daten von Patient ein:");
        System.out.println("|ist Patient schon einmal geimpft? : (write true or false)");


        boolean antwort = sc.nextBoolean();
        patient.setVaccinated(antwort);

        if (antwort) {

            System.out.println("|patient ist geimpft:");
            sc.nextLine();


        } else if (!antwort) {
            System.out.println("patient ist nicht geimpft");

        }


        // Wenn Person geimpft ist, dann code will spieler Daten von zwischenzeit einzugeben erfordern

        if (patient.getVaccinated()) {
            System.out.println("|Bitte geben sie zeit zwischen erste und zweite Impfung: ");

            while (true) {
                if (sc.hasNextInt()) {
                    patient.setPeriod(sc.nextInt());                                               // setPeriod bekommt als bedeutung was im scanner eingegeben ist.
                    System.out.println("|Zwischenzeit ist: " + patient.getPeriod() + " Monaten");  //getter returns changed variable
                    sc.nextLine();
                    break;

                } else {
                    System.out.println("Geben sie Daten als Integer");
                    sc.nextLine();
                }
            }
        }

// HIER FANGT GLEICHE CODE TEIL WIE OBEN FUR USER-VACCINATED, ÜBERPRÜFT es MIT HILFE IF; WHILE UND  hasNextInt OB SPIELER RICHTIGE INPUT EINGEGEBEN HAT
        System.out.println("|Bitte geben Sie Alter von Patient ein: ");

        while (true) {

            if (sc.hasNextInt()) {
                patient.setAge(sc.nextInt());                                           // setPeriod bekommt als bedeutung was im scanner eingegeben ist.
                System.out.println("|Patient ist: " + patient.getAge() + " Jahre Alt"); //getter returns changed variable
                sc.nextLine();
                break;

            } else {
                System.out.println("Geben sie Daten als integer ein");
                sc.nextLine();
            }

        }

        // HIER FANGT GLEICHE CODE TEIL WIE OBEN FUR USER-VACCINATED ES ÜBERPRÜFT MITHILFE IF; WHILE UND hasNextDouble OB SPIELER RICHTIGE INPUT EINGEGEBEN HAT
        // und dann ausfuhrt die bedingungen
        System.out.println("|please enter Patient's Temperature: ");

        while (true) {
            if (sc.hasNextDouble()) {
                patient.setTemperature((sc.nextDouble()));// setPeriod bekommt als bedeutung was im scanner eingegeben ist.
                System.out.println("|patient hat : " + patient.getTemperature() + "grad"); //getter returns changed variable
                sc.nextLine();
                break;//while will work till break stops it. break ist abhangig davon ob person boolean als input eingeben will.
            } else {
                System.out.println("Geben sie Daten entweder als ganze zahlen(36) oder als dezimalzahl(36.1)");
                sc.nextLine();
            }

        }


// HIER FANGT GLEICHE CODE TEIL WIE OBEN FUR USER-VACCINATED ES ÜBERPRÜFT MITHILFE IF; WHILE UND hasNextInt OB SPIELER RICHTIGE INPUT EINGEGEBEN HAT
        // und dann ausfuhrt die bedingungen

        System.out.println("|please enter Patient's pulse : ");
        while (true) {
            if (sc.hasNextInt()) {
                patient.setPulse(sc.nextInt());// setPeriod bekommt als bedeutung was im scanner eingegeben ist.
                System.out.println("Patient herzschlag ist: " + patient.getPulse() + "bpm");//getter returns changed variable
                sc.nextLine();
                break;
            } else {
                System.out.println("geben sie die Daten als ganze zahlen");
                sc.nextLine();
            }
        }


        // hier computer überprüft, ob mit eingegebenen Daten Patient geimpft werden kann. dies leuft im canBeVaccinated() method

        if (patient.canBeVaccinated()) {
            System.out.println("Patient kann geimpft werden.");
            System.out.println("Machen sie Impfung? (true or false)"); //hasNextBoolean
            while (true) {
                if (sc.hasNextBoolean()) {

                    boolean answer = sc.nextBoolean();
                    sc.nextLine();

                    if (answer) {
                        patient.setVaccinated(true);
                    }
                    return answer; //number++

                } else {
                    System.out.println("bitte geben sie (true\\false) ein");
                    sc.nextLine();// next boolean read od characters as
                }
            }
        } else {
            System.out.println("Patient can't be vaccinated.");

            return false;
        }
    }

    public void ending() {
        System.out.println("");
    }

    }




