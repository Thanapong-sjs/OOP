package lab13_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import lab13_1.Item;

public class Read{
	public static void main(String[] args) {
		ArrayList<Item> items = new ArrayList<>();
		File file = new File("sell.txt");
		try (Scanner fileScanner = new Scanner(file)){
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (line.isEmpty()) continue;
                String[] data = line.split(",");
                if (data.length == 3) {
                    String name = data[0].trim();
                    double price = Double.parseDouble(data[1].trim());
                    int quantity = Integer.parseInt(data[2].trim());
                    items.add(new Item(name, price, quantity));
                }
            }
        }
		catch(FileNotFoundException e){
            System.out.println("Error : File sell.txt not found.");
            return;
        }
        if (items.isEmpty()) {
            System.out.println("No item data found in sell.txt");
            return;
        }
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("--- Available Items ---");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getName());
        }
        System.out.print("\nSelect item number to check total sale: ");
        int choice = Integer.parseInt(inputScanner.nextLine());
        if (choice >= 1 && choice <= items.size()) {
            Item selectedItem = items.get(choice - 1);
            System.out.println("\n--- Item Sales Summary ---");
            System.out.println("Item Name: " + selectedItem.getName());
            System.out.println("Unit Price: $" + selectedItem.getPrice());
            System.out.println("Quantity Sold: " + selectedItem.getQuantity());
            System.out.println("Total Sales Amount: $" + selectedItem.getTotalPrice());
        }
        else{
            System.out.println("Invalid choice!");
        }
        inputScanner.close();
    }
}

