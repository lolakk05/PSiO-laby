class Prostokat {
    private int[] wierzcholek1 = new int[2];
    private int[] wierzcholek2 = new int[2];

    public Prostokat() {
        wierzcholek1 = new int[] {5, 2};
        wierzcholek2 = new int[] {2, 4};
    }

    public Prostokat(int[] wierzcholek1, int[] wierzcholek2) {
        if(wierzcholek1[0] == wierzcholek2[0] || wierzcholek1[1] == wierzcholek2[1]) {
            throw new IllegalArgumentException("Nie spełnia warunków zadania");
        }
        this.wierzcholek1 = wierzcholek1;
        this.wierzcholek2 = wierzcholek2;
    }

    public int getDlugosc() {
        return Math.abs(wierzcholek1[0] - wierzcholek2[0]);
    }

    public int getWysokosc() {
        return Math.abs(wierzcholek1[1] - wierzcholek2[1]);
    }

    public int pole(int dlugosc, int wysokosc) {
        return dlugosc * wysokosc;
    }

    public int obwod(int dlugosc, int wysokosc) {
        return (dlugosc * 2) + (wysokosc * 2);
    }

    public double przekatna(int dlugosc, int wysokosc) {
        return Math.sqrt(Math.pow(dlugosc, 2) + Math.pow(wysokosc, 2));
    }
}

public class Main {
    public static void main(String[] args) {
        Prostokat prostokat = new Prostokat(new int[]{1, 2}, new int[]{3, 4});
        int wysokosc = prostokat.getWysokosc();
        int dlugosc = prostokat.getDlugosc();
        int pole = prostokat.pole(dlugosc, wysokosc);
        int obwod = prostokat.obwod(dlugosc, wysokosc);
        double przekatna = prostokat.przekatna(dlugosc, wysokosc);
        System.out.printf("Wymiary prostokąta: Długość: %d Wysokość: %d \n", dlugosc, wysokosc);
        System.out.printf("Pole: %d \n", pole);
        System.out.printf("Obwód: %d \n", obwod);
        System.out.printf("Przekatna: %.2f", przekatna);
    }
}