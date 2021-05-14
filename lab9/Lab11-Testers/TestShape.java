public class TestShape{
	public static void main(String[] args){
		Shape[] shapes = new Shape[3];
		shapes[0] = new Circle(3);
		shapes[1] = new Rectangle(4,2);
		shapes[2] = new Triangle(1,2,3);

		for (Shape polygon : shapes){
			double area = polygon.area();
			double perimeter = polygon.perimeter();
			System.out.printf("%s: area: %.01f, perimeter: %.01f\n",polygon, area, perimeter);
		}
	}
}