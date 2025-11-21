import java.util.Arrays;

public class Student extends Osoba {
    private String kierunek;
    private int indeks;
    private Kursy[] kursy;

    public Student(String imie, String nazwisko, int wiek, String pesel, String kierunek, int indeks,Kursy[] kursy) {
        super(imie, nazwisko, wiek, pesel);
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

    public Kursy[] getKursy() {
        return kursy;
    }

    public void getInfo() {
        System.out.println(this.getImie());
        System.out.println(this.getNazwisko());
        System.out.println(this.getPesel());
        System.out.println(this.getWiek());
        System.out.println(this.getKierunek());
        System.out.println(this.getIndeks());
        System.out.println(Arrays.toString(this.getKursy()));
    }
}

class Main {
    public static void main(String[] args) {
        Kursy[] kursy = new Kursy[3];
        kursy[0] = new Kursy("Analiza Matematyczna", 1);
        kursy[1] = new Kursy("Fizyka 1.A", 2);
        kursy[2] = new Kursy("Logika dla Informatyków", 3);
        Student jakub = new Student("Jakub", "Dłużak", 19, "06302712345", "Informatyka Stosowana", 290238, kursy);

        jakub.getInfo();
    }
}
