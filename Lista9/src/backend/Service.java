package backend;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Service {
    private Repository repository;

    private List<Observer> observers = new ArrayList<>();

    private Comparator<Osoba> currentComparator = null;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    private int activeStrategy = 2;

    public Service() {
        this.repository = new Repository();
    }

    public int getActiveStrategy() {
        return activeStrategy;
    }

    public ArrayList<Osoba> wyswietlWszystkich() {
        ArrayList<Osoba> result = new ArrayList<>(repository.findAll());
        if(currentComparator != null) {
            result.sort(currentComparator);
        }
        return result;
    };

    public ArrayList<Osoba> szukajPoNazwisku(String nazwisko) {
        ArrayList<Osoba> results = new ArrayList<>();
        for (Osoba osoba : repository.findAll()) {
            if (osoba.getNazwisko().equalsIgnoreCase(nazwisko)) {
                results.add(osoba);
            }
        }
        return results;
    }

    public ArrayList<Osoba> szukajPoIndeksie(int indeks) {
        ArrayList<Osoba> results = new ArrayList<>();
        for (Osoba osoba : repository.findAll()) {
            if (osoba instanceof Student) {
                Student student = (Student) osoba;
                if (student.getIndeks() == indeks) {
                    results.add(osoba);
                }
            }
        }
        return results;
    }

    public ArrayList<Osoba> szukajPoDorobku(int dorobek) {
        ArrayList<Osoba> results = new ArrayList<>();
        for (Osoba osoba : repository.findAll()) {
            if (osoba instanceof PracownikNaukowy) {
                PracownikNaukowy pracownik = (PracownikNaukowy) osoba;
                if (pracownik.getDorobek() > dorobek) {
                    results.add(osoba);
                }
            }
        }
        return results;
    }

    public ArrayList<Osoba> szukajPoStanowisku(String stanowisko) {
        ArrayList<Osoba> results = new ArrayList<>();
        for (Osoba osoba : repository.findAll()) {
            if (osoba instanceof PracownikUczelni) {
                PracownikUczelni pracownik = (PracownikUczelni) osoba;
                if (pracownik.getStanowisko().equalsIgnoreCase(stanowisko)) {
                    results.add(osoba);
                }
            }
        }
        return results;
    }

    public ArrayList<Osoba> szukajPoSredniej(double srednia) {
        ArrayList<Osoba> results = new ArrayList<>();
        for (Osoba osoba : repository.findAll()) {
            if (osoba instanceof Student) {
                Student student = (Student) osoba;
                if (student.getSrednia() > srednia) {
                    results.add(osoba);
                }
            }
        }
        return results;
    }

    public void dodajPracownikaUczelni(String imie, String nazwisko, String email, int wiek, String pesel, String rola, String stanowisko, String etat) {
        StrategiaWynagrodzenie placa = new StrategiaUczelni(etat, stanowisko);
        Osoba person = (new PracownikUczelni(imie, nazwisko, email, wiek, pesel, rola, placa, stanowisko, etat));
        repository.save(person);

        notifyObservers();
    }

    public void dodajPracownikaNaukowego(String imie, String nazwisko, String email, int wiek, String pesel, String rola, String tytul, int dorobek, String wydzial, String katedra) {
        StrategiaWynagrodzenie placa = new StrategiaNaukowy(tytul, dorobek);
        Osoba person = new PracownikNaukowy(imie, nazwisko, email, wiek, pesel, rola, placa, tytul, dorobek, wydzial, katedra);
        repository.save(person);

        notifyObservers();
    }

    public void dodajStudenta(String imie, String nazwisko, String email, int wiek, String pesel, String kierunek, int indeks, ArrayList<Kursy> kursy) {
        Osoba person = new Student(imie, nazwisko, email, wiek, pesel, kierunek, indeks, kursy);
        repository.save(person);

        notifyObservers();
    }

    public void ustawSortowanie(Comparator<Osoba> comparator) {
        this.currentComparator = comparator;
    }

    public void zmianaStrategii() {
        if (activeStrategy == 1) {
            activeStrategy= 2;
        } else {
            activeStrategy= 1;
        }

        for (Osoba osoba : repository.findAll()) {
            if (osoba instanceof Pracownik) {
                Pracownik p = (Pracownik) osoba;
                p.setPlaca(activeStrategy);
            }
        }
        repository.zapisz();

        notifyObservers();
    }
}
