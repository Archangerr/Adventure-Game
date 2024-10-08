package game;
import java.util.*;
import Player.Player;
import location.*;

public class Game {
    private Scanner input;
    private Player player;
    private String name;
    private Location location;

    public Game(){
        this.input= new Scanner(System.in);
    }

    public void start(){
        System.out.println("Adventure Game");
        System.out.print("What is your name? Please enter the name: ");
        name = input.next();
        player = new Player(name);
        System.out.println(player.getName()+ " welcome to the island");
        printChar();
        player.selectChar(input.nextInt());
        while(!isGameOver(player)) {
            printLocation();
            int k = input.nextInt();
            switch (k) {
                case 1:
                    location=new ToolStore(player);
                    location.onLocation();
                    break;
                case 2:
                    location=new SafeHouse(player);
                    location.onLocation();
                    break;
                case 3:
                    location = new Cave(player);
                    location.onLocation();
                    break;
                case 4:
                    location = new River(player);
                    location.onLocation();
                    break;
                case 5:
                    location = new Forest(player);
                    location.onLocation();
                    break;

            }
        }
    }

    private boolean isGameOver(Player player){
        return player.getInventory().isFirewood() && player.getInventory().isFood() && player.getInventory().isWater();
    }


    private void printChar() {
        System.out.println("____________________________________________________\n"
                + "\tWhich character you want to be? \n"
                + "\t1-Samurai\tDamage:5\tHealth:21\tmoney:25\n"
                + "\t2-Archer\tDamage:7\tHealth:18\tmoney:20 \n"
                + "\t3-Knight\tDamage:8\tHealth:24\tmoney:5 \n"
                + "____________________________________________________");
    }

    private void printLocation() {
        System.out.println("______________________________________________________________________________\n"
                + "\tWhere dou you want to go? \n"
                + "\t1-Tool Store\tYou can buy weapon and armor\n"
                + "\t2-Safe House\tYour health will be restore.\n"
                + "\t3-Cave\t\tGo to the cave but be careful! Zombies are everywhere\n"
                + "\t4-River\t\tGo to the river but be careful! Bears are everywhere\n"
                + "\t5-Forest\t\tGo to the forest but be careful!Vampires are everywhere\n"
                + "\t6-Mine\t\tGo to the mine but be careful! Snakes are everywhere\n"
                + "_______________________________________________________________________________");
    }



}
