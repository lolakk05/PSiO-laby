package Biblioteka;

public class Biblioteka {
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

    public static double ex(double x, int n) {
        double suma = 1;
        double k = 1;

        for(int i = 1; i <= n; i++) {
            k *= x / i;
            suma += k;
        }
        return suma;
    }
}
