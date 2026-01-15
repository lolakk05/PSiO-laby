package backend;

import java.io.*;

abstract public class TeamMember implements Serializable {
    private String name;
    private String team;

    public TeamMember(String name, String team) {
        this.name = name;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public abstract void performAction(Car car);

    public void getInfo() {
        System.out.println("Imie: " + this.name + " Drużyna: " + this.team);
    }

    //tutaj nie jestem pewien czy to jest dobrze
    public void performAction() {};
    public void changeTyre(String medium, Car car) {};
}
