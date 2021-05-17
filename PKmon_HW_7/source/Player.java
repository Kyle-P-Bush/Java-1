import java.util. ArrayList;

public class Player extends Character{

	private ArrayList<Item> items;

	public Player(String name, Pkmon pk){
		super(name);
		catchPkmon(pk);
		currentPkmon = pk;
		items = new ArrayList<Item>();
	}

	public void catchPkmon(Pkmon pk){
		System.out.printf("You have caught a %s. \n",pk.getBreed());
		super.pkmon.add(pk);
	}

	public boolean takeTurn(Pkmon pk){
		if(TPKO()){
			System.out.println("Your pkmon are in shambles. You have to run for it!");
			return true;
		}
		turnMenu();
		int choice = Config.nextInt(1,5);
		return turnAction(choice, pk);
	}

	public void attackPkmon(Pkmon enemy){
		System.out.println("Choose an attack.");
		System.out.println(currentPkmon.atkDisplay());
		int choice = Config.nextInt(1, currentPkmon.getNumberOfAtks() +1);
		enemy.takeDamage(Attack.attack(currentPkmon, currentPkmon.getAttack(choice-1))); //call to attack API
	}

	public void useItem(){
		displayItems();
		int choice = Config.nextInt(1,items.size() +1);
		currentPkmon.heal(items.get(choice-1).value); //get value from item
		System.out.printf("You heal %s for %d hp. \n", currentPkmon.getBreed(),items.get(choice-1).value);
		items.remove(choice-1);
	}

	public void changePkmon(){
		System.out.println("Which Pkmon will you set");
		displayPkmon();
		int choice = Config.nextInt(1, pkmon.size()+1);
		currentPkmon = pkmon.get(choice-1);
	}

	public void displayPkmon(){
		for(int i =0; i<pkmon.size();i++){
			System.out.printf("%s. %s %s\n",
				(i+1),pkmon.get(i).getBreed(),pkmon.get(i).displayHp());
		}
	}

	//inventory mehods
	public void displayItems(){
		String str = "";
		for(int i = 0; i <items.size(); i++){
			str += (i+1)+" "+items.get(i)+"\n";
		}
		System.out.println(str);
	}

	public void addItem(String name){
		items.add(Item.item(name));
	}

	//helper methods
	private boolean turnAction(int choice, Pkmon pk){
		switch(choice){
			case 1: {attackPkmon(pk);}break;
			case 2: {changePkmon();}break;
			case 3: {
				if(items.size()==0){
					System.out.println("You do not have any items!");
					takeTurn(pk);
				}
				useItem();
			}break;
			default: {return true;}
		}
		return false;
	}

	private void turnMenu(){
		System.out.println("\nIt's your turn");
		System.out.println("What would you like to do?");
		System.out.println("1. Attack 2. Pkmon");
		System.out.println("3. Item   4. Run\n");
	}

}