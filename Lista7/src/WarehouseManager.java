import backend.Car;
import backend.TeamMember;

import java.io.Serializable;

class WarehouseManager extends TeamMember implements Serializable {
    private SparePart[] inventory;

    public WarehouseManager(String name, String team, SparePart[] inventory) {
        super(name, team);
        this.inventory = inventory;
    }

    @Override
    public void performAction(Car car) {}

    @Override
    public void performAction() {
        System.out.println("Magazynier podaje części: ");
        if(this.inventory.length > 0) {
            for(int i = 0; i < inventory.length; i++) {
                if(this.inventory[i].getQuantity() > 0) {
                    this.inventory[i].usePart();
                }
            }
        }
    }

    public void getStan() {
        System.out.println("--- Stan Magazynu ---");
        if (this.inventory != null) {
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] != null) {
                    System.out.println(" - " + inventory[i].getInfo());
                }
            }
        }
    }
}