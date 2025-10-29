import java.util.Arrays;

public class MnozenieMacierzy {
    public static int[][] mnozenie(int[][] a, int[][] b) {
        int wierszeA = a.length;
        int kolumnyA = a[0].length;
        int wierszeB = b.length;
        int kolumnyB = b[0].length;

        int suma = 0;

        if(kolumnyA != wierszeB) {
            throw new IllegalArgumentException("Nie można wymnożyc takich macierzy");
        }

        int[][] wynik = new int[wierszeA][kolumnyB];

        for(int i = 0; i < wierszeA; i++) {
            for(int j = 0; j < kolumnyB; j++) {
                suma = 0;
                for(int k = 0; k < kolumnyA; k++) {
                    suma += a[i][k] * b[k][j];
                }
                wynik[i][j] = suma;
            }
        }
        return wynik;
    }

    public static void wyswietl(int[][] a) {
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] macierz1 = {{1, 2}, {4, 5}};
        int[][] macierz2 = {{4, 5}, {1, 2}};
        int[][] wynik1 = mnozenie(macierz1, macierz2);
        wyswietl(wynik1);
        int[][] macierz3 = {{1, 2, 3} , {4, 5 ,6}};
        int[][] macierz4 = {{1, 2}, {3, 4}, {5, 6}};
        int[][] wynik2 = mnozenie(macierz3, macierz4);
        wyswietl(wynik2);

    }
}
