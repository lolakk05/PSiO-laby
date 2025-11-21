public class Kursy {
    private String nazwa;
    private int ects;

    Kursy(String nazwa, int ects) {
        this.nazwa = nazwa;
        this.ects = ects;
    }

    public String toString() {
        return this.nazwa + " ECTS: " + this.ects;
    }
}
