public class Geometry{
	public static double getAreaRectangle(double width, double length){
		double result = length * width;
		return result;
	}

	public static double getAreaCircle(double radius){
		double result = Math.PI * (radius * radius);
		return result;
	}

	public static double getAreaTriangle(double base, double height){
		double result = 0.5 * (base * height);
		return result;
	}

	public static double getPerimeterRectangle(double width, double length){
		double result = 2 * (width + length);
		return result;
	}

	public static double getPerimeterCircle(double radius){
		double result = 2 * Math.PI * radius;
		return result;
	}
	public static double getPerimeterTriangle(double side1, double side2, double side3){
		double result = side1 + side2 + side3;
		return result;
	}
}