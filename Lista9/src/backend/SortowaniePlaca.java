package backend;

import java.util.Comparator;

public class SortowaniePlaca implements Comparator<Osoba> {
    @Override
    public int compare(Osoba o1, Osoba o2) {
        double pensja1 = 0;
        double pensja2 = 0;

        if (o1 instanceof Pracownik) {
            pensja1 = ((Pracownik) o1).getPlaca();
        }
        if (o2 instanceof Pracownik) {
            pensja2 = ((Pracownik) o2).getPlaca();
        }
        return -1 * (Double.compare(pensja1, pensja2));
    }
}