public class Car {
    private String name;
    private int condition;
    private String tyre;
    private int tyreCondtion;

    public Car(String name, int condition, String tyre) {
        this.name = name;
        this.condition = condition;
        this.tyre = tyre;
        this.tyreCondtion = 100;
    }

    public void setTyre(String tyre) {
        this.tyre = tyre;
        this.tyreCondtion = 100;
    }

    public String getTyre() {
        return this.tyre;
    }

    public void setTyreCondition(int tyreCondtion) {
        this.tyreCondtion -= tyreCondtion;
        if(this.tyreCondtion < 0) {
            this.tyreCondtion = 0;
        }
    }

    public int getTyreCondition() {
        return this.tyreCondtion;
    }

    public int getCondition() {
        return this.condition;
    }

    public void setCondition(int condition) {
        this.condition += condition;
        if(this.condition < 0) {
            this.condition = 0;
        }
        if(this.condition >= 100) {
            this.condition = 100;
        }
    }

    public void getInfo() {
        System.out.println("Name: " + this.name + " Stan: " + this.condition + " Opony: " + this.tyre + " Stan opon: " + this.tyreCondtion);
    }
}
