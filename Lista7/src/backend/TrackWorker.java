import java.io.Serializable;

abstract public class TrackWorker extends TeamMember implements Serializable {
    private int energy;

    public TrackWorker(String name, String team, int energy) {
        super(name, team);
        this.energy = energy;
    }
    @Override
    public void performAction(Car car) {};

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy += energy;
        if(this.energy < 0){
            this.energy = 0;
        }
        if(this.energy > 100) {
            this.energy = 100;
        }
    }

    public void rest() {
        System.out.println(this.getName() + " odpoczywa...");
        this.setEnergy(100);
    }

    public void getInfo() {
        super.getInfo();
        System.out.println("Energia: " + this.energy);
    }
}
