public class Monster {
    private String name;
    private int health;
    private  int strength;
    private int xp;
    //Constructor

    public Monster(String name, int health, int strength, int xp) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.xp = xp;
    }

    public static Monster spawn(String type)
    {
        Monster monster = null;
        if(type.equalsIgnoreCase("goblin"))
        monster = new Monster(type,60,8,1);
        if(type.equalsIgnoreCase("orc"))
            monster = new Monster(type,100,12,3);
        if(type.equalsIgnoreCase("troll"))
            monster = new Monster(type,150,15,5);
        return monster;
    }
    //getters


    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getXp() {
        return xp;
    }
    public void takeDamage(int damage)
    {
        if(damage<=health)
            health-=damage;
    }

    public void attack(Player hero)
    {
        hero.takeDamage(strength);
        System.out.format("%s attacks player for %d damage",name, strength);
    }

    @Override
    public String toString() {
        return String.format("[%s] HP:%d, STR:%d",name,health,strength);
    }
}