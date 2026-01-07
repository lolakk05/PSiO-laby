import java.io.Serializable;

public class StrategiaDomyslne implements  StrategiaWynagrodzenie, Serializable {
    @Override
    public double obliczWynagrodzenie() {
        double wynagrodzenie = 5000;
        return wynagrodzenie;
    }
}
