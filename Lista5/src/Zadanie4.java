import java.util.Random;

public class Zadanie4 {
    public static int[][] generate() {
        Random rand = new Random();
        int[][] matrix = new int[10][20];
        for(int i  = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = rand.nextInt(10);
            }
        }
        return matrix;
    }

    public static int[] sortRow(int[] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = i; j < array.length; j++) {
                if(array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static int[][] sort(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            matrix[i] = sortRow(matrix[i]);
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

    public static int[][] transpose(int[][] matrix) {
        int[][] transpose = new int[matrix[0].length][matrix.length];
        for(int i = 0; i < transpose.length; i++) {
            for(int j = 0; j < transpose[i].length; j++) {
                transpose[i][j] = matrix[j][i];
            }
        }
        return transpose;
    }

    public static void main(String[] args) {
        int[][] matrix = generate();
        display(matrix);
        System.out.println();
        int[][] transpose = transpose(matrix);
        sort(transpose);
        display(transpose);
        System.out.println();
        transpose = transpose(transpose);
        display(transpose);
    }
}
