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
        int tmp = a;
        //wykonujemy pętle for b razy
        for(int i = 0; i < (b-1); i++) {
            a *= tmp;
        };
        //zwracamy a
        return a;
    }

    public static void main(String[] args) {
        System.out.println(NWD(10, 25));
        System.out.println(power(2, 8));
    }
}