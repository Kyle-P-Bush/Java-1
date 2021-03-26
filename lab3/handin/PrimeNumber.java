//Prime number Kyle Bush

import java.util.Scanner;

public class PrimeNumber{
	public static void main(String[] args){
		Scanner inputScanner = new Scanner(System.in);
		int cases = inputScanner.nextInt();

		for (int i = 0; i < cases; i++){
			int number = inputScanner.nextInt();
			inputScanner.nextLine();

			boolean isPrime = true;

			for (int factor = 2; factor*factor <= number; factor++){
				if (number % factor == 0){
					isPrime = false;
					break;
				}
			}
			System.out.println(isPrime);
		}
	}
}