public class Patient {
    // allgemeine attribute sind deklariert ausserhalb methode
    private int age;
    private int period;
    private double temperature;
    private int pulse;
    private boolean isVaccinated;

    public Patient() {
    }

    // setter fur variable age
    void setAge(int a) {

        if (a < 0) {
            a = -a;

        }
        age = a;
    }

    int getAge() {
        return age;
    }


    // setter und getter fur variable period
    void setPeriod(int p) {
        if (p < 0) {
            p = -p;
        }
        period = p;
    }

    int getPeriod() {
        return period;
    }


    //setter und getter fur variable temperature
    void setTemperature(double t) {
        if (t < 0) {
            t = -t;
        }
        temperature = t;
    }

    double getTemperature() {
        return temperature;
    }


    //setter und getter fur variable pulse

    void setPulse(int p) {
        if (p < 0) {
            p = -p;
        }
        pulse = p;
    }

    int getPulse() {
        return pulse;

    }


    // setter und getter fur variable isVaccinated
    void setVaccinated(boolean v) {
        isVaccinated = v;
    }

    boolean getVaccinated() {
        return isVaccinated;
    }


    // boolean method canBeVaccinated wird gemacht die unterscheidet entweder patient darf geimpft werden oder nicht
    public boolean canBeVaccinated() {
        if (age >= 12 && isVaccinated && period >= 1 && period <= 6 && temperature >= 35 && temperature <= 37 && pulse >= 60 && pulse <= 100) {
            return true;

        } else
            return age >= 12 && !isVaccinated && temperature >= 35 && temperature <= 37 && pulse >= 60 && pulse <= 100;
        // falsch, wenn if Bedingungen nicht ausgeführt werden
    }

    //Konstruktor wird dargestellt.
    public Patient(int age, int period, double temperature, int pulse, boolean isVaccinated) {
        // statt verschiedene Bezeichner zu haben, habe ich "this." funktion benutzt die zeigt das erste age bedeutet, was ausserhalb geschweifte Klammer deklariert war.

        this.age = age;
        this.period = period;
        this.temperature = temperature;
        this.pulse = pulse;
        this.isVaccinated = isVaccinated;


    }

}

