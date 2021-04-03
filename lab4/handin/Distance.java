import java.util.Scanner;

public class Distance{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for (int i = 0; i < cases; i++){
			double x1 = input.nextDouble();
			double y1 = input.nextDouble();
			double x2 = input.nextDouble();
			double y2 = input.nextDouble();
			calculateDistance(x1, y1, x2, y2);
			//System.out.println(result);
		}
	}

	public static double calculateDistance(double x1, double y1, double x2, double y2){
		double dx, dy, dxdx, dydy, result;
		dx = x2 - x1;
		dy = y2 - y1;
		dxdx = dx * dx;
		dydy = dy * dy;
		result = Math.sqrt(dxdx + dydy);
		System.out.println(result);
		return result;
	}
}