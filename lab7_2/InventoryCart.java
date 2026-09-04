package lab7_2;

public class InventoryCart {
    private Product[] products;
    private int count;

    public InventoryCart(int capacity) {
        products = new Product[capacity];
        count = 0;
    }

    public void add(Product p) {
        if (count < products.length) {
            products[count] = p;
            count++;
        }
    }

    public Product[] getProducts() {
        Product[] result = new Product[count];
        System.arraycopy(products, 0, result, 0, count);
        return result;
    }
}     