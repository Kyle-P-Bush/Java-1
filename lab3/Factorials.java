// Problem 6: Factorials Submitted by Kyle Bush
import java.util.Scanner;

public class Factorials {

    public static long factorial(int n) {
        if(n == 0) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; ++i) {
            System.out.println(factorial(in.nextInt()));
        }
    }

}