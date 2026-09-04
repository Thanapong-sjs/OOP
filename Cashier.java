package lab7_2;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cashier {
    private InventoryCart cart;
    private Card card;

    public void doPayment(InventoryCart cart, Card card) {
        this.cart = cart;
        this.card = card;
    }

    public void printReceipt() {
        if (cart == null || card == null) return;

        System.out.println("        CARD TYPE:" + card.type());
        System.out.println("    CARD NUMBER:" + card.getCardNumber());
        System.out.println();
        System.out.println("        Pumpkin Shop");
        System.out.println();

        Map<String, Integer> counts = new LinkedHashMap<>();
        Map<String, Double> prices = new LinkedHashMap<>();

        for (Product p : cart.getProducts()) {
            if (p != null) {
                String name = p.getName();
                counts.put(name, counts.getOrDefault(name, 0) + 1);
                prices.put(name, p.getPrice());
            }
        }

        double totalBeforeDiscount = 0;
        for (String name : counts.keySet()) {
            int qty = counts.get(name);
            double price = prices.get(name);
            totalBeforeDiscount += qty * price;
            System.out.printf("      %d x %-7s %.0f\n", qty, name, price);
        }

        System.out.println("-----------------------");
        System.out.println();
        System.out.printf("    CARD DISCOUNT %.1f %%\n", card.discount());
        System.out.println();

        double netTotal = totalBeforeDiscount * (1 - card.discount() / 100.0);
        System.out.printf("        Total     %.1f\n", netTotal);
        
        card.withdraw(netTotal);
    }
}
