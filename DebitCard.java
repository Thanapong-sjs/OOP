public class DebitCard extends Card {

    private String cardType;

    public DebitCard(String cardNumber, String cardType) {
        super(cardNumber);
        this.cardType = cardType;
    }

    public String type() {
        return cardType;
    }

    public double discount() {
        return 2.5;
    }

    public boolean withdraw(double amount) {
        return true;
    }
}