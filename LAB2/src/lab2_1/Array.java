package lab2_1;

import java.io.PrintStream;

public class Array {
	public static void main(String args[]) {
		final int SIZE = 5;
		
		int[][] grid = new int [SIZE][SIZE];
		for(int i = 0 ; i < SIZE ; i++) {
			for(int j = 0 ; j < SIZE ; j++) {
				grid[i][j] = i * SIZE + j + 1;
				
			}
		}
		System.out.println();
		for(int j = 0 ; j < SIZE ; j++) {
			for(int i = 0 ; i < SIZE ; i++) {
				System.out.printf("%3d",grid[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < SIZE; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < SIZE; j++) {
                    System.out.printf("%3d", grid[i][j]);
                }
            } else {
                for (int j = SIZE - 1; j >= 0; j--) {
                    System.out.printf("%3d", grid[i][j]);
                }
            }
            System.out.println();
	}
}
}