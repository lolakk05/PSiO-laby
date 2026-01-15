package backend;

import java.io.Serializable;

abstract public class Osoba implements Serializable {
    private String imie;
    private String nazwisko;
    private String email;
    private int wiek;
    private String pesel;

    public Osoba(String imie, String nazwisko, String email, int wiek, String pesel) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.wiek = wiek;
        this.pesel = pesel;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return "Imie: " + imie +
                " Nazwisko: " + nazwisko +
                " Email: " + email +
                " Wiek: " + wiek +
                " Pesel: " + pesel;
    }
}
