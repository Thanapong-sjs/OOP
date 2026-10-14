public class SavingsAccount extends BaseAccount {
    private double balance;
    public SavingsAccount(Employee employee) {
        String secNum = (employee != null) ? employee.getSecurityNumber() : "";
        String lastFourDigits = "0000";
        if (secNum != null && secNum.length() >= 4) {
            lastFourDigits = secNum.substring(secNum.length() - 4);
        }
        String cardNumber = "xxx-xxx-" + lastFourDigits;
        DebitCard debitCard = new DebitCard(cardNumber);
        if (employee != null) {
            employee.setCard(debitCard);
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
    public void printBalance() {
        System.out.println(balance);
    }
    public class DebitCard extends Card {
        private String cardNumber;
        public DebitCard(String cardNumber) {
            this.cardNumber = cardNumber;
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
            return SavingsAccount.this.withdraw(amount);
        }
    }
}
