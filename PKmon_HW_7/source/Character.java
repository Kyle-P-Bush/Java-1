import java.util.ArrayList;

public abstract class Character{

	private String name;
	private int money;
	protected ArrayList<Pkmon> pkmon;
	protected Pkmon currentPkmon;

	public Character(String name){
		this.name = name;
		pkmon = new ArrayList<Pkmon>();
	}

	public String getName(){return name;}
	public Pkmon getCurrentPkmon(){return currentPkmon;}
	public int getMoney(){return money;}
	public void earnMoney(int m){money+=m;}

	protected int spendMoney(int value){
		if(value >= money){
			System.out.println("You do not have enough money.");
			return 0;
		}else{
			System.out.printf("You spent %d monies.", value);
			money -= value;
			return value;
		}
	}

	protected boolean TPKO(){
		boolean allDead = true;
		for(int i = 0;i<pkmon.size();i++){
			allDead = allDead && pkmon.get(i).isDead();
		}
		return allDead;
	}

	public abstract void catchPkmon(Pkmon pk);
	public abstract boolean takeTurn(Pkmon pk);
	public abstract void attackPkmon(Pkmon pk);
	public abstract void changePkmon();

}