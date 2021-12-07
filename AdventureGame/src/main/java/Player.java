import java.util.Scanner;
public class Player {
    private String playerName;
    private String charName;
    private int damage;
    private int health;
    private int money;
    private Inventory inventory;
    private int orjinalHealth;
    
    private Scanner input = new Scanner(System.in);
    
    public Player(String playerName){
        this.playerName = playerName;
        this.inventory = new Inventory();
    }
    
    public void selectChar(){
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("Karakterler");
        System.out.println("----------------------------------------------------------------------");
        for(GameChar gameChar : charList){
            System.out.println("ID : " + gameChar.getId() 
                    + "\t Karakter:" + gameChar.getCharName() 
                    + "\t Hasar:" + gameChar.getDamage() 
                    + "\t Sağlık:" + gameChar.getHealth() 
                    + "\t Para:" + gameChar.getMoney());
        }
        System.out.println("----------------------------------------------------------------------");
        System.out.print("Lütfen bir karakter giriniz : ");
        int selectChar = input.nextInt();
        switch(selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default :
                initPlayer(new Samurai());
        }
    }
    
    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOrjinalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getCharName());
    }
    
    public void printInfo(){
        System.out.println("Silah : " + this.getInventory().getWeapon().getWeaponName()
                + ", Zırh : " + this.getInventory().getArmor().getArmorName()
                + ", Bloklama : " + this.getInventory().getArmor().getBlock()
                + ", Hasar : " + this.getTotalDamage() 
                + ", Sağlık : " + this.getHealth()
                + ", Para : " + this.getMoney());
    }
    
     public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    
    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    } 
    
    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health < 0){
            health = 0;
        }
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }

}
