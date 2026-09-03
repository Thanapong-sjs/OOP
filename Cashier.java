public class Cashier {

    private InventoryCart cart;
    private Card card;
    private double total;

    public Cashier() {
    }

    public void doPayment(InventoryCart cart, Card card) {

        this.cart = cart;
        this.card = card;

        double price = cart.getTotal();

        double discount =
            price * card.discount() / 100;

        total = price - discount;
    }

    public void printReceipt() {

        System.out.println("CARD TYPE:" + card.type());
        System.out.println(
            "CARD NUMBER:" + card.getCardNumber()
        );

        System.out.println();
        System.out.println("Pumpkin Shop");
        System.out.println();

        for (Product p : cart.getProducts()) {

            System.out.printf(
                "%d x %s      %.0f%n",
                p.getQuantity(),
                p.getName(),
                p.getPrice()
            );
        }

        System.out.println("----------------");

        System.out.printf(
            "CARD DISCOUNT %.1f %% %n",
            card.discount()
        );

        System.out.println();

        System.out.printf(
            "Total      %.1f%n",
            total
        );
    }
}