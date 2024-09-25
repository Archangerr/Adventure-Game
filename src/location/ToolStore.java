package location;

import Player.Player;
import Armor.*;
import Weapon.*;
import java.util.Scanner;

public class ToolStore extends NormalLocation {
    public int id;
    public String type;
    public int product=1;
    private Scanner input = new Scanner(System.in);
    private Weapon[] weaponList = {new Gun(), new Sword(), new Rifle()};
    private Armor[] armorList = {new Light(), new Medium(), new Heavy()};



    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    public void onLocation() {
        System.out.println("Welcome to Tool Store.");
        System.out.println("In here you can buy new ones or upgrade your tools with the coins you earned.");
        System.out.println("Currently you have " + this.getPlayer().getMoney() + " coins.");
        selectProduct();

    }

    public void menuWeapon() {
        System.out.println("------------------------------- WEAPONS -------------------------------");

        for (Weapon weapons : weaponList) {
            System.out.println("id:" + weapons.getId() +
                    "\t Name: " + weapons.getName() +
                    "\t Damage: " + weapons.getDamage() +
                    "\t Money: " + weapons.getMoney());
        }
        System.out.println("-----------------------------------------------------------------------");
    }

    public void menuArmor() {
        System.out.println("------------------------------- ARMORS -------------------------------");

        for (Armor armors : armorList) {
            System.out.println("id: " + armors.getId() +
                    "\t Name: " + armors.getName() +
                    "\t Defense: " + armors.getBlock() +
                    "\t Money: " + armors.getMoney());
        }
        System.out.println("----------------------------------------------------------------------");
    }

    public void buyWeapon(int i){
        if(this.getPlayer().getMoney()>weaponList[i].getMoney()) {
            System.out.println("You able to buy the " + weaponList[i].getName());
            System.out.println("You had " + this.getPlayer().getMoney() + " money.");
            this.getPlayer().setMoney(this.getPlayer().getMoney()-weaponList[i].getMoney());
            System.out.println("After the purchase you left with "+ this.getPlayer().getMoney());
            this.getPlayer().getInventory().setWeaponDamage(weaponList[i].getDamage());
            this.getPlayer().getInventory().setWeaponName(weaponList[i].getName());
            int playerDmg = this.getPlayer().getInventory().getWeaponDamage() + this.getPlayer().getDmg();
            System.out.println("After the purchase you now have "+ playerDmg);
        }
        else {
            System.out.println("You dont have enough money to buy the weapon.");
            int moneyDifference = weaponList[i].getMoney() -this.getPlayer().getMoney();
            System.out.println("You have "+ this.getPlayer().getMoney() + " coins " + " You Lack "+ moneyDifference+ " coins");
        }
    }

    public void buyArmor(int i){
        Armor armor = armorList[i];
        Player player = this.getPlayer();
        if(player.getMoney()>armor.getMoney()){
            System.out.println("You able to buy the " + armor.getName());
            System.out.println("You had " + player.getMoney() + " money.");
            player.setMoney(player.getMoney()-armor.getMoney());
            System.out.println("After the purchase you left with "+ player.getMoney());
            player.getInventory().setArmorValue(armor.getBlock());
            player.getInventory().setArmorName(armor.getName());
            System.out.println("After the purchase you now have "+ player.getInventory().getArmorValue()+" block.");
        }
        else {
            System.out.println("You dont have enough money to buy the Armor.");
            int moneyDifference = armor.getMoney() -player.getMoney();
            System.out.println("You have "+ player.getMoney() + " coins " + " You Lack "+ moneyDifference+ " coins");
        }
    }

    public void selectProduct(){
        while(product!=0){
            System.out.println("Which product do you want to buy? Press 0 to leave.");
            System.out.println("1-> Weapon");
            System.out.println("2-> Armor");

            product = input.nextInt();

            switch(product){
                case 1:
                    menuWeapon();
                    System.out.println("Enter the Weapon Id You want to buy.");
                    product=input.nextInt();
                    buyWeapon(product-1);
                    break;
                case 2:
                    menuArmor();
                    System.out.println("Enter the Armor Id you want to buy.");
                    product=input.nextInt();
                    buyArmor(product-1);
                    break;
            }
        }
    }
}
