public class Attack{

	private static final double VERY_WEAK = 0.5;
	private static final double WEAK = 0.8;
	private static final double NORMAL = 1;
	private static final double STRONG = 1.25;
	private static final double VERY_STRONG = 1.5;
	private static final double EPIC = 2;

	public static int attack(Pkmon pk, String atkName){
		System.out.printf("%s uses %s\n", pk.getBreed(),atkName);
		int dam = directory(atkName,pk.getSpecialAtk(),pk.getAtk());
		System.out.printf("%s deals %d damage. \n", pk.getBreed(), dam);
		Config.waitNext();
		return dam;
	}

	public static int directory(String name, int special, int atk){
		switch(name){
			case "Scratch": return scratch(atk);
			case "Fire Spit": return fireSpit(special);
			case "Onion Breath": return onionBreath(special);
			case "Tackle": return tackle(atk);
			case "Electric Boogie": return electricBoogie(special);
			case "Bite": return bite(atk);
			case "Water Pistol": return waterPistol(special);
			case "Super Mega Ultralord Beam": return superMegaUltralordBeam(special);
		}
		return 0;
	}

	public static int scratch(int atk){
		return (int)(atk*WEAK);
	}

	public static int tackle(int atk){
		return (int)(atk*WEAK);
	}

	public static int bite(int atk){
		return (int)(atk*WEAK);
	}

	public static int fireSpit(int atk){
		return (int)(atk*NORMAL);
	}

	public static int onionBreath(int atk){
		return (int)(atk*NORMAL);
	}

	public static int waterPistol(int atk){
		return (int)(atk*NORMAL);
	}

	public static int electricBoogie(int atk){
		return (int)(atk*NORMAL);
	}

	public static int superMegaUltralordBeam(int atk){
		return (int)(atk*EPIC);
	}
}