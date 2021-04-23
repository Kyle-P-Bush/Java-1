import java.util.Scanner;

public class AdventureGame{

	//SETTING INDEX FOR EACH ROOM
	public static final int COURTYARD = 0;
	public static final int BEDROOM = 1;
	public static final int ENTRANCE_HALL = 2;
	public static final int OFFICE = 3;
	public static final int BATHROOM = 4;
	public static final int DINING = 5;
	public static final int KITCHEN = 6;
	public static final int BACKYARD = 7;

	//CREATING DIRECTION INDICES
	public static final int NO_EXIT = -1;
	private static final int NORTH = 0;
	private static final int SOUTH = 1;
	private static final int EAST = 2;
	private static final int WEST = 3;

	//BASIC SETUP OF STARTING ROOM, DESCRIPTIONS ARRAY, AND A SCANNER
	private static int currentRoom = COURTYARD;
	private static String[] desc;
	private static Scanner input = new Scanner(System.in);
	//CREATING THE EXITS FOR EACH ROOM
	private static int[][] exits = {
		//{NORTH 0, SOUTH 1, EAST 2 , WEST 3}
		{ENTRANCE_HALL, NO_EXIT, NO_EXIT, NO_EXIT}, //COURTYARD
		{BATHROOM, NO_EXIT, ENTRANCE_HALL, NO_EXIT}, //BEDROOM
		{DINING, COURTYARD, OFFICE, BEDROOM}, //ENTRANCE_HALL
		{NO_EXIT, NO_EXIT, NO_EXIT, ENTRANCE_HALL}, //OFFICE
		{NO_EXIT, BEDROOM, DINING, NO_EXIT}, //BATHROOM
		{BACKYARD, ENTRANCE_HALL, KITCHEN, BATHROOM}, //DINING
		{NO_EXIT, NO_EXIT, NO_EXIT, DINING}, //KITCHEN
		{NO_EXIT, DINING, NO_EXIT, NO_EXIT} //BACKYARD
	};

	
	public static void main(String[] args){
			setupRooms();
			boolean isRunning = true;
			while(isRunning){
				isRunning = prompt();
			}
	}

	public static boolean prompt(){
		System.out.println(desc[currentRoom]);
		String choice = input.next();
		return changeRooms(choice);
	}

	public static boolean changeRooms(String direction){
		if(direction.equals("n")){
			changeRooms(NORTH);
		}
		else if(direction.equals("s")){
			changeRooms(SOUTH);
		}
		else if(direction.equals("e")){
			changeRooms(EAST);
		}
		else if(direction.equals("w")){
			changeRooms(WEST);
		}
		else if(direction.equals("q")){
			return false;
		}
		return true;
	}

	public static void changeRooms(int direction){
		if(exits[currentRoom][direction] != NO_EXIT){
			currentRoom = exits[currentRoom][direction];
		}
	}

	public static void setupRooms(){
		desc = new String[8];
		desc[COURTYARD] = "You are in the court yard. The entrance to the house is North." +
							"\n[n] for north \n[q] to quit";

		desc[BEDROOM] = "You are in the bedroom, the exits are North and East." + 
						"\n[n] for north \n[e] for east \n[q] to quit";

		desc[ENTRANCE_HALL] = "You are in the entrance hall. The exits are North, East, South, and West." +
								"\n[n] for north \n[s] for south \n[e] for east \n[w] for west \n[q] to quit";

		desc[OFFICE] = "You are in the office. The exit is to the West." +
						"\n[w] for west \n[q] to quit";

		desc[BATHROOM] = "You are in the bathroom. The exits are to the East and South." +
							" \n[s] for south \n[e] for east \n[q] to quit";

		desc[DINING] = "You are in the dining hall. The exits are North, East, South, and West." + 
						"\n[n] for north \n[s] for south \n[e] for east \n[w] for west \n[q] to quit";

		desc[KITCHEN] = "You are in the kitchen. The exit is to the West." + 
						"\n[w] for west \n[q] to quit";

		desc[BACKYARD] = "You are in the back yard. The Entrance back to the house is South." +
							"\n[s] for south\n[q] to quit";

	}
//"\n[n] for north \n[s] for south \n[e] for east \n[w] for west \n[q] to quit"
}
