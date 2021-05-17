
public class Item{

	//static 
	public static final String POTION = "potion";
	public static final String SUPER_POTION = "super potion";
	public static final String MAX_POTION = "max potion";
	public static final String HEALING = "healing";

	public static Item item(String name){
		switch(name){
			case POTION: return new Item(POTION, HEALING, 30, 100);
			case SUPER_POTION: return new Item(SUPER_POTION, HEALING, 100, 250);
			case MAX_POTION: return new Item(MAX_POTION, HEALING, 999, 700);
			default: return new Item("cream", HEALING,5,15);
		}
	}

	//instance
	public final String name;
	public final String type;
	public final int value;
	public final int cost;

	private Item(String name, String type, int value, int cost){
		this.name = name;
		this.type = type;
		this.value = value;
		this.cost = cost;
	}

	public String toString(){
		return name;
	}

}