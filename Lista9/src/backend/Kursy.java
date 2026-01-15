import java.io.Serializable;

public class Kursy implements Serializable {
    private String nazwa;
    private int ects;
    private double ocena;

    Kursy(String nazwa, int ects, double ocena) {
        this.nazwa = nazwa;
        this.ects = ects;
        this.ocena = ocena;
    }

    public double getOcena() {
        return ocena;
    }

    @Override
    public String toString() {
        return " Nazwa: " + nazwa +
                " ECTS: " + ects;
    }
}