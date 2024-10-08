package Armor;

public class Armor {
    private int id;
    private int block;
    private int money;
    private String name;

    public Armor(int id, int block, int money,String name) {
        this.id = id;
        this.block = block;
        this.money = money;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}