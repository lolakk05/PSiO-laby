package backend;

import java.io.Serializable;

public class Mechanic extends TrackWorker implements Serializable {
    private String specialization;

    public Mechanic(String name, String team, int energy, String specialization) {
        super(name, team, energy);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void changeTyre(String tyre, Car car) {
        car.setTyre(tyre);
    }

    @Override
    public void performAction(Car car) {
        System.out.println(getName() + " naprawia auto");
        if(specialization.equals("Naprawa") && getEnergy() > 80) {
            car.setCondition(50);
        }
        else if(getEnergy() > 80) {
            car.setCondition(30);
        }
        else {
            car.setCondition(10);
        }
        this.setEnergy(getEnergy() - 20);
    }

    public void getInfo() {
        super.getInfo();
        System.out.println("Specjalizacja: " + specialization);
    }
}
