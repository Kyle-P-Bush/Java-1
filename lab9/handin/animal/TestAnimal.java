public class TestAnimal{
	public static void main(String[] args){
		Animal[] zoo = { new Dog(), new Fish(), new Bird() };
		for (Animal animal : zoo){
			animal.move();
			System.out.println( animal.call() );
		}
	}
}