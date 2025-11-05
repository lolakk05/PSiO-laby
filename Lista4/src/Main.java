import java.util.Random;

class Array1d {
    private int[] tablica;

    Array1d() {
        int dlugosc = 10;
        tablica = new int[dlugosc];
        Random random = new Random();
        for(int i=0; i < tablica.length; i++) {
            tablica[i] = random.nextInt(10);
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

        srednia = (double) suma / tablica.length;

        return srednia;
    }

    public int[] getParzyste() {
        int parzyste = 0;
        for(int i = 0; i < tablica.length; i++) {
            if(tablica[i] % 2 == 0) {
                parzyste += 1;
            }
        }
        int[] Parzyste = new int[parzyste];
        int pozycja = 0;
        for(int i = 0; i < tablica.length; i++) {
            if(tablica[i] % 2 == 0) {
                Parzyste[pozycja] = tablica[i];
                pozycja += 1;
            }
        }
        return Parzyste;
    }

    public int[] getParzysteV2() {
        int[] Parzyste = new int[tablica.length];
        int pozycja = 0;

        for(int i = 0; i < Parzyste.length; i++) {
            Parzyste[i] = 1;
        }

        for(int i = 0; i < tablica.length; i++) {
            if(tablica[i] % 2 == 0) {
                Parzyste[pozycja] = tablica[i];
                pozycja += 1;
            }
        }
        return Parzyste;
    }
}

public class Main {
    public static void wyswietl(int[] tablica) {
        System.out.println("Wartości w tablicy:");
        int i = 0;
        while(i < tablica.length && tablica[i] % 2 == 0) {
            System.out.print(tablica[i] + " ");
            i += 1;
        }
    }

    public static void main(String[] args) {
        Array1d tablica = new Array1d();
        tablica.getWartosci();
        System.out.println("\nMaksymalna wartość: " + tablica.getMax());
        System.out.println("Wartość minimalna: " + tablica.getMin());
        System.out.println("Średnia wartość: " + tablica.getSrednia());
        int[] parzyste = tablica.getParzyste();
        int[] parzyste2 = tablica.getParzysteV2();
        wyswietl(parzyste);
        System.out.println();
        wyswietl(parzyste2);
    }
}