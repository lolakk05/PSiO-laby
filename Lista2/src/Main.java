public class Main {
    public static double sin(double x, int n) {
        double suma = x;
        double tmp = x;
        int k = 1;

        while(k <= n) {
            tmp *= (-(x*x))/((2*k)*(2*k+1));
            suma += tmp;
            k++;
        }
        return suma;
    }

    public static double cos(double x, int n) {
        double suma = 1;
        double tmp = 1;

        for(int k = 1; k <= n; k++) {
            tmp *= (-(x*x)) / ((2*k-1) * (2*k));
            suma += tmp;
        }
        return suma;
    }

    public static void main(String[] args) {
        int x = 5;
        int k = 2;
        int wynikPotegowania = x;
        if(k == 0) {
            wynikPotegowania = 1;
        }
        else if(x == 0) {
            wynikPotegowania = 0;
        }
        else {
            for(int i = 1; i < k; i++) {
                wynikPotegowania *= x;
            }
        }
        System.out.println("Wynik potegowania " + x + " ^ " + k + ": " + wynikPotegowania);
        int silnia = 5;
        int wynikSilnia = 1;
        for(int i = 1; i <= 5; i++) {
            wynikSilnia *= i;
        }
        System.out.println("Silnia liczby " + silnia + ": " + wynikSilnia);
        System.out.println("Wartosc Sinus dla x=3 i n=5: " + sin(3, 5));
        System.out.println("Wartosc Cosinusa dla x=3 i n=5: " + cos(3, 5));
    }
}