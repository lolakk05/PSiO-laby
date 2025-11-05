package Studia;

public class Student {
    private String imie;
    private String nazwisko;
    private String kierunek;

    private Kursy kursy;

    Student(String imie, String nazwisko, String kierunek) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.kierunek = kierunek;
        this.kursy = new Kursy();
    }
}