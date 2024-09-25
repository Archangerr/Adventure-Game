package location;

import Player.Player;

public class SafeHouse extends NormalLocation{

    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public void onLocation() {
        System.out.println(this.playerStatus());
        System.out.println("Player will rest for a day and Get Full hp");
        int i =0;
        while(i<5){
            this.wait1sec();
            i++;
        }
        this.getPlayer().setHp(this.getPlayer().getFullHp());
        System.out.println(this.playerStatus());
    }


}
