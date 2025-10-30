import java.util.Arrays;

public class MnozenieMacierzy {
    public static int[][] mnozenie(int[][] a, int[][] b) {
        int suma = 0;

        int[][] wynik = new int[a.length][b[0].length];

        if(a[0].length == b.length) {
            for(int i = 0; i < a.length; i++) {
                for(int j = 0; j < b[0].length; j++) {
                    suma = 0;
                    for(int k = 0; k < a[0].length; k++) {
                        suma += a[i][k] * b[k][j];
                        System.out.print(a[i][k] * b[k][j] + " ");
                    }
                    wynik[i][j] = suma;
                    System.out.println(wynik[i][j]);
                }
            }
        }
        else {
            System.out.println("Nie można mnożyć takich macierzy");
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
        wyswietl(macierz1);
        System.out.println();
        wyswietl(macierz2);
        System.out.println();
        int[][] wynik1 = mnozenie(macierz1, macierz2);
        System.out.println();
        wyswietl(wynik1);
//        int[][] macierz3 = {{1, 2, 3} , {4, 5 ,6}};
//        int[][] macierz4 = {{1, 2}, {3, 4}, {5, 6}};
//        int[][] wynik2 = mnozenie(macierz3, macierz4);
//        wyswietl(wynik2);

    }
}
