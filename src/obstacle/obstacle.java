package obstacle;

public abstract class obstacle   {
    private int dmg;
    private int hp;
    private int money;
    private int obstacleNumber;

    public obstacle(int dmg, int hp, int money, int obstacleNumber) {
        this.dmg = dmg;
        this.hp = hp;
        this.money = money;
        this.obstacleNumber = obstacleNumber;
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

    public int getObstacleNumber() {
        return obstacleNumber;
    }

    public void setObstacleNumber(int obstacleNumber) {
        this.obstacleNumber = obstacleNumber;
    }
}
