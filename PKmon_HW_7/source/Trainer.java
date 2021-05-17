
public class Trainer extends Character{

	public Trainer(String name, Pkmon pk){
		super(name);
		catchPkmon(pk);
		currentPkmon = pk;
	}

	public void catchPkmon(Pkmon pk){
		pkmon.add(pk);
	}

	public boolean takeTurn(Pkmon enemy){
		if(TPKO()){
			return true;
		}
		System.out.printf("It's %s's turn\n", getName());
		if(currentPkmon.isDead()){
			changePkmon();
		}
		attackPkmon(enemy);
		return false;
	}

	public void attackPkmon(Pkmon enemy){
		int choice = (Config.rand(currentPkmon.getNumberOfAtks()-1));
		enemy.takeDamage(Attack.attack(currentPkmon, currentPkmon.getAttack(choice-1)));//attack API
	}

	public void changePkmon(){
		for(int i=0; i<pkmon.size();i++){
			if(!pkmon.get(i).isDead()){
				currentPkmon = pkmon.get(i);
				break;
			}
		}
	}

}