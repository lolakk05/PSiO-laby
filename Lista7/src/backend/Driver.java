import java.io.Serializable;

public class Driver extends TrackWorker implements Serializable {
    private int startingNumber;

    public Driver(String name, String team, int energy, int startingNumber) {
        super(name, team, energy);
        this.startingNumber = startingNumber;
    }

    public int getStartingNumber() {
        return startingNumber;
    }

    @Override
    public void performAction(Car car) {
        if(car.getTyreCondition() > 0 && car.getCondition() > 0 && getEnergy() > 0) {
            System.out.println("Kierowca " + this.getStartingNumber() + " wyjeżdza na tor");
            int multiplier = 1;
            if(car.getTyre().equals("Soft")) {
                multiplier = 3;
            }
            else if(car.getTyre().equals("Medium")) {
                multiplier = 2;
            }

            if(this.getEnergy() > 60) {
                car.setTyreCondition(multiplier*10);
                car.setCondition(-20);
            }
            else {
                car.setTyreCondition(multiplier*20);
                car.setCondition(-30);
            }
            setEnergy(-20);
            System.out.println("Opony: " + car.getTyre() + " Zużycie opon: " + car.getTyreCondition() + " Zużycie auta: " + car.getCondition());
            System.out.println("Kondycja kierowcy: " + getEnergy());
        }
        else {
            System.out.println("Stan auta/kierowcy nie pozwala na wyjazd");
        }
    }

    public void getInfo() {
        super.getInfo();
        System.out.println("Numer startowy: " + this.startingNumber);
    }
}
