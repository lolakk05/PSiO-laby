public class PracownikUczelni extends Pracownik {
    private String stanowisko;
    private String etat;

    public PracownikUczelni(String imie, String nazwisko, String email, int wiek, String pesel, String rola, StrategiaWynagrodzenie placa, String stanowisko, String etat) {
        super(imie, nazwisko, email, wiek, pesel, rola, placa);
        this.stanowisko = stanowisko;
        this.etat = etat;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public void setPlaca(int wybierz) {
        if(wybierz == 1) {
            this.placa = new StrategiaDomyslne();
        }
        else if(wybierz == 2) {
            this.placa = new StrategiaUczelni(this.stanowisko, this.etat);
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nStanowisko: " + stanowisko +
                " Etat: " + etat;
    }
}
