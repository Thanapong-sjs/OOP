package lab12;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        ArrayList<Item> cart = new ArrayList<>();
        String choice;
        do {
            System.out.print("Enter the name of the item: ");
            String name = scanner.nextLine();

            System.out.print("Enter the unit price: ");
            double price = scanner.nextDouble();

            System.out.print("Enter the quantity: ");
            int quantity = scanner.nextInt();
            
            scanner.nextLine(); 

            cart.add(new Item(name, price, quantity));

            System.out.print("Continue shopping (y/n)? ");
            choice = scanner.nextLine();
            System.out.println();
        } while (choice.equalsIgnoreCase("y"));

        System.out.println("Final Shopping Cart totals");
        double totalAmount = 0.0;

        for (Item item : cart) {
            double itemTotal = item.getTotalPrice();
            totalAmount += itemTotal;

            System.out.printf("%-15s $%-8.2f %-5d $%.2f\n", 
                item.getName(), 
                item.getPrice(), 
                item.getQuantity(), 
                itemTotal
            );
        }

        System.out.printf("Total $ Amount in Cart: $%.2f\n", totalAmount);

        scanner.close();
    }
}


