public class FixedSalary {

    private String firstName;
    private String lastName;
    private String phone;
    private double salary;

    public FixedSalary(String firstName, String lastName,
                       String phone, double salary) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.salary = salary;
    }

    public Card getCard() {
        return new DebitCard("xxx-xxx-5555", "visa");
    }
}