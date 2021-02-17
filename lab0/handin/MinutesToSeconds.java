//Problem 2: MinutesToSeconds
//Kyle Bush

import java.util.Scanner;

public class MinutesToSeconds{
	public static void main(String[] args){

		Scanner inputScanner = new Scanner(System.in);
		System.out.print("Enter minutes: ");
		int min,sec;
		min = inputScanner.nextInt();
		sec = min*60;
		System.out.println("Seconds: "+sec);


	}
}