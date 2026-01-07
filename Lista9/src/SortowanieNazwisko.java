import java.util.Comparator;

public class SortowanieNazwisko implements Comparator<Osoba> {
    @Override
    public int compare(Osoba o1, Osoba o2) {
        return o1.getNazwisko().toLowerCase().charAt(0) - o2.getNazwisko().toLowerCase().charAt(0);
    }
}