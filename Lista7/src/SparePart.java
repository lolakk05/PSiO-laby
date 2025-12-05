import java.io.Serializable;

class SparePart implements Serializable {
    private String partName;
    private int quantity;

    public SparePart(String partName, int quantity) {
        this.partName = partName;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void usePart() {
        if(this.quantity > 0) {
            this.quantity--;
        }
    }

    public String getName() {
        return partName;
    }

    public String getInfo() {
        return "Nazwa: " + partName + " Ilość:" + quantity;
    }
}