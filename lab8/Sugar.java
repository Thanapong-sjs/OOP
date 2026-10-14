public class Sugar extends Product {
    private double weight;

    public Sugar(double price) {
        super("Suger", price); // สะกด "Suger" ให้ตรงตาม Receipt ในตัวอย่าง
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}