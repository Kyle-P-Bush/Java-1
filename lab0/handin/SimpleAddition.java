//SimpleAddition
//Submitted by: Kyle Bush

import java.util.Scanner;

public class SimpleAddition{
	public static void main(String[] args){

		Scanner inputScanner = new Scanner(System.in);
		int var1, var2, out; // var 1 = first number; var2= second number; out = answer
		System.out.print("Enter the first number: ");
		var1 = inputScanner.nextInt();
		System.out.print("Enter the second number: ");
		var2= inputScanner.nextInt();
		out = var1 + var2;
		System.out.print("Answer = "+out);

	}
}