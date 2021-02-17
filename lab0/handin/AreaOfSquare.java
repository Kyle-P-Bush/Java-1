//Problem 1: AreaOfSquare
//Submitted by: Kyle Bush

import java.util.Scanner;

public class AreaOfSquare{
	public static void main(String[] args){
		Scanner inputScanner = new Scanner(System.in); // create scanner object and take input from the standard input.
		int length = inputScanner.nextInt(); //read integer value using inputScanner object
		int area = length * length; //formula to calculate area of the square
		System.out.println(area); //printing the output
	}
}