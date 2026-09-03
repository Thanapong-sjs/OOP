public class SavingsAccount extends BaseAccount {

    private Card card;
    private FixedSalary employee;

    public SavingsAccount(FixedSalary employee) {
        this.employee = employee;
        this.card = employee.getCard();
    }

    public Card getCard() {
        return card;
    }

    public boolean deposit(double amount) {

        if (amount > 0) {
            balance += amount;
            return true;
        }

        return false;
    }

    public boolean withdraw(double amount) {

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }

        return false;
    }
}