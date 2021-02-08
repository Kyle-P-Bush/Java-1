import java.util.Scanner;

public class ControlOperations{

		public static void main(String[] args){
			Scanner input = new Scanner(System.in);
			boolean booleanExpression;

			System.out.println("Enter a number");
			int first = input.nextInt();

			System.out.println("Enter another number");
			int second = input.nextInt();

			booleanExpression = first > second;


			//selection statement: when if statement is true, the program will just follow the conditions under it. When the if statement is false, it will move to the else statements.
			if(booleanExpression == true){
				System.out.println("Ahh, you found me!!!");
			} else if (first < 5){
				System.out.println("You'll never find me. hahaha");
			} else {
				System.out.println("Go away!");
			}


		}
}