import java.lang.Thread;
import java.util.Random;
import java.util.Scanner;

//hosue all logic for the slots
public class GameLogic{
	
//Setup Variables
	private static Random dice;
	private static Scanner input = new Scanner(System.in);
	private static boolean skewed = true;

	//clear the screen
	public static void clear(){
		//clear the terminal string
		System.out.println("\033[H\033[2J");
	}

	//pause the program for a time 1000ms = 1sec
	public static void sleep(int millis){
		try{
			Thread.sleep(millis);
		}catch(Exception e){}
	}

	public static int getSkewedRandom(){
		dice = new Random();
		int max = dice.nextInt(6)+1;
		if(skewed){
			max = dice.nextInt(max)+1;
		}
		return max;
	}

	public static void getGraphics(int graphic){
		switch(graphic){
			case 1: {Graphics.printOne();}break;
			case 2: {Graphics.printTwo();}break;
			case 3: {Graphics.printThree();}break;
			case 4: {Graphics.printFour();}break;
			case 5: {Graphics.printBar();}break;
			case 6: {Graphics.printJackPot();}break;
		}
	}

	public static String getValue(int roll){
		if(roll == 1){
			return "One";
		}else if(roll ==2){
			return "Two";
		}else if(roll == 3){
			return "Three";
		}else if(roll == 4){
			return "Four";
		}else if(roll == 5){
			return "Bar";
		}
		return "Jackpot";
	}

	//provide the logic to spin a slot window
	public static int spin(){
		int time = 10;
		int selection = 1;
		int rotations = 30;
		for(int i = 0; i < rotations; i++){
			selection = getSkewedRandom();
			getGraphics(selection);
			sleep(time);
			if(i<rotations-1){
				clear();
			}
			time += i;
		}
		System.out.println("You got a " +getValue(selection)+"\nPress enter to continue."); 

		input.nextLine();
		clear();
		return selection;
	}

	//check if player has won or not and issue coins if any
	public static int checkSpins(int roll1, int roll2, int roll3){
		int winnings = winRules(roll1, roll2, roll3);
		if(roll1 == roll2 && roll2 == roll3){
			System.out.printf("Three %ss!\n", getValue(roll1));
			if(roll1==6){
				System.out.println("You win the jackpot of 15 coins!");
				return 15;
			}else{
				System.out.printf("You win %d coins.\n", roll1+1);
				return roll1+1;
			}
		}else if(winnings > 0){
			System.out.printf("You win %d coins.\n", roll1+1);
			return winnings;
		}
		System.out.printf("You rolled %s, %s, %s. Better luck next time!",
			getValue(roll1), getValue(roll2), getValue(roll3));
		return winnings;
	}

	public static int winRules(int roll1, int roll2, int roll3){
		if(roll3-roll2 ==1 && roll2 - roll1 ==1){
			return 1;
		}else if(roll1 - roll2 ==1 && roll2 - roll1 == 1){
			return 1;
		}else if (roll1 == 5 && roll2 == 6 && roll3 == 5){
			return 3;
		}else if(roll1 == 6 && roll2 == 5 && roll3==6){
			return 5;
		}
		return 0;
	}

	public static boolean playAgain(int purse){
		if(purse > 0){
			System.out.println("Would you like to play again? [Y/N]");
			String choice = input.nextLine();
			if(choice.equals("Y")||choice.equals("y")){
				return true;
			}
		}else{
			System.out.println("You are out of money. Come back when you have more.");
		}
		return false;
	}

}