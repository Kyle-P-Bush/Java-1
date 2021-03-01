//Problem 4 MinMaxSearchByValue
//submitted by: Kyle Bush
import java.util.Scanner;

public class MinMaxSearchByValue{
	public static void main(String[] args){
		//get number of test cases
		Scanner testCase = new Scanner(System.in);
		int cases = testCase.nextInt();
		testCase.nextLine();

		//for each test case
		for (int i = 0; i < cases; i++ ){
			//get the sequence of numbers and save it
			String sequence = testCase.nextLine();
			Scanner reader = new Scanner(sequence);
			//get the first number from sequence and save it as both max and min value
			int min = reader.nextInt();
			int max = min;
					//while there is a next numbers in sequence

			while (reader.hasNextInt() == true){
					//get the number from the sequence
					int number = reader.nextInt();
					//if that number is smaller than min than update min value
					if (number < min){
						min = number;
					}
					//if that number is bigger than update max value
					if (number > max){
						max = number;
					}
			}
			//output: print sequence , min, max, new line
			System.out.printf("%s\n%d\n%d\n\n", sequence, min, max );
		}
	}
}