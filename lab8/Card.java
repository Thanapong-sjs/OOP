public abstract class Card implements Withdrawable {
    public abstract String type();
    public abstract double discount();
    public abstract String getCardNumber();
}