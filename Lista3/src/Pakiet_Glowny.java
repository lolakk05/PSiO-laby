import Biblioteka.Biblioteka;

public class Pakiet_Glowny {
    public static void main(String[] args) {
        double x = 4;
        int n = 5;
        System.out.println("Sinus dla x wynosi: " + Biblioteka.sin(x, n));
        System.out.println("Cosinus dla x wynosi: " + Biblioteka.cos(x, n));
        System.out.println("Ex dla x wynosi: " + Biblioteka.ex(x, n));
    }
}
