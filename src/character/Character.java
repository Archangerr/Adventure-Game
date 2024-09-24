package character;

public abstract class Character {
    private int dmg;
    private int hp;
    private int money;

    public Character(int dmg, int hp, int money) {
        this.dmg = dmg;
        this.hp = hp;
        this.money = money;
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
}
