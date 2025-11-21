import java.util.Random;

public class Zadanie1 {
    public static int[] fill(int[] array) {
        int generated = 0;
        Random rand = new Random();
        boolean[] lookUpTable = new boolean[51];
        for(int i = 0; i < array.length; i++) {
            generated = rand.nextInt(1, 51);
            if(!lookUpTable[generated]) {
                array[i] = generated;
                lookUpTable[generated] = true;
            }
        }
        return array;
    }

    public static void display(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static int[] sum(int[] A, int[] B) {
        int[] array = new int[15];
        int[] lookUpTable = new int[51];
        int index = 0;
        for(int i = 0; i < A.length; i++) {
            if(lookUpTable[A[i]] == 0) {
                array[index] = A[i];
                lookUpTable[A[i]] = A[i];
                index += 1;
            }
            if(i < 5) {
                if(lookUpTable[B[i]] == 0) {
                    array[index] = B[i];
                    lookUpTable[B[i]] = A[i];
                    index += 1;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] A = new int[10];
        int[] B = new int[5];
        A =  fill(A);
        display(A);
        B = fill(B);
        display(B);
        int[] sum = sum(A, B);
        display(sum);
    }
}
