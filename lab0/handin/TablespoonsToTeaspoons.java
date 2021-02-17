//Problem 3: TablespoonsToTeaspoons
//submitted by: Kyle Bush

import java.util.Scanner;

public class TablespoonsToTeaspoons{
	public static void main(String[] args){

		Scanner inputScanner = new Scanner(System.in);
		System.out.print("Enter Tablespoons: ");
		int ta, te; //ta = tablespoons; te = teaspoons
		ta = inputScanner.nextInt();
		te = ta*3;
		System.out.println("Teaspoons: "+te);

	}
}