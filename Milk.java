package lab7_2;

public class Milk extends Product {
    private double volumn;

    public Milk(double price) {
        super("Milk", price);
    }

    public void setVolumn(double volumn) {
        this.volumn = volumn;
    }
}
