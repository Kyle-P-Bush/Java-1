import java.util.Scanner;

public class Game{

	private Player player;
	private Trainer trainer;

	//Dungeon
	//gameLoop --> navagate dungeon and combat initiation

	public Game(){
		setupPlayer();
		trainer = setupTrainer();
		trainer.earnMoney(Config.rand(70));
	}

	public void setupPlayer(){
		System.out.println("Welcome to Pkmon.");
		System.out.println("What would you like to name your character?");
		String name = Config.input.next();
		Pkmon pk = getPkmon();
		player = new Player(name, pk);
		player.earnMoney(100);
		player.addItem(Item.POTION);
	}

	private Pkmon getPkmon(){
		System.out.println("Which Pkmon do you want?");
		System.out.println("1. Burnmander\n2. Onionsaur\n3. Watertle\n4.Pecanchew");
		int choice = Config.nextInt(1,6);
		return getPkmon(choice);
	}

	private Pkmon getPkmon(int choice){
		if(choice==1) 
			return Pkmon.generatePkmon(Pkmon.BURNMANDER);
		else if(choice==2) 
			return Pkmon.generatePkmon(Pkmon.ONIONSAUR);
		else if(choice==3) 
			return Pkmon.generatePkmon(Pkmon.WATERTLE);
		else 
			return Pkmon.generatePkmon(Pkmon.PECANCHEW);
	}

	public Trainer setupTrainer(){
		return new Trainer("Trainer",Pkmon.generateRandom());
	}

	public Player getPlayer(){return player;}
	public Trainer getTrainer(){return trainer;}

}