public class PracownikNaukowy extends Pracownik {
    private String tytul;
    private int dorobek;
    private String wydzial;
    private String katedra;

    public PracownikNaukowy(String imie, String nazwisko, String email, int wiek, String pesel, String rola, int placa, String tytul,int dorobek, String wydzial, String katedra) {
        super(imie, nazwisko, email, wiek, pesel, rola, placa);
        this.tytul = tytul;
        this.dorobek = dorobek;
        this.wydzial = wydzial;
        this.katedra = katedra;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public int getDorobek() {
        return dorobek;
    }

    public void setDorobek(int dorobek) {
        this.dorobek = dorobek;
    }

    public String getWydzial() {
        return wydzial;
    }

    public void setWydzial(String wydzial) {
        this.wydzial = wydzial;
    }

    public String getKatedra() {
        return katedra;
    }

    public void setKatedra(String katedra) {
        this.katedra = katedra;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTytuł naukowy: " + tytul +
                " Dorobek: " + dorobek +
                " Wydział: " + wydzial  +
                " Katedra: " + katedra ;
    }
}