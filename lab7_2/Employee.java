package lab7_2;

public abstract class Employee {
    private String firstName;
    private String lastName;
    private String securityNumber;
    private Card card;

    public Employee(String firstName, String lastName, String securityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.securityNumber = securityNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSecurityNumber() {
        return securityNumber;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public abstract double earnings();
}