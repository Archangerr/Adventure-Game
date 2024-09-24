package location;

import Player.Player;
import obstacle.Zombie;

public class Cave extends BattleLocation{
    public Cave(Player player){
        super(player,"Cave",new Zombie((int)(Math.random() * 3) + 1));
    }

}
