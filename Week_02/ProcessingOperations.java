import java.util.Scanner;

public class ProcessingOperations{
	

	public static void main(String[] arg){
		//arithmetic + - * / %
		int num1 = 3;
		int num2 = 2;
		System.out.println(num1 + num2); // add
		System.out.println(num1 - num2); // subtract
		System.out.println(num1 * num2); //multiply
		System.out.println(num1 / num2); //divide

		// Modulo section explanation (Checking how many times a number can be divided into another, and giving the remainder)
		System.out.println(1 % 2); // 1/2 = 0 R 1
		System.out.println(2 % 2); // 2/2 = 1 R 0
		System.out.println(3 % 2); // 3/2 = 1 R 1
		System.out.println(4 % 2); // 4/2 = 2 R 0

		// System.out.println("Enter a number");
		// num1 = input.nextInt();
		// System.out.println(num1%2==0);

		//relational values (input numeric, output boolean)
		System.out.println(num1 > num2);
		System.out.println(num1 < num2);
		System.out.println(num1 >= num2);
		System.out.println(num1 <= num2);

		//equality (input anything, output boolean)
		System.out.println(2 == num1); // == is used to check equality value, NOT to assign a variable
		System.out.println(2 != num1); // != means not equal

		//logical operators (input boolean, output also boolean)
		// &&  || !
		boolean bool1 = true;
		boolean bool2 = false;
		/*
		--------------------------------------------------------------------
		&& explanation

		true && true == true
		true && false == false
		false && true == false
		false && false == false
		--------------------------------------------------------------------
		|| explanation

		true || true == true
		true || false == true
		false || true == true
		false || false == false
		--------------------------------------------------------------------
		! explanation

		true == true
		!true == false
		example:
		!((3>4) && (5<7))  Basically inverses the value. The example works out to be false, but since the ! operator is in front, it makes it true.

		

		*/


		System.out.println("Hello"+ "num1"); // concatenation: combining too strings.



	}
}