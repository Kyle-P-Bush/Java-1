public class Room{
	
	private String name;
	private String description;
	private Room north;
	private Room east;
	private Room south;
	private Room west;

	public Room (String name, String description){
		this.name = name;
		this.description = description;
	}

	public void setExits(Room n, Room e, Room w, Room s){
		this.north = n;
		this.east = e;
		this.west = w;
		this.south = s;
		 
	}

	public String getExits(){
		StringBuilder exits = new StringBuilder();
		if(this.north != null){
			exits.append("[N]orth").append(": ").append(this.north.name).append("\n");
		}
		if(this.east != null){
			exits.append("[E]ast").append(": ").append(this.east.name).append("\n");
		}
		if(this.west != null){
			exits.append("[W]est").append(": ").append(this.west.name).append("\n");
		}
		if(this.south != null){
			exits.append("[S]outh").append(": ").append(this.south.name).append("\n");
		}

		return exits.toString();
	}

	public String getName(){
		return this.name;
	}

	public Room getNorth(){
		return north;
	}

	public Room getEast(){
		return east;
	}

	public Room getWest(){
		return west;
	}

	public Room getSouth(){
		return south;
	}

	

	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("["+this.name+"]");
		str.append("\n");
		str.append(this.description);
		str.append("\n");
		str.append(this.getExits());

		return str.toString();
	}

}