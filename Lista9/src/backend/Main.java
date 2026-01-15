package backend;

import java.io.*;
import java.security.CodeSource;
import java.util.*;

public class Main {
    public void wyswietlMenu() {
        System.out.println("1 - wyswietlenie wszystkich");
        System.out.println("2 - szukanie po nazwisku, 3 - szukanie po dorobku");
        System.out.println("4 - szukanie po indeksie, 5 - szukanie po stanowisku");
        System.out.println("6 - szukanie po sredniej");
        System.out.println("7/8 - zapis danych/odczyt danych");
        System.out.println("9 - dodaj pracownika uczelni");
        System.out.println("10 - dodaj pracownika naukowego");
        System.out.println("11 - dodaj studenta");
        System.out.println("12 - sortowanie listy po placy");
        System.out.println("13 - sortowanie listy po nazwisku");
        System.out.println("14 - zmien strategie");
        System.out.println("0- wyjscie");
        System.out.print("Wybierz opcje: ");
    }

    public void zapisz(ArrayList<Osoba> osoby) {
        try(ObjectOutputStream so = new ObjectOutputStream(new FileOutputStream("osoby.ser"))) {
            so.writeInt(osoby.size());
            for(Osoba osoba : osoby) {
                so.writeObject(osoba);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Osoba> wczytaj() {
        ArrayList<Osoba> osoby = new ArrayList<>();
        try(ObjectInputStream is = new ObjectInputStream(new FileInputStream("osoby.ser"))) {
            int rozmiar = is.readInt();
            for(int i = 0; i < rozmiar; i++) {
                osoby.add((Osoba) is.readObject());
            }
        }
        catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return osoby;
    }

    public void wyswietlWszystkich(ArrayList<Osoba> osoby) {
        System.out.println("------------");
        for (Osoba osoba : osoby) {
            System.out.println(osoba);
            System.out.println("------------");
        }
    }

    public void szukajPoNazwisku(ArrayList<Osoba> osoby) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Wyszukaj po nazwisku: ");
        String nazwisko = scanner.nextLine();

        for(Osoba osoba : osoby) {
            if(osoba.getNazwisko().equalsIgnoreCase(nazwisko)) {
                System.out.println(osoba);
                System.out.println("------------");
            }
        }
    }

    public void szukajPoIndeksie(ArrayList<Osoba> osoby) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Wyszukaj po indeksie: ");
        int indeks =  scanner.nextInt();
        for(Osoba osoba : osoby) {
            if(osoba instanceof Student) {
                Student student = (Student) osoba;
                if(indeks == student.getIndeks()) {
                    System.out.println(osoba);
                    System.out.println("------------");
                }
            }
        }
    }

    public void szukajPoDorobku(ArrayList<Osoba> osoby) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Wyszukaj pracownika po dorobku: ");
        int dorobek = scanner.nextInt();

        for(Osoba osoba: osoby) {
            if(osoba instanceof PracownikNaukowy) {
                PracownikNaukowy pracownik = (PracownikNaukowy) osoba;

                if(pracownik.getDorobek() > dorobek) {
                    System.out.println(pracownik);
                    System.out.println("------------");
                }
            }
        }
    }

    public void szukajPoStanowisku(ArrayList<Osoba> osoby) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Wyszukaj pracownika po stanowisku pracy: ");
        String stanowisko = scanner.nextLine();

        for(Osoba osoba : osoby) {
            if(osoba instanceof PracownikUczelni) {
                PracownikUczelni pracownik =  (PracownikUczelni) osoba;
                if(pracownik.getStanowisko().equalsIgnoreCase(stanowisko)) {
                    System.out.println(pracownik);
                    System.out.println("------------");
                }
            }
        }
    }

    public void szukajPoSredniej(ArrayList<Osoba> osoby) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Wyszukaj studenta po średniej: ");
        double srednia = scanner.nextDouble();

        for(Osoba osoba : osoby) {
            if(osoba instanceof Student) {
                Student student = (Student) osoba;
                if(student.getSrednia() > srednia) {
                    System.out.println(osoba);
                }
            }
        }
    }

    public void dodajPracownikaUczelni(ArrayList<Osoba> osoby) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Imie: ");
        String imie =  scanner.next();
        System.out.println("Nazwisko:");
        String nazwisko =  scanner.next();
        System.out.println("Email:");
        String email = scanner.next();
        System.out.println("Wiek:");
        int wiek = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Pesel: ");
        String pesel = scanner.next();
        System.out.println("Rola:");
        String rola = scanner.next();
        System.out.println("Stanowisko:");
        String stanowisko = scanner.next();
        System.out.println("Etat:");
        String etat = scanner.next();
        System.out.println("Dodano pracownika");
        StrategiaWynagrodzenie placa = new StrategiaUczelni(etat, stanowisko);
        osoby.add(new PracownikUczelni(imie, nazwisko, email, wiek, pesel, rola, placa, stanowisko, etat));
    }

    public void dodajPracownikaNaukowego(ArrayList<Osoba> osoby) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Imie: ");
        String imie =  scanner.next();
        System.out.println("Nazwisko:");
        String nazwisko =  scanner.next();
        System.out.println("Email:");
        String email = scanner.next();
        System.out.println("Wiek:");
        int wiek = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Pesel: ");
        String pesel = scanner.nextLine();
        System.out.println("Rola:");
        String rola = scanner.nextLine();
        System.out.println("Tytul:");
        String tytul = scanner.nextLine();
        System.out.println("Dorobek:");
        int dorobek = scanner.nextInt();
        System.out.println("Wydzial: ");
        String wydzial = scanner.next();
        System.out.println("Katedra:");
        String katedra = scanner.next();
        StrategiaWynagrodzenie placa = new StrategiaNaukowy(tytul, dorobek);
        System.out.println("Dodano wykladowce");
        osoby.add(new PracownikNaukowy(imie, nazwisko, email, wiek, pesel, rola, placa, tytul, dorobek, wydzial, katedra));
    }

    private void dodajStudenta(ArrayList<Osoba> osoby) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Imie: ");
        String imie =  scanner.next();
        System.out.println("Nazwisko:");
        String nazwisko =  scanner.next();
        System.out.println("Email:");
        String email = scanner.next();
        System.out.println("Wiek:");
        int wiek = scanner.nextInt();
        System.out.println("Pesel: ");
        String pesel = scanner.next();
        System.out.println("Kierunek:");
        String kierunek = scanner.next();
        System.out.println("Indeks:");
        int indeks = scanner.nextInt();
        System.out.println("Ile kursów: ");
        int ileKursow =  scanner.nextInt();
        ArrayList<Kursy> kursy = new ArrayList<>();
        for(int i = 0; i < ileKursow; i++) {
            System.out.println("Nazwa kursu:");
            String nazwa = scanner.next();
            System.out.println("ECTS: ");
            int ects = scanner.nextInt();
            System.out.println("Ocena: ");
            int ocena = scanner.nextInt();
            kursy.add(new Kursy(nazwa, ects, ocena));
        }
        System.out.println("Dodano studenta");
        osoby.add(new Student(imie, nazwisko, email, wiek, pesel, kierunek, indeks, kursy));
    }

    public void zmianaStrategii(ArrayList<Osoba> osoby) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz imie: ");
        String imie =  scanner.next();
        System.out.println("Wybierz metode: ");
        int wybierz = scanner.nextInt();
        for(Osoba osoba : osoby) {
            if(osoba.getImie().equalsIgnoreCase(imie) && osoba instanceof Pracownik) {
                Pracownik osoba1 = (Pracownik) osoba;
                osoba1.setPlaca(wybierz);
            }
        }
    }

    public void main(String[] args) {
        ArrayList<Osoba> osoby = new ArrayList<Osoba>();
        Scanner scanner = new Scanner(System.in);

        wyswietlMenu();

        while (scanner.hasNext()) {
            int input = scanner.nextInt();
            scanner.nextLine();
            if (input != 0) {
                switch (input) {
                    case 1:
                        wyswietlWszystkich(osoby);
                        break;
                    case 2:
                        szukajPoNazwisku(osoby);
                        break;
                    case 3:
                        szukajPoDorobku(osoby);
                        break;
                    case 4:
                        szukajPoIndeksie(osoby);
                        break;
                    case 5:
                        szukajPoStanowisku(osoby);
                        break;
                    case 6:
                        szukajPoSredniej(osoby);
                        break;
                    case 7:
                        zapisz(osoby);
                        break;
                    case 8:
                        osoby = wczytaj();
                        break;
                    case 9:
                        dodajPracownikaUczelni(osoby);
                        break;
                    case 10:
                        dodajPracownikaNaukowego(osoby);
                        break;
                    case 11:
                        dodajStudenta(osoby);
                        break;
                    case 12:
                        osoby.sort(new SortowaniePlaca());
                        System.out.println("Posortowano po płacy");
                        break;
                    case 13:
                        osoby.sort(new SortowanieNazwisko());
                        System.out.println("Posortowano po nazwisku");
                        break;
                    case 14:
                        zmianaStrategii(osoby);
                        break;
                    default:
                        System.out.println("Brak wyboru / Nieprawidłowa opcja");
                        break;
                }
                wyswietlMenu();
            } else {
                break;
            }
        }
    }
}