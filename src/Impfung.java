import java.util.Scanner;

public class Impfung {
    public static void main(String[] args) {

        // HIER WIRD SCANNER ERZEUGT
        Scanner type = new Scanner(System.in);

        //SPIEL WILL WEITER GEHEN  BIS GAME = FALSE IST.
        boolean game = true;

        System.out.println("_______________________________________\n"
                + "|Period               : >=1 monaten   |\n"
                + "|age:                   >12 Jahre alt |\n"
                + "|Temperatur:              36-37 grad  |\n"
                + "|guliscema:              60-100bpm    |\n"
                + "|wneva:              <120/80          |\n"
                + "|_____________________________________|\n");

//hier WÄHREND SPIEL MIT HILFE DER WHILE SCHLEIFE WIRD NACH JEDER PATIENT INSGESAMTE MENGE DER PATIENTEN GEGEBEN
        while (game) {

            int numberOfPatient = 0;
            if (testPatient(type)) {
                numberOfPatient++;
                System.out.println(numberOfPatient);

            }
//ERSTE FRAGEN Q1
            System.out.println("Möchten sie weitere Patiente bekommen? (ja oder nein)");
            String q1 = type.nextLine();

// IM GANZE CODE ICH HABE BENUTZT (.EQUALS) BEDEUTUNG ZU GEBEN, WEIL SOLCHE SCHREIBWEISE(q2=="yes" oder ==a;) ist falsch und erzeugt error.
            //Auserdem ich finde .equals mehr elegante weg so zu codieren.)
            //in diese genaue fall equalsIgnorCase sagt computer (.equals)- bedeutung zu ignorieren.

            if (!q1.equalsIgnoreCase("ja")) {

                //ZWEITE FRAGE Q2
                String q2 = "Möchten sie Pause nehmen? \n"
                        + "(a)ja \n(b)Nein\n";

                System.out.println(q2);
                String antwort2 = type.nextLine();

                //WENN SPIELER PAUSE NEHMEN MOCHTE HAT ER VERSCHIDENE AKTIVITETEN LISTE.
                if (antwort2.equals("a")) {


                    // DRITTE Q3 FRAGE
                    String q3 = "Was Möchten sie machen? \n"
                            + "(a)kaffe trinken \n(b)spazieren gehen\n (c)in kantine essen\n";

                    System.out.println(q3);
                    String antwort3 = type.nextLine();


                    if (antwort3.equals("a")) {

                        System.out.println("Sie fühlen sich weniger müde. es ist Zeit wieder zu arbeiten.");

                    } else if (antwort3.equals("b")) {
                        System.out.println("Wetter drausen ist sehr warm und schon. Sonne Scheint. Sie gucken auf Handuhr und sehen das es noch 14:00 ist. Ihre Arbeitstag endet um 18:00 Uhr. Nach 20 minuten Spaziergang mussen sie schon wieder arbeiten.");

                    } else if (antwort3.equals("c")) {
                        System.out.println("Sie gehen ins Kantine aber es ist überfordert. Sie haben zwei Möglichkeiten entweder warten und 15 minuten von ihre Pause verlieren oder drausen fast food kaufen\n");

                        //FIERTE FRAGE Q4
                        String q4 = "Möchten sie:"
                                + "(a)warten\n(b)fast food essen\n";

                        System.out.println(q4);
                        String antwort4 = type.nextLine();

                        if (antwort4.equals("a")) {
                            System.out.println("Sie waren 15 minuten im schlange und am ende sie waren mehr muede geworden und haben kalte Essen bekommen. Jetzt sollen sie  wieder arbeiten.");

                        } else if (antwort4.equals("b")) {
                            System.out.println("sie haben niemals solche leckere essen gegesen. fast food enthaelts viel Fett und energie deshalb sie fuhlen sich nicht mehr muede, sondern voll mit kraft!");
                            System.out.println("Jetzt gehen sie wieder arbeiten.");
                        }


                    }


                    //wenn spieler möchte keine pause nehmen und auch kein mehr patient spiel endet.
                } else {
                    game = false;
                    System.out.println("Heute haben sie " + numberOfPatient + " Patienten geimpft UND DAS IST DIEENDE VON ARBEITSTAG");
                    type.close();
                }

            }

        }


    }


    private static boolean testPatient(Scanner sc) {
        System.out.println("___________________________________________________________________________");
        System.out.println("|Sie haben ein patient untersucht bitte geben sie die Daten von Patient ein:");
        System.out.println("|is Patients vaccinated? : (write true or false)");
        boolean userVaccinated = false;


        while (true) {

            // SICHER ZU SEIN DAS SPIELER GIBT RICHTIGE INPUT EIN

            if (sc.hasNextBoolean()) {
                userVaccinated = sc.nextBoolean();
                System.out.println("|patient is vaccinated:");//+userVaccinated
                sc.nextLine();

                break;

            } else {
                System.out.println("Geben sie Daten als boolean");
                sc.nextLine(); // das benutze ich weil sc.hasNextBoolean hat altere input gelesen
            }

        }

        // Wenn Person ist geimpft dann code will spieler Daten von zwischenzeit  einzugeben erfordern
        int userPeriod = 0;

        if (userVaccinated) {
            System.out.println("|Bitte geben sie zeit zwischen erste und zweite Impfung: ");
            while (true) {
                if (sc.hasNextInt()) {
                    userPeriod = sc.nextInt();
                    System.out.println("|Zwischenzeit ist: " + userPeriod + " Monaten");
                    sc.nextLine();
                    break;

                } else {
                    System.out.println("Geben sie Daten als Integer");
                    sc.nextLine();
                }
            }
        }

// HIER FANGT GLEICHE CODE TEIL WIE OBEN FUR USERVACCINATED ES UBERPRÜFT MIT HILFE IF; WHILE UND  hasNextInt OB SPIELER RICHTIGE INPUT EINGEGEBEN HAT
        System.out.println("|Bitte geben Sie Alter von Patient ein: ");
        int userAge = 0;

        while (true) {
            if (sc.hasNextInt()) {
                userAge = sc.nextInt();
                System.out.println("|Patient ist: " + userAge + " Jahre Alt");
                sc.nextLine();
                break;
            } else {
                System.out.println("Geben sie Daten als integer ein");
                sc.nextLine();
            }

        }

// HIER FANGT GLEICHE CODE TEIL WIE OBEN FUR USERVACCINATED ES UBERPRÜFT MIT HILFE IF; WHILE UND  hasNextDouble OB SPIELER RICHTIGE INPUT EINGEGEBEN HAT
        // und dann ausfuhrt die bedingungen
        System.out.println("|please enter Pantient's Temperature: ");
        double userTemperature = 0.0;

        while (true) {
            if (sc.hasNextDouble()) {
                userTemperature = sc.nextDouble();
                System.out.println("|UserTemperature is: " + userTemperature);
                sc.nextLine();
                break;
            } else {
                System.out.println("Geben sie Daten als double ein");
                sc.nextLine();
            }

        }


// HIER FANGT     GLEICHE CODE TEIL WIE OBEN FUR USERVACCINATED ES UBERPRÜFT MIT HILFE IF; WHILE UND  hasNextInt OB SPIELER RICHTIGE INPUT EINGEGEBEN HAT
        // und dann ausfuhrt die bedingungen

        System.out.println("|please enter Patient's pulse : ");
        int userPulse = 0;
        while (true) {
            if (sc.hasNextInt()) {
                userPulse = sc.nextInt();

                System.out.println("Patient herzschlag ist: " + userPulse + "bpm");
                sc.nextLine();
                break;
            } else {
                System.out.println("geben sie die Daten ald Integer ein");
                sc.nextLine();
            }
        }


        System.out.println("|please enter Patient's pressure (Z.B: 110\\70) : ");
        String userPressure = sc.nextLine();
        System.out.println("|userPressure is: " + userPressure);

//mit instanzierung wird neue objekt erzeugt
        Patient patient = new Patient(userAge, userPeriod, userTemperature, userPulse,  userVaccinated);

        // hier computer überpruft ob mit eingegebenen Daten Patient geimpft werden kann. dies leuft im canBeVaccinated() method

        if (patient.canBeVaccinated()) {
            System.out.println("Patient can be vaccinated.");

            System.out.println("Machen sie Impfung? (true or false)");
            boolean answer = sc.nextBoolean();
            sc.nextLine();
            return answer;
        } else {
            System.out.println("Patient can't be vaccinated.");
            return false;
        }
    }
}
