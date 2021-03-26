// Problem 6: FizzBuzz Submitted by Kyle Bush

import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num, cases;
        cases = in.nextInt();

        for(int i = 0;i<cases;i++){
            num = in.nextInt();
            if(num%3==0 && num%5==0){
                System.out.println("fizzbuzz");
            }
            else if(num%3==0){
                System.out.println("fizz");
            }
            else if(num%5==0){
                System.out.println("buzz");
            }
            else{
                System.out.println(num);
            }
        }

    }
}