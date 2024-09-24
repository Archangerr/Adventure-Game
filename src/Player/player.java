package Player;
import character.character;
import character.archer;
import character.knight;
import character.samurai;

public class player {
    private inventory inventory;
    private int dmg;
    private int hp;
    private int money;
    private String name;

    public void selectChar(int k){
        character attributes = null;
        switch (k) {
            case 3:
                attributes = new knight();
            case 2:
                attributes = new archer();
            case 1:
                attributes=new samurai();
            default:
                System.out.println("Wrong Input");
        }
        this.dmg=  attributes.getDmg();
        this.hp=   attributes.getHp();
        this.money=attributes.getMoney();
    }
}
