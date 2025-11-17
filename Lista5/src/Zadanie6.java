import java.util.Random;

public class Zadanie6 {
    public static int[][] generate() {
        int[][] matrix = new int[3][3];
        Random rand = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = rand.nextInt(2);
            }
        }
        return matrix;
    }

    public static void display(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isReturnable(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][i] != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSymetric(int [][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isAntyReturnable(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAntySymetric(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(i != j) {
                    if(matrix[i][j] == 1 && matrix[j][i] == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = generate();
        display(matrix);
        System.out.println("Czy jest zwrotna: " +  isReturnable(matrix));
        System.out.println("Czy jest symetryczna: " + isSymetric(matrix));
        System.out.println("Czy jest przeciwzwrotna: " + isAntyReturnable(matrix));
        System.out.println("Czy jest przeciwsymetryczna: " + isAntySymetric(matrix));
    }
}
