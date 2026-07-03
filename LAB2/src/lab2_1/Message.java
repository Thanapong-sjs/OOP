package lab2_1;

import java.util.Scanner;

public class Message {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter sentence: ");
	        String st = sc.nextLine();

	        st = st.replace("happy", "happy :)");
	        st = st.replace("sad", "sad :(");

	        System.out.println(st);

	        sc.close();
	    }
	
}
