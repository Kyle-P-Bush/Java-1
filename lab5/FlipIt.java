//Submitted by Kyle Bush
//Problem 7 FlipIt

import java.util.Scanner;

public class FlipIt{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i = 0; i < n; i++){
            String line = input.nextLine();
            Scanner s = new Scanner(line);
            s.useDelimiter("");
            String flip = "";
            while(s.hasNext()){
                flip = s.next() + flip;
            }
            System.out.println(flip);
        }
    }
}