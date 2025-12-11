abstract public class Pracownik extends Osoba  {
    private String rola;
    private int placa;

    public Pracownik(String imie, String nazwisko, String email, int wiek, String pesel, String rola, int placa) {
        super(imie, nazwisko, email, wiek, pesel);
        this.rola = rola;
        this.placa = placa;
    }

    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }

    public int getPlaca() {
        return placa;
    }

    public void setPlaca(int placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nRola: " + rola +
                " Płaca: " + placa;
    }
}
