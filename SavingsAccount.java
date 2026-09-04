package lab7_2;

public class SavingsAccount extends BaseAccount {
    private Card card;
    private double balance;

    public SavingsAccount(Employee employee) {
        String secNum = (employee != null) ? employee.getSecurityNumber() : "";
        String lastFourDigits = "0000";

        if (secNum != null && secNum.length() >= 4) {
            lastFourDigits = secNum.substring(secNum.length() - 4);
        }

        String cardNumber = "xxx-xxx-" + lastFourDigits;
        DebitCard debitCard = new DebitCard(cardNumber);
        debitCard.setAccount(this);
        this.card = debitCard;

        if (employee != null) {
            employee.setCard(this.card);
        }
    }

    @Override
    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        }
        return false;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public Card getCard() {
        return card;
    }
    public void printBalance() {
    	System.out.println(balance);
    }
}
