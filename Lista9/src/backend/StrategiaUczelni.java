package backend;

import java.io.Serializable;

public class StrategiaUczelni implements StrategiaWynagrodzenie, Serializable {
    public String etat;
    public String stanowisko;

    StrategiaUczelni(String etat, String stanowisko){
        this.etat = etat;
        this.stanowisko = stanowisko;
    }


    @Override
    public double obliczWynagrodzenie() {
        //domyslne wynagrodzenie dla innych stanowisk
        double wynagrodzenie = 4000;
        if (this.stanowisko.equalsIgnoreCase("Dozorca")) {
            wynagrodzenie = 5000;
        } else if (this.stanowisko.equalsIgnoreCase("Dziekanat")) {
            wynagrodzenie = 6000;
        }

        if (this.etat.equalsIgnoreCase("Pełny")) {
            wynagrodzenie *= 1;
        } else if (this.etat.equalsIgnoreCase("Połowa")) {
            wynagrodzenie *= 0.5;
        }
        return wynagrodzenie;
    }
}
