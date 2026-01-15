package backend;

import java.io.*;
import java.util.ArrayList;

public class Repository {
    private ArrayList<Osoba> persons;

    public Repository() {
        this.persons = new ArrayList<>();

        wczytaj();
    }

    public void zapisz() {
        try(ObjectOutputStream so = new ObjectOutputStream(new FileOutputStream("osoby.ser"))) {
            so.writeInt(persons.size());
            for(Osoba osoba : persons) {
                so.writeObject(osoba);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void wczytaj() {
        try(ObjectInputStream is = new ObjectInputStream(new FileInputStream("osoby.ser"))) {
            int rozmiar = is.readInt();
            for(int i = 0; i < rozmiar; i++) {
                persons.add((Osoba) is.readObject());
            }
        }
        catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    };

    public ArrayList<Osoba> findAll() {
        return persons;
    }

    public void save(Osoba person) {
        persons.add(person);
        zapisz();
    }
}
