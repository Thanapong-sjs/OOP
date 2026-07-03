package lab2_1;

import java.util.Scanner;

public class Calender {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter started day: ");
	        int startDay = scanner.nextInt();
	        
	        System.out.println("Su Mo Tu We Th Fr Sa");

	        for (int i = 1; i < startDay; i++) {
	            System.out.print("   ");
	        }

	        for (int day = 1; day <= 31; day++) {
	            System.out.printf("%2d ", day);

	            if ((day + startDay - 1) % 7 == 0) {
	                System.out.println();
	            }
	        }

	        scanner.close();
	    }
}
	

