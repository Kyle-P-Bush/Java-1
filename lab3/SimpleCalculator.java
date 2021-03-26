//Problem 7: SimpleCalculator Submitted by Kyle Bush
import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {

        int num1;
        int num2;
        String operator;
        int result;

        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        int i = 0;
        while (i<cases){
        num1 = in.nextInt();
        operator = in.next();
        num2 = in.nextInt();

        switch(operator) {

                case "+" :
                    int add = num1 + num2;
                    System.out.println(add);
                    break;
                case "-" :
                    int sub = num1 - num2;
                    System.out.println(sub);
                    break;
                case "*" :
                    int mult = num1 * num2;
                    System.out.println(mult);
                    break;
                case "/" :
                    int div = num1 / num2;
                    System.out.println(div);
                    break;
                case "%" :
                    int mod = num1 % num2;
                    System.out.println(mod);
                    break;
                case "**" :
                	int exp = (int)Math.pow(num1, num2);
                	System.out.println(exp);
                }
                i++;
            }

        }

    }