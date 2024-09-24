package obstacle;

public abstract class Obstacle {
    private int dmg;
    private int hp;
    private int money;
    private int obstacleNumber;
    private String name;

    public Obstacle(int dmg, int hp, int money, int obstacleNumber, String name) {
        this.dmg = dmg;
        this.hp = hp;
        this.money = money;
        this.obstacleNumber = obstacleNumber;
        this.name = name;
    }

    public int getDmg() {
        return dmg;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getMoney() {
        return money;
    }

    public int getObstacleNumber() {
        return obstacleNumber;
    }

    public void setObstacleNumber(int obstacleNumber) {
        this.obstacleNumber = obstacleNumber;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
