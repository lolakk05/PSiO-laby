import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Student extends Osoba {
    private String kierunek;
    private int indeks;
    private ArrayList<Kursy> kursy;

    public Student(String imie, String nazwisko, String email, int wiek, String pesel, String kierunek, int indeks,ArrayList<Kursy> kursy) {
        super(imie, nazwisko, email, wiek, pesel);
        this.kierunek = kierunek;
        this.indeks = indeks;
        this.kursy = kursy;
    }

    public String getKierunek() {
        return kierunek;
    }

    public void setKierunek(String kierunek) {
        this.kierunek = kierunek;
    }

    public int getIndeks() {
        return indeks;
    }

    public void setIndeks(int indeks) {
        this.indeks = indeks;
    }

    public double getSrednia() {
        int suma = 0;
        for(int i = 0; i < this.kursy.size(); i++) {
            suma += kursy.get(i).getOcena();
        }
        return (double) suma / this.kursy.size();
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nKierunek: " + kierunek +
                " Indeks: " + indeks +
                " Kursy: " + kursy +
                " Srednia ocen: " + getSrednia();
    }
}
