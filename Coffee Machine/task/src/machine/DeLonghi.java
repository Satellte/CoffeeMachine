package machine;

import java.util.Scanner;

public class DeLonghi extends CoffeeMachine {
    protected static int water;
    protected static int milk;
    protected static int beans;
    protected static int cups;
    protected static int money;

    public void setResources(int water, int milk, int beans, int cups, int money) {
        DeLonghi.water = water;
        DeLonghi.milk = milk;
        DeLonghi.beans = beans;
        DeLonghi.cups = cups;
        DeLonghi.money = money;
    }

    public static String getResources(int water, int milk, int beans, int cups, int money) {
        return "The coffee machine has:\n" +
                water + " ml of water\n" +
                milk + " ml of milk\n" +
                beans + " g of coffee beans\n" +
                cups + " disposable cups\n" +
                "$" + money + " of money\n";
    }

    public static void takeMoney (int currMoney){
        System.out.println("I gave you $" + currMoney);
        DeLonghi.money = 0;
    }
}
