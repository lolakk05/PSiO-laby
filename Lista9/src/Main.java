import java.io.*;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public void wyswietlMenu() {
        System.out.println("1 - wyswietlenie wszystkich");
        System.out.println("2 - szukanie po nazwisku, 3 - szukanie po dorobku");
        System.out.println("4 - szukanie po indeksie, 5 - szukanie po stanowisku");
        System.out.println("6 - szukanie po sredniej");
        System.out.println("7/8 - zapis danych/odczyt danych");
        System.out.println("9 - dodaj pracownika uczelni");
        System.out.println("10 - dodaj pracownika naukowego");
        System.out.println("11 - dodaj studenta");
        System.out.println("12 - wyjscie");
        System.out.print("Wybierz opcje: ");
    }

    public void zapisz(ArrayList<Osoba> osoby) {
        try(ObjectOutputStream so = new ObjectOutputStream(new FileOutputStream("osoby.ser"))) {
            so.writeObject(osoby);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Osoba> wczytaj() {
        ArrayList<Osoba> osoby = new ArrayList<>();
        try(ObjectInputStream is = new ObjectInputStream(new FileInputStream("osoby.ser"))) {
            osoby= (ArrayList<Osoba>) is.readObject();
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
        System.out.println("Pesel: ");
        String pesel = scanner.next();
        System.out.println("Rola:");
        String rola = scanner.next();
        System.out.println("Placa:");
        int placa = scanner.nextInt();
        System.out.println("Stanowisko:");
        String stanowisko = scanner.next();
        System.out.println("Etat:");
        String etat = scanner.next();
        System.out.println("Dodano pracownika");
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
        System.out.println("Pesel: ");
        String pesel = scanner.next();
        System.out.println("Rola:");
        String rola = scanner.next();
        System.out.println("Placa:");
        int placa = scanner.nextInt();
        System.out.println("Tytul:");
        String tytul = scanner.next();
        System.out.println("Dorobek:");
        int dorobek = scanner.nextInt();
        System.out.println("Wydzial: ");
        String wydzial = scanner.next();
        System.out.println("Katedra:");
        String katedra = scanner.next();
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

    public void main(String[] args) {
        ArrayList<Osoba> osoby = new ArrayList<Osoba>();
        Scanner scanner = new Scanner(System.in);

        wyswietlMenu();
        int input = scanner.nextInt();

        while(input < 12 && input > 0) {
            if(input == 1) {
                wyswietlWszystkich(osoby);
            }
            if(input == 2) {
                szukajPoNazwisku(osoby);
            }
            if(input == 3) {
                szukajPoDorobku(osoby);
            }
            if(input == 4) {
                szukajPoIndeksie(osoby);
            }
            if(input == 5) {
                szukajPoStanowisku(osoby);
            }
            if(input == 6) {
                szukajPoSredniej(osoby);
            }
            if(input == 7) {
                zapisz(osoby);
            }
            if(input == 8) {
                osoby = wczytaj();
            }
            if(input == 9) {
                dodajPracownikaUczelni(osoby);
            }
            if(input == 10) {
                dodajPracownikaNaukowego(osoby);
            }
            if(input == 11) {
                dodajStudenta(osoby);
            }
            wyswietlMenu();
            input = scanner.nextInt();
        }
    }
}
