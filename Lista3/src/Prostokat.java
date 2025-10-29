class Prostokat {
    private Punkt wierzcholek1;
    private Punkt wierzcholek2;

    public Prostokat() {
        wierzcholek1 = new Punkt(5, 1);
        wierzcholek2 = new Punkt(4, 2);
    }

    public Prostokat(int x1, int x2, int y1, int y2) {
//        if(wierzcholek1[0] == wierzcholek2[0] || wierzcholek1[1] == wierzcholek2[1]) {
//            throw new IllegalArgumentException("Nie spełnia warunków zadania");
//        }
        this.wierzcholek1 = new Punkt(x1, y1);
        this.wierzcholek2 = new Punkt(x2, y2);
    }

    public int getDlugosc() {
        return Math.abs(wierzcholek1.getX() - wierzcholek2.getX());
    }

    public int getWysokosc() {
        return Math.abs(wierzcholek1.getY() - wierzcholek2.getY());
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

    public static void main(String[] args) {
        int x1 = 0;
        int y1 = 5;
        int x2 = 0;
        int y2 = 6;

        if(x1 == x2 || y1 == y2) {
            System.out.println("Nie można utworzyć takiego obiektu");
        }
        else {
            Prostokat prostokat = new Prostokat(x1, x2, y1, y2);
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
}