//srednia wartosc
//wyswietlenie stanu kazdego
public class Osoba {
    private String imie;
    private String nazwisko;
    private String pesel;
    private double pieniadze;
    private int wiek;

    public Osoba(String imie, String nazwisko, String pesel, double pieniadze, int wiek) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.pieniadze = pieniadze;
        this.wiek = wiek;
    }

    public double getPieniadze() {
        return pieniadze;
    }

    public static void main(String[] args) {
        Osoba john = new Osoba("John", "Pork", "21372137679", 2000000, 179);
        Osoba arasaka = new Osoba("Saburo", "Arasaka", "67676767671", 3000000, 300);
        Osoba wiktor = new Osoba("Wiktor", "Oziewicz", "05210697212", 10, 20);
    }
}
