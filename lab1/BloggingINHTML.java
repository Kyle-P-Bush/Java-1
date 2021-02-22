import java.util.Scanner;

public class BloggingINHTML{
	public static void main(String[] args){
		Scanner inputScanner = new Scanner(System.in);
		String header = inputScanner.nextLine();
		String image = inputScanner.nextLine();
		String postText = inputScanner.nextLine();
		String author = inputScanner.nextLine();
		String date = inputScanner.nextLine();

		String output = "<html><body><h1>";
		output = output + header; //(same thing as writing: output += header)
		output+="</h1><img src='"+image+"' />";
		output+="<p>"+postText+"</p>";
		output+="<small>By "+author+", "+date+"</small>";
		output+="</body></html>";
		System.out.println(output);

	}
}