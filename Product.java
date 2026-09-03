public abstract class Product {

    protected double price;
    protected int quantity;

    public Product(double price) {
        this.price = price;
        this.quantity = 1;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return price * quantity;
    }

    public abstract String getName();
}