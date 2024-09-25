package location;
import Player.Player;
import obstacle.Vampire;

public class Forest extends BattleLocation {
    public Forest(Player player){
        super(player,"Forest",new Vampire((int)(Math.random() * 3) + 1));
    }
}
