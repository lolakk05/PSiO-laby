public class MnozenieMacierzy {
    private int[][] a;
    private int[][] b;

    MnozenieMacierzy(int[][] macierz1, int[][] macierz2) {
        this.a = macierz1;
        this.b = macierz2;
    }

    public int[][] mnozenie() {
        int suma = 0;

        int wierszeA = a.length;
        int kolumnyA = a[0].length;

        int wierszeB = b.length;
        int kolumnyB = b[0].length;

        int[][] wynik = new int[wierszeA][kolumnyB];

        if(kolumnyA == wierszeB) {
            for(int i = 0; i < wierszeA; i++) {
                for(int j = 0; j < kolumnyB; j++) {
                    suma = 0;
                    for(int k = 0; k < kolumnyA; k++) {
                        suma += a[i][k] * b[k][j];
                    }
                    wynik[i][j] = suma;
                }
            }
        }
        else {
            System.out.println("Nie można mnożyć takich macierzy");
        }
        return wynik;
    }
}

class Main1 {
    public static void wyswietl(int[][] a) {
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] macierz1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] macierz2 = {{1, 2, 3, 4} , {5, 6, 7, 8}, {9, 0, 1, 2}};
        MnozenieMacierzy macierze = new MnozenieMacierzy(macierz1, macierz2);
        System.out.println("Macierz 1:");
        wyswietl(macierz1);;
        System.out.println();
        System.out.println("Macierz 2:");
        wyswietl(macierz2);
        System.out.println();
        System.out.println("Wynik:");
        int[][] wynik1 = macierze.mnozenie();
        wyswietl(wynik1);
    }
}
