public class Main{

	public static void main(String[] args){
		Game game = new Game();
		Combat.combat(game.getPlayer(),game.getTrainer());
	}

}