package location;

import Player.Player;

import java.util.concurrent.TimeUnit;

public abstract class Location {
    private Player player;
    private String name;

    public Location(Player player,String name) {
        this.player = player;
        this.name=name;
    }

    public Player getPlayer() {
        return player;
    }

    public String getName() {
        return name;
    }

    public abstract void onLocation();

    public String playerStatus() {
        Player player=this.getPlayer();
        return "Player Status:\n" +
                "Name: " + player.getName() + "\n" +
                "HP: " + player.getHp() + "\n" +
                "Money: " + player.getMoney() + "\n";
    }

    public void wait1sec(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
