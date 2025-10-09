public class Main {
    //parametry metody, typ int
    public static int NWD(int a, int b) {
        //dopóki a jest różne od b wykonujemy pętle while
        while(a != b) {
            //jeśli a jest większe od b od a odejmujemy b
            if(a > b) a -= b;
            //jesli nie to od b odejmujemy a
            else b -= a;
        };
        //zwracamy a
        return a;
    };

    public static int power(int a, int b) {
        //podstawiamy wartosc a do zmiennej pomocniczej
        if(a == 0) {
            return 1;
        }
        int tmp = a;
        //wykonujemy pętle for b razy
        for(int i = 1; i < b; i++) {
            a *= tmp;
        };
        //zwracamy a
        return a;
    };

    public static void main(String[] args) {
        //wypisywanie i zamkniecie linii
//        System.out.println(NWD(10, 25));
//        System.out.println(power(2, 8));
        int a = 5;
        int b = 2;
        int tmp = a;
        int wynik = 0;
        if(a == 0) {
            wynik = 1;
        }
        else {
            for(int i = 1; i<b; i++) {
                a *= tmp;
            }
            wynik = a;
        }
        System.out.println(wynik);
    }
}