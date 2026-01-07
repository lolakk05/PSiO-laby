import java.io.*;

public class Main {
    public static void zapisz(TeamMember[] members) {
        try(ObjectOutputStream so = new ObjectOutputStream(new FileOutputStream("teammember.ser"))) {
            so.writeInt(members.length);
            for(int i = 0; i < members.length; i++) {
                so.writeObject(members[i]);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static TeamMember[] odczytaj() {
        try(ObjectInputStream is = new ObjectInputStream(new FileInputStream("teammember.ser"))) {
            TeamMember[] members = new TeamMember[3];
            for(int i = 0; i < members.length; i++) {
                members[i] = (TeamMember) is.readObject();
            }
            return members;
        }
        catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new TeamMember[0];
    }

    public static void main(String[] args) {
        SparePart[] parts = new SparePart[2];
        parts[0] = new SparePart("Przednie skrzydło", 3);
        parts[1] = new SparePart("Silnik Honda", 1);

        Car RB21 = new Car("RB21", 100, "Soft");
        Driver Max = new Driver("Max Verstappen", "Red Bull", 100, 1);
        Mechanic mechanic = new Mechanic("Jan Kowalski", "Red Bull", 100, "Naprawa");
        WarehouseManager logistyk = new WarehouseManager("Mietek Kowal", "Red Bull", parts);

        TeamMember[] members = new TeamMember[3];
        members[0] = Max;
        members[1] = mechanic;
        members[2] = logistyk;

        System.out.println("=== LISTA PRACOWNIKÓW ===");
        for (int i = 0; i < members.length; i++) {
            members[i].getInfo();
            System.out.println("-----------------");
        }

        System.out.println("\n=== SYMULACJA DZIAŁANIA ===");
        members[0].performAction(RB21);
        members[1].performAction(RB21);
        members[2].performAction();
        members[0].performAction(RB21);
        members[1].changeTyre("Medium", RB21);
        members[0].performAction(RB21);

//        Main.zapisz(members);
        TeamMember[] nowi = Main.odczytaj();

        System.out.println("\n\nNowi pracownicy");
        for (int i = 0; i < nowi.length; i++) {
            nowi[i].getInfo();
            System.out.println("-----------------");
        }
    }
}
