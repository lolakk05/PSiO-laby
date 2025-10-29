import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class Array1d {
    private int[] tablica;

    Array1d() {
        tablica = new int[100];
        Random random = new Random();
        for(int i=0; i < 100; i++) {
            tablica[i] = random.nextInt(100);
        }
    }

    public void getWartosci() {
        System.out.println("Wartości w tablicy:");
        for(int i=0; i < tablica.length; i++) {
            System.out.print(tablica[i] + " ");
        }
    }

    public int getMax() {
        int max = 0;
        for(int i = 0; i < tablica.length; i++) {
            if(tablica[i] > max) {
                max = tablica[i];
            }
        }
        return max;
    }

    public int getMin() {
        int min = tablica[0];
        for(int i = 1; i < tablica.length; i++) {
            if(tablica[i] < min) {
                min = tablica[i];
            }
        }
        return min;
    }

    public double getSrednia() {
        double srednia = 0;
        int suma = 0;

        for(int i = 0; i < tablica.length; i++) {
            suma += tablica[i];
        }

        srednia = suma / tablica.length;

        return srednia;
    }

    public ArrayList<Integer> getParzyste() {
        ArrayList<Integer> parzyste = new ArrayList<>();

        for(int i = 0; i < tablica.length; i++) {
            if(tablica[i] % 2 == 0) {
                parzyste.add(tablica[i]);
            }
        }
        return parzyste;
    }
}

public class Main {
    public static void main(String[] args) {
        Array1d tablica = new Array1d();
        tablica.getWartosci();
        System.out.println("\nMaksymalna wartość: " + tablica.getMax());
        System.out.println("Wartość minimalna: " + tablica.getMin());
        System.out.println("Średnia wartość: " + tablica.getSrednia());
        System.out.println("Parzyste: " + tablica.getParzyste());
    }
}