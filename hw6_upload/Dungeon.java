public class Dungeon{

	private Room courtyard;
	private Room bedroom;
	private Room entranceHall;
	private Room office;
	private Room bathroom;
	private Room dining;
	private Room kitchen;
	private Room backyard;

	public Dungeon(){

		this.courtyard = new Room("The Courtyard", "The entrance to the house is ahead.");
		this.bedroom = new Room("The Bedroom", "A large bed sits in the middle of the room.");
		this.entranceHall = new Room("The Entrance Hall", "A dark hall way that seems to lead everywhere in the house.");
		this.office = new Room("The Office", "There is a desk with a computer with a large bookshelf next to it.");
		this.bathroom = new Room("The Bathroom", "A very clean bathroom with. The sink faucet seems to be dripping still.");
		this.dining = new Room("The Dining Room", "A large table with chairs a round it. A large window sits behind the head chair.");
		this.kitchen = new Room("The Kitchen", "It seems pots and pans are everywhere.");
		this.backyard = new Room("Backyard", "A neat garden with seating in front of it.");
		this.setupRooms();
	}

	private void setupRooms(){

		courtyard.setExits(entranceHall, null, null, null); //good
		bedroom.setExits(bathroom, entranceHall, null, null); //good
		entranceHall.setExits(dining, office, bedroom, courtyard);
		office.setExits(null, null, entranceHall, null); //good
		bathroom.setExits(null, dining, null, bedroom); //good
		dining.setExits(backyard, kitchen, bathroom, entranceHall); //good
		kitchen.setExits(null, null, dining, null); //good
		backyard.setExits(null, null, null, dining); //good
	}

	public Room getStartingRoom(){

		return this.courtyard;
	}

	public String getDescription(){

		return "Welcome!";
	}

}