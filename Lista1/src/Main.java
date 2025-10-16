import java.util.Scanner;

public class Main {
    //parametry metody, typ int
    public static int NWD(int a, int b) {
        //dopóki a jest różne od b wykonujemy pętle while
        while(a != b) {
            //jeśli a jest większe od b od a odejmujemy b
            if(a > b) a -= b;
            //jesli nie to od b odejmujemy a
            else b -= a;
        }
        //zwracamy a
        return a;
    }

    public static int power(int a, int b) {
        //podstawiamy wartosc a do zmiennej pomocniczej
        if(a == 0) {
            return 1;
        }
        int tmp = a;
        //wykonujemy pętle for b razy
        for(int i = 1; i < b; i++) {
            a *= tmp;
        }
        //zwracamy a
        return a;
    }
    //sinus wersja uproszczona
    public static double sin(double x, int n) {
        double M = 1;
        double S = x;
        double L = x;
        int k = 1;
        while(k <= n) {
            L *= (x * x);
            M *= (2 * k) + (2 * k + 1);
            if(k % 2 == 0) {
                S += (L / M);
            }
            else {
                S -= (L / M);
            }
            k++;
        }
        return S;
    }

    //sinus wersja szybsza
    public static double sin2(double x, int n) {
        double S = x;
        double tmp = x;
        int k = 1;
        while(k <= n) {
            tmp *= (-(x*x))/((2*k)*(2*k+1));
            S += tmp;
            k++;
        }
        return S;
    }

    //cosinus
    public static double cos(double x, int n) {
        double S = 1;
        double L = 1;
        double M = 1;
        int k = 1;
        while(k <= n) {
            L *= (x*x);
            M *= (2 * k) * (2 * k + 1);
            if(k % 2 == 0) {
                S += L / M;
            }
            else {
                S -= L / M;
            }
            k++;
        }
        return S;
    }

    public static void main(String[] args) {
        //wypisywanie i zamkniecie linii
//        System.out.println(NWD(10, 25));
//        System.out.println(power(2, 8));
//        int a = 2;
//        int b = 3;
//        int tmp = a;
//        int wynik = 1;
//        for(int i = 1; i<=b; i++) {
//            wynik *= a;
//        }
//        int i = 1;
//        while(i <= b) {
//            wynik *= a;
//            i++;
//        }
//        System.out.println(wynik);
        Scanner a = new Scanner(System.in);
        Scanner b = new Scanner(System.in);
        System.out.println(NWD(a.nextInt(), b.nextInt()));
        System.out.println(power(5, 3));
        System.out.println(sin(0.5, 5));
        System.out.format("%.4f \n",sin(0.5, 5));
        System.out.println(sin2(1, 3));
        System.out.println(cos(0.2, 2));
    }
}