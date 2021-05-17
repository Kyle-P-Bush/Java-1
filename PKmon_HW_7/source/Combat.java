
public class Combat{

	public static void combat(Player player, Trainer trainer){
		boolean playerWins = true;
		boolean runAway = false;
		initialDisplay(player,trainer);
		while(!player.TPKO() && !trainer.TPKO()){
			displayHp(player, trainer);
			//players turn
			runAway = player.takeTurn(trainer.getCurrentPkmon());
			if(runAway){
				System.out.println("You got away safely");
				return;
			}
			if(checkTrainer(trainer, player)){
				continue;
			}
			//trainers turn
			trainer.takeTurn(player.getCurrentPkmon());
			if(checkPlayer(player))
				playerWins = false;
		}
		printWinnings(playerWins, player, trainer);
	}

	private static void initialDisplay(Player player, Trainer trainer){
		System.out.printf("%s want to fight\n",trainer.getName());
		Config.waitNext();
		System.out.printf("%s sends out %s. \n", trainer.getName(), trainer.getCurrentPkmon().getBreed());
		System.out.printf("Go %s", player.getCurrentPkmon().getBreed());
	}

	public static void displayHp(Player p, Trainer t){
		System.out.printf("\n%s's %s %s",t.getName(),t.getCurrentPkmon().getBreed(),t.getCurrentPkmon().displayHp());
		System.out.printf("\n%s's %s %s",p.getName(),p.getCurrentPkmon().getBreed(),p.getCurrentPkmon().displayHp());
	}

	private static boolean checkPlayer(Player player){
		if(player.getCurrentPkmon().isDead()){
			player.changePkmon();
		}
		if(player.TPKO()){
			return true;
		}
		return false;
	}

	private static boolean checkTrainer(Trainer trainer, Player player){
		if(trainer.getCurrentPkmon().isDead()){
			System.out.printf("%s has fallen\n %s gains %d exp\n",
				trainer.getCurrentPkmon().getBreed(),player.getCurrentPkmon().getBreed(),
				trainer.getCurrentPkmon().expValue());

				player.getCurrentPkmon().gainExp(trainer.getCurrentPkmon().expValue());
				trainer.changePkmon();
				if(trainer.currentPkmon.isDead())
					return true;
		}
		return false;
	}

	private static void printWinnings(boolean win, Player player, Trainer trainer){
		if(win){
			System.out.printf("You have defeated %s\n", trainer.getName());
			System.out.printf("You gained %d money", trainer.getMoney());
			player.earnMoney(trainer.getMoney());
		}else{
			System.out.println("You have been defeated!");
		}
	}
}