import java.util.Random;

public class Zadanie3 {
    public static void display(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static int[] generate() {
        Random rand = new Random();
        int[] array = new int[10];
        for(int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(10);
        }
        return array;
    }

    public static int compare(int[] array, int[] array1) {
        int dividers = 0;
        int counter = 0;
        for(int i = 0; i < array.length; i++) {
            dividers = 0;
            for(int j = 0; j < array1.length; j++) {
                if((array1[j] != 0) && array[i] % array1[j] == 0) {
                    dividers++;
                }
            }
            if(dividers >= 3) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] array = Zadanie3.generate();
        int[] array1 = Zadanie3.generate();
        display(array);
        display(array1);
        System.out.println(compare(array, array1));
    }
}
