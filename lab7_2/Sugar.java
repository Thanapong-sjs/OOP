package lab7_2;

public class Sugar extends Product {
    private double weight;

    public Sugar(double price) {
        super("Suger", price);
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
