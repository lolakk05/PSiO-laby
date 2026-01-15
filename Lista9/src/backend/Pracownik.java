package backend;

abstract public class Pracownik extends Osoba  {
    private String rola;
    protected StrategiaWynagrodzenie placa;

    public Pracownik(String imie, String nazwisko, String email, int wiek, String pesel, String rola, StrategiaWynagrodzenie placa) {
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

    public double getPlaca() {
        return placa.obliczWynagrodzenie();
    }

    public void setPlaca(int wybierz) {
        if(wybierz == 1) {
            this.placa = new StrategiaDomyslne();
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nRola: " + rola +
                " Płaca: " + placa.obliczWynagrodzenie();
    }
}
