package location;
import Player.Player;
import obstacle.Obstacle;
import java.util.Scanner;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static java.lang.System.exit;


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
        int PlayerDmg = player.getDmg() + player.getInventory().getWeaponDamage();//Problem
        int PlayerHp=  player.getHp();
        int PlayerArmor= player.getInventory().getArmorValue();
        Object[] objects = new Object[2];



        while (noOfObstacle!=0){
            healthStatus(player,obstacle);
            obstacle.setHp(obstacle.getHp()-PlayerDmg);
            System.out.println(player.getName() +" dealed " + PlayerDmg + " dmg to " + obstacle.getName());
            if(obstacle.getHp()<=0){
                noOfObstacle--;
                System.out.println("You killed the monster there is "+ noOfObstacle + " amount of monster left.");
                obstacle.setHp(ObstacleHp);
            }
            if(noOfObstacle==0){
                break;
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            healthStatus(player,obstacle);
            player.setHp(player.getHp()-obstacle.getDmg());
            System.out.println(obstacle.getName() + " dealed " + obstacle.getDmg() + " dmg to " + player.getName());
            if(player.getHp()<=0){
                System.out.println("You DieD.");
                exit(0);
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println("Congrats You Have Cleared The " + this.getName());
        String award = getPrize();
        System.out.println("You will be rewarded "+ award +"." );
    }

    public void healthStatus(Player player,Obstacle obstacle){
        System.out.println("----Health Status Of The Characters----");
        System.out.println(player.getName()+" --> "+ player.getHp());
        System.out.println(obstacle.getName()+" --> "+obstacle.getHp());
        System.out.println("---------------------------------------");
    }


    @Override
    public void onLocation() {
        if(isCleared()){
            System.out.println("You already Clared This Section");
            return;
        }

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

    private boolean isCleared(){
        boolean flag = false;
        switch (this.getName()){
            case "Cave":
                if(this.getPlayer().getInventory().isFood())
                    flag=true;
                break;
            case "Forest":
                if(this.getPlayer().getInventory().isFirewood())
                    flag=true;
                break;
            case "River":
                if(this.getPlayer().getInventory().isWater())
                    flag=true;
                break;
        }
        return flag;
    }

    private String getPrize(){
        String award;
        switch(this.getName()){
            case "Cave":
                this.getPlayer().getInventory().setFood(true);
                award="Food";
                break;
            case "Forest":
                this.getPlayer().getInventory().setFirewood(true);
                award="Firewood";
                break;
            case "River":
                this.getPlayer().getInventory().setWater(true);
                award="Water";
                break;
            default:
                award=null;
        }
        return award;
    }
}

