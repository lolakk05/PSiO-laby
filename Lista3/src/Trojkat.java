import java.util.Arrays;

public class Trojkat {
    Punkt wierzcholek1;
    Punkt wierzcholek2;
    Punkt wierzcholek3;

    public Trojkat() {
        wierzcholek1 = new Punkt(1, 0);
        wierzcholek2 = new Punkt(3, 1);
        wierzcholek3 = new Punkt(2, 5);
    }

    public Trojkat(int[] w1, int[] w2, int[] w3) {
        this.wierzcholek1 = new Punkt(w1[0], w1[1]);
        this.wierzcholek2 = new Punkt(w2[0], w2[1]);
        this.wierzcholek3 = new Punkt(w3[0], w3[1]);
    }

    public double getDlugosc(Punkt w1, Punkt w2) {
        return Math.sqrt(Math.pow(w1.getX() + w2.getX(), 2) + Math.pow(w1.getY() + w2.getY(), 2));
    }

    public double obwod(double podstawa, double bok1, double bok2) {
        return podstawa+bok1+bok2;
    }

    public double pole(double p, double a, double b, double c) {
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}

class Main {
    public static void main(String[] args) {
        int[] w1 = new int[] {1, 0};
        int[] w2 = new int[] {3, 1};
        int[] w3 = new int[] {2, 5};

        double podstawa;
        double bok1;
        double bok2;
        double obwod;
        double p;
        double pole;

        if(!Arrays.equals(w1, w2) && !Arrays.equals(w2, w3) && !Arrays.equals(w3, w1)) {
            Trojkat trojkat = new Trojkat(w1, w2, w3);

            podstawa = trojkat.getDlugosc(trojkat.wierzcholek1, trojkat.wierzcholek2);
            bok1 = trojkat.getDlugosc(trojkat.wierzcholek1, trojkat.wierzcholek3);
            bok2 = trojkat.getDlugosc(trojkat.wierzcholek2, trojkat.wierzcholek3);
            obwod = trojkat.obwod(podstawa, bok1, bok2);
            p = obwod / 2;
            pole = trojkat.pole(p, podstawa, bok1, bok2);

            System.out.printf("Wymiary trójkąta: Podstawa: %.2f Ramie1: %.2f Ramie2: %.2f \n", podstawa, bok1, bok2);
            System.out.printf("Obwód: %.2f \n", obwod);
            System.out.printf("Pole: %.2f \n", pole);
        }
        else {
            System.out.println("Nie można utworzyć trójkąta o takich punktach");
        }
    }
}
