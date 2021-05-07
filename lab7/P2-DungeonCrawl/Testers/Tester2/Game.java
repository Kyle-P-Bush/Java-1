import java.util.Scanner;

public class Game
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		Dungeon house = new Dungeon();
		Room current = house.getStartingRoom();
		boolean isOver = false;

		while (isOver == false)
		{
			System.out.print(current);
			System.out.println("[Q]uit.");
			String choice = input.next();
			Room next = null;
			switch( choice.toLowerCase() )
			{
				case "n": next = current.getNorth(); break;
				case "e": next = current.getEast();  break;
				case "w": next = current.getWest();  break;
				case "s": next = current.getSouth(); break;
				case "q": isOver = true;             break;
				default: System.out.println("invalid command.");
			}
			if (next != null) 
				current = next;		
		}
	}
}