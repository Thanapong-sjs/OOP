import java.util.ArrayList;

public class InventoryCart {

    private ArrayList<Product> products;
    private int capacity;

    public InventoryCart(int capacity) {
        this.capacity = capacity;
        products = new ArrayList<>();
    }

    public boolean add(Product product) {

        if (products.size() < capacity) {
            products.add(product);
            return true;
        }

        return false;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public double getTotal() {

        double total = 0;

        for (Product p : products) {
            total += p.getTotal();
        }

        return total;
    }
}