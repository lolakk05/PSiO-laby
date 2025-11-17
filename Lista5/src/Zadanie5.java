import java.util.Random;

public class Zadanie5 {
    public static int[] generateRow(int[] array) {
        Random rand = new Random();
        array = new int[rand.nextInt(1, 10)];
        for(int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(10);
        }
        return array;
    }

    public static void fill(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            matrix[i] = generateRow(matrix[i]);
        }
    }

    public static void display(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
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

    public static void sort(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            matrix[i] = sortRow(matrix[i]);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[10][];
        fill(matrix);
        display(matrix);
        System.out.println();
        sort(matrix);
        display(matrix);
    }
}
