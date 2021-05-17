public class Pkmon{
	
	//static elements here
	public static final String PECANCHEW = "pecanchew";
	public static final String ONIONSAUR = "onionsaur";
	public static final String BURNMANDER = "burnmander";
	public static final String WATERTLE = "watertle";

	//factory pattern
	public static Pkmon generatePkmon(String name){
		Pkmon pk;
		switch(name){
			case PECANCHEW: {pk = new Pecanchew();} break;
			case ONIONSAUR: {pk = new Onionsaur();} break;
			case BURNMANDER:{pk = new Burnmander();} break;
			default:{pk = new Watertle();}
		}
		return pk;
	}

	public static Pkmon generateRandom(){
		Pkmon pk;
		int choice = Config.rand(4);
		switch(choice){
			case 1: {pk = new Pecanchew();} break;
			case 2: {pk = new Onionsaur();} break;
			case 3:{pk = new Burnmander();} break;
			default:{pk = new Watertle();}
		}
		return pk;
	}

	//stat variables
	private String breed;
	private int maxHp;
	private int hp;
	private int atk;
	private int specialAtk;

	//leveling variables
	private int level;
	private int exp;
	private int levelUpHp;
	private int levelUpAtk;
	private int levelUpSpecial;

	//combat variables
	private String[] attacks;

	//setup logic
	protected Pkmon(String breed){
		this(breed, 100, 15, 15, 1);
	}

	protected Pkmon(String breed, int hp, int atk, int special){
		this(breed, hp, atk, special, 1);
	}

	private Pkmon(String breed, int hp, int atk, int special, int level){
		this.breed = breed;
		this.hp = hp;
		this.maxHp = hp;
		this.atk = atk;
		this.specialAtk = special;
		this.level = level;
		this.exp = 0;
	}

	protected void setupAttacks(String ... atks){
		attacks = new String[4];
		for(int i = 0; i<atks.length;i++){
			if(i>=4){
				break;
			}
			attacks[i] = atks[i];
		}
	}

	protected void setupLevelingValues(int hp, int atk, int spec){
		this.levelUpHp = hp;
		this.levelUpAtk = atk;
		this.levelUpSpecial = spec;
	}

	//combat logic
	public void takeDamage(int damage){
		if(damage >= hp){
			hp = 0;
		}else{
			hp -= damage;
		}
	}

	public void heal(int value){
		if((hp + value)>= maxHp){
			hp = maxHp;
		}else{
			hp += value;
		}
	}

	public boolean isDead(){
		return hp <=0;
	}

	public int expValue(){
		return level * 5;
	}

	public String getAttack(int index){
		return attacks[index];
	}

	public int getAtk(){return atk;}
	public int getSpecialAtk(){return specialAtk;}

	//leveling logic
	public void gainExp(int exp){
		this.exp += exp;
		int toNext = 0;
		for(int i = 0; i<=this.level; i++){
			toNext += i*50;
		}
		if(this.exp >= toNext){
			levelUp();
		}
	}

	private void levelUp(){
		level++;
		maxHp += levelUpHp;
		atk += levelUpAtk;
		specialAtk += levelUpSpecial;
		System.out.printf("%s has gain a level. %n%s is now level %d\n",breed, breed, level);
		System.out.println(this);
	}

	//display logic
	@Override
	public String toString(){
		return String.format("%s\nAtk[%d]\nSPECIAL[%d]\nLevel[%d]\n",displayHp(),atk,specialAtk,level);
	}

	public String atkDisplay(){
		String atks ="";
		for(int i=0; i<attacks.length;i++){
			atks +=""+(i+1)+ " " +attacks[i] +"\n";
		}
		return atks;
	}

	public int getNumberOfAtks(){
		int c = 0;
		for(int i = 0; i < attacks.length; i++){
			if(attacks[i]!=null){
				c++;
			}
		}
		return c;
	}

	public String displayHp(){
		return String.format("HP[%d/%d]",maxHp,hp);
	}

	public String getBreed(){return breed;}


}