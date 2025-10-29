import java.util.Random;

public class Zadanie4Cwiczenia {
    final static int wiersze = 5;

    public static void uzupelnij(int[][] tablica) {
        Random random = new Random();
        for(int i = 0; i < tablica.length; i++) {
            for(int j = 0; j < tablica[i].length; j++) {
                tablica[i][j] = random.nextInt(9);
                System.out.print(tablica[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int max(int[][] tablica) {
        int max = tablica[0][0];
        for(int i = 0; i < tablica.length; i++) {
            for(int j = 0; j < tablica[i].length; j++) {
                if(tablica[i][j] > max) {
                    max = tablica[i][j];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] Tab = new int[wiersze][];

        Tab[0] = new int[4];
        Tab[1] = new int[2];
        Tab[2] = new int[3];
        Tab[3] = new int[2];
        Tab[4] = new int[5];

        uzupelnij(Tab);
        System.out.println(max(Tab));
    }
}
