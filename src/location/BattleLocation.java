package location;
import Player.Player;
import obstacle.Obstacle;
import java.util.Scanner;


public abstract class BattleLocation extends Location {
    private Obstacle obstacle;
    private String selectState;


    public BattleLocation(Player player,String name,Obstacle obstacle) {
        super(player,name);
        this.obstacle = obstacle;
    }

    public void combat(){
        Player player = this.getPlayer();
        int noOfObstacle = obstacle.getObstacleNumber();
        int ObstacleDmg=obstacle.getDmg();
        int ObstacleHp=obstacle.getHp();
        int ObstacleStartHp=obstacle.getHp();
        int PlayerDmg= player.getDmg() + player.getInventory().getWeaponDamage();
        int PlayerHp=  player.getHp();
        int PlayerArmor= player.getInventory().getArmorValue();



        while (noOfObstacle!=0){
            System.out.println("----Health Status Of The Characters----");
            System.out.println(player.getName()+" --> "+ player.getHp());
            System.out.println(obstacle.getName()+" --> "+obstacle.getHp());
            System.out.println("---------------------------------------");
            obstacle.setHp(obstacle.getHp()-PlayerDmg);
            System.out.println(player.getName() +" dealed " + PlayerDmg + " to " + obstacle.getName());

        }
    }

    @Override
    public void onLocation() {
        Scanner scan = new Scanner(System.in);
        System.out.println("you have entered the "+ this.getName());
        System.out.println("There is " + obstacle.getObstacleNumber() + " " + obstacle.getName() + " waiting for you.");
        System.out.println("Would you want to fight or flee");
        selectState =scan.nextLine().toLowerCase();
        System.out.println();
        switch (selectState) {
            case "fight":
                combat();
                break;
            case "flight":
                break;
            default:
                System.out.println("wrong state");
                break;
        }


    }
}

