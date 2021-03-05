//Kyle Bush
//Homework 2: Guessing your number
//Top:   An algorithm to guess a number, chosen by the user, between 0 and 100 (inclusive).

import java.util.Scanner; //Important a scanner to get user input


public class GuessingYourNumber{
	public static void main(String[] args){

		System.out.println("Think of a number between 1 and 100. I'll try to guess it!"); //Prompt user to think of a number.

		//intialize needed variables. Min and Max set the range, and guesses sets the number of guesses for the computer.
		
		int min = 1; // Setting the minimum value to guess from
		int max = 100; //Setting the maximum value to guess from
		int guesses = 0; // Setting the guesses counter to zero

		//

		boolean finished = false; // Creating a boolean for the while loop to utilize for user input to determine if the number has been guessed or not
		while (!finished) {    // Continue while loop until finished = true

			int guess = min + (int)(Math.random() * (max - min + 1)) ; //initial guess for the computer. This guesses a random number within the range. The range is reset in the while loop and it is no messed with during this formula.
			guesses++;  //incrementing the number of guesses counter

			//All five print outs below refer to the code putting out its guess, and informing the user what to do depending on if it is right, or needs to go higher or lower.
			System.out.println("Is your number: " + guess); 
			System.out.println("Type 1 if I got it right.");
			System.out.println("Type 2 if your number is greater than " + guess + ".");
			System.out.println("Type 3 if your number is less than " + guess + ".");
			System.out.println("Press enter when you are done.");

			Scanner scanner = new Scanner(System.in);  // Creating the input scanner
			String answer = scanner.nextLine();  //Creating a string to store the input in

			//Set of conditionals to tell the code if it is right, or to guess higher or lower, depending on user input.
			if(answer.equals("3")){
				max = guess - 1; //Since the user is saying the number is less than what the code guessed, this will reset the range to be just under the guessed value.
			}
			else if(answer.equals("2")){
				min = guess + 1; //Since the user is saying the number is greater than what the code guessed, this will reset the range to be just above the guessed value.
			}
			else if(answer.equals("1")){ //This else if ends the code by state the amount of guesses counted and setting the boolean expression to true.
				System.out.println("Ha! it took me " + guesses + " guesses to get it right. Thanks!");
				finished = true; 
			}
		} 
	}
}
