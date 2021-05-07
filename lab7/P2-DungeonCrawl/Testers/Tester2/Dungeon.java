public class Dungeon
{
	private Room masterBed;
	private Room guestBed;
	private Room southHall;
	private Room northHall;
	private Room kitchen;
	private Room dining;
	private Room balcony;

	public Dungeon()
	{
		this.masterBed = new Room("Master Bedroom", "A large room with a big comfy bed in the middle.");
		this.guestBed = new Room("Guest Bedroom", "A small, cramped room with a writing desk in the corner, there are stacks of boxes in the corner.");
		this.southHall = new Room("South Hallway", "A long hallway with many old portaits hanging on the walls.");
		this.northHall = new Room("North Hallway", "A long hallway with a statue in the corner.");
		this.kitchen = new Room("Kitchen", "Pots simmering over the oven, the smell of soup fills the air.");
		this.dining = new Room("Dining", "A rectangular wood table with many place settings");
		this.balcony = new Room("Balcony", "Potted plants are placed in fron the concrete railings.");
		this.setupRooms();
	}

	private void setupRooms()
	{
		guestBed.setExits(masterBed, southHall, null, null);
		southHall.setExits(northHall, kitchen, guestBed, null);
		kitchen.setExits(dining, null, southHall, null);
		masterBed.setExits(null, northHall, null, guestBed);
		northHall.setExits(balcony, dining, masterBed, southHall);
		dining.setExits(null, null, northHall, kitchen);
		balcony.setExits(null, null, null, northHall);
	}

	public Room getStartingRoom()
	{
		return this.guestBed;
	}

	public String getDescription()
	{
		return "Welcome to the house of mundane adventure.";
	}

}