package lab13_2;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import lab13_1.Item;

public class main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Item> cart = new ArrayList<>();
		String ch;		
		do {
			System.out.print("Enter the name of the item : ");
			String name = sc.nextLine();			
			System.out.print("Enter the unit price : ");
			double price = Double.parseDouble(sc.nextLine());			
			System.out.print("Enter the quantity : ");
			int quantity = Integer.parseInt(sc.nextLine());			
			cart.add(new Item(name,price,quantity));
			System.out.print("Continue shopping (y/n) ? ");
			ch = sc.nextLine().trim();
		}
		while(ch.equalsIgnoreCase("y"));
		System.out.println("\nFinal Shopping Cart totals");
		double grandTotal = 0.0;
		for(Item item : cart) {
			double total = item.getTotalPrice();
			grandTotal += total;
			System.out.printf("%-15s $%-8.2f %-5d $%.2f%n",item.getName(),item.getPrice(),item.getQuantity(),total);
		}
		System.out.printf("Total $ Amount in Cart : $%.2f%n",grandTotal);
		try(PrintWriter writer = new PrintWriter(new FileWriter("sell.txt"))){
			for(Item item : cart){
				writer.println(item.getName() + " , " + item.getPrice() + " , " + item.getQuantity());
			}
			System.out.println("\nSuccessfully saved data to sell.txt");
		}
		catch(IOException e){
			System.out.println("An error occurred while writing to the file: " + e.getMessage());
		}
		sc.close();
	}
}
