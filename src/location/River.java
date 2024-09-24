package location;

import Player.Player;
import obstacle.Bear;

public class River extends BattleLocation{
    public River(Player player, String name){
        super(player,"River",new Bear((int)(Math.random() * 3) + 1));
    }
}
