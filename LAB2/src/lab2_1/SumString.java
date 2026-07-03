package lab2_1;

import java.util.Scanner;

public class SumString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please input the number : ");
		String value = sc.nextLine();

		int x = 0;
		System.out.print(value + " = ");
		for (int i = 0; i < value.length(); i++) {
			int y = value.charAt(i) - '0';
			x += y;
			System.out.print(y);

			if (i < value.length() - 1) {
				System.out.print(" + ");
			}
		}
		
		System.out.print(" = " + x);
		sc.close();
	}

}