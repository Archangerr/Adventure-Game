package location;

import Player.Player;

public class ToolStore extends NormalLocation {


    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    public void onLocation() {
        System.out.println("Welcome to Tool Store.");
        System.out.println("In here you can buy new ones or upgrade your tools with the coins you earned.");

    }
}
