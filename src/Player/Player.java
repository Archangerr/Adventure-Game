package Player;
import character.Character;
import character.Archer;
import character.Knight;
import character.Samurai;

public class Player {
    private Inventory inventory;
    private int dmg;
    private int hp;
    private int money;
    private String name;
    private int fullHp;

    public void selectChar(int k){
        Character attributes = null;
        switch (k) {
            case 1:
                attributes=new Samurai();
                break;
            case 2:
                attributes = new Archer();
                break;
            case 3:
                attributes = new Knight();
                break;
        }
        this.dmg=  attributes.getDmg();
        this.hp=   attributes.getHp();
        this.money=attributes.getMoney();
        this.fullHp=attributes.getHp();
    }

    public Player(String name) {
        this.name = name;
        this.inventory= new Inventory();

    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getDmg() {
        return dmg;
    }

    public int getHp() {
        return hp;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
