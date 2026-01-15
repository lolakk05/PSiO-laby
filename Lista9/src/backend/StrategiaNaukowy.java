package backend;

import java.io.Serializable;

public class StrategiaNaukowy implements StrategiaWynagrodzenie, Serializable {
    public String tytul;
    public int dorobek;

    public StrategiaNaukowy(String tytul, int dorobek){
        this.tytul=tytul;
        this.dorobek = dorobek;
    }

    @Override
    public double obliczWynagrodzenie() {
        double wynagrodzenie=0;
        if (this.tytul.equalsIgnoreCase("Doktor inżynier")) {
            wynagrodzenie = 7000;
        } else if (this.tytul.equalsIgnoreCase("Magister")) {
            wynagrodzenie = 5000;
        } else if (this.tytul.equalsIgnoreCase("Doktor habilitowany")) {
            wynagrodzenie = 8000;
        }
        wynagrodzenie+= (dorobek * 50);

        return wynagrodzenie;
    }
}
