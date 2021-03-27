import java.util.Scanner;

public class Main{

	//setup data
	private static int purse = 5;
	private static int slot1;
	private static int slot2;
	private static int slot3;

	public static void main(String[] args){
			gameloop();
	}

	public static void gameloop(){
		boolean isRunning=true;       //check for casino money or if they want to quit
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to Mega-slots. Press enter to spin!");
		input.nextLine();

		while(isRunning){
			purse--;
			slot1 = GameLogic.spin();
			slot2 = GameLogic.spin();
			slot3 = GameLogic.spin();
			purse += GameLogic.checkSpins(slot1, slot2, slot3);
			isRunning = GameLogic.playAgain(purse);
		}
	}



}