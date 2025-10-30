import java.util.Arrays;

public class MnozenieMacierzy {
    private int[][] a;
    private int[][] b;

    MnozenieMacierzy(int[][] macierz1, int[][] macierz2) {
        this.a = macierz1;
        this.b = macierz2;
    }

    public int[][] mnozenie() {
        int suma = 0;

        int[][] wynik = new int[a.length][b[0].length];

        if(a[0].length == b.length) {
            for(int i = 0; i < a.length; i++) {
                for(int j = 0; j < b[0].length; j++) {
                    suma = 0;
                    for(int k = 0; k < a[0].length; k++) {
                        suma += a[i][k] * b[k][j];
                        System.out.print(a[i][k] + " " + b[k][j] + " dalej ");
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

    public void wyswietl(int[][] a) {
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Main1 {
    public static void main(String[] args) {
        int[][] macierz1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] macierz2 = {{1, 2, 3, 4} , {5, 6, 7, 8}, {9, 0, 1, 2}};
        MnozenieMacierzy macierze = new MnozenieMacierzy(macierz1, macierz2);
        macierze.wyswietl(macierz1);;
        System.out.println();
        macierze.wyswietl(macierz2);
        System.out.println();
        int[][] wynik1 = macierze.mnozenie();
        System.out.println();
        macierze.wyswietl(wynik1);
    }
}
