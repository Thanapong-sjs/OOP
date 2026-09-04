package lab7_2;

public class DebitCard extends Card {

    private String cardNumber;
    private SavingsAccount account;

    public DebitCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    public void setAccount(SavingsAccount account) {
        this.account = account;
    }
    
    @Override
    public String getCardNumber() {
        return cardNumber;
    }

    @Override
    public String type() {
        return "visa";
    }
    
    @Override
    public double discount() {
    	return 2.5;
    }

    @Override
    public boolean withdraw(double amount) {
        if (account != null) {
            return account.withdraw(amount);
        }
        return false;
    }
}
