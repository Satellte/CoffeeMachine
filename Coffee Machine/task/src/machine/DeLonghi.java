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
        System.out.println(" ");
        return "The coffee machine has:\n" +
                water + " ml of water\n" +
                milk + " ml of milk\n" +
                beans + " g of coffee beans\n" +
                cups + " disposable cups\n" +
                "$" + money + " of money\n";
    }

    public static void takeMoney(int currMoney) {
        System.out.println("\nI gave you $" + currMoney + "\n");
        DeLonghi.money = 0;
    }

    public static void fill(int water, int milk, int beans, int cups) {
        int addWater, addMilk, addBeans, addCups;
        System.out.print("Write how many ml of water you want to add:\n> ");
        addWater = scanner.nextInt();
        System.out.print("Write how many ml of milk you want to add:\n> ");
        addMilk = scanner.nextInt();
        System.out.print("Write how many grams of coffee beans you want to add:\n> ");
        addBeans = scanner.nextInt();
        System.out.print("Write how many disposable cups you want to add:\n> ");
        addCups = scanner.nextInt();
        DeLonghi.water = water + addWater;
        DeLonghi.milk = milk + addMilk;
        DeLonghi.beans = beans + addBeans;
        DeLonghi.cups = cups + addCups;
    }

    public static void getMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write the action (buy, fill, take, remaining, exit):\n" + "> ");
        String selection = scanner.nextLine();
        switch (selection) {
            case ("buy") -> {
                System.out.println(" ");
                getCoffee();
                DeLonghi.getMenu();
            }
            case ("fill") -> {
                fill(DeLonghi.water, DeLonghi.milk, DeLonghi.beans, DeLonghi.cups);
                System.out.println(" ");
                DeLonghi.getMenu();
            }
            case ("take") -> {
                DeLonghi.takeMoney(DeLonghi.money);
                DeLonghi.getMenu();
            }
            case ("remaining") -> {
                System.out.println(getResources(DeLonghi.water, DeLonghi.milk, DeLonghi.beans, DeLonghi.cups,
                        DeLonghi.money));
                DeLonghi.getMenu();
            }
            case "exit" -> System.exit(0);
        }
    }

    public static void getCoffee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:\n" +
                "> ");
        String selection = scanner.nextLine();
        switch (selection) {
            case ("1") -> {
                DeLonghi.makeEspresso(DeLonghi.water, DeLonghi.beans, DeLonghi.cups);
                System.out.println(" ");
                DeLonghi.getMenu();
            }
            case ("2") -> {
                DeLonghi.makeLatte(DeLonghi.water, DeLonghi.milk, DeLonghi.beans, DeLonghi.cups);
                System.out.println(" ");
                DeLonghi.getMenu();
            }
            case ("3") -> {
                DeLonghi.makeCappuccino(DeLonghi.water, DeLonghi.milk, DeLonghi.beans, DeLonghi.cups);
                System.out.println(" ");
                DeLonghi.getMenu();
            }
            case "back" -> DeLonghi.getMenu();
        }
    }

    static void makeEspresso(int currWater, int currBeans, int currCups) {
        boolean notEnoughResources = false;
        if (currWater < 250) {
            System.out.println("Sorry, not enough water!");
            notEnoughResources = true;
        }
        if (currBeans < 16) {
            System.out.println("Sorry, not enough beans!");
            notEnoughResources = true;
        }
        if (currCups < 1) {
            System.out.println("Sorry, not enough cups!");
            notEnoughResources = true;
        }
        if (!notEnoughResources) {
            DeLonghi.water -= 250;
            DeLonghi.beans -= 16;
            DeLonghi.cups--;
            DeLonghi.money += 4;
            System.out.println("I have enough resources, making you a coffee!");
        }
    }

    static void makeLatte(int currWater, int currMilk, int currBeans, int currCups) {
        boolean notEnoughResources = false;
        if (currWater < 350) {
            System.out.println("Sorry, not enough water!");
            notEnoughResources = true;
        }
        if (currMilk < 75){
            System.out.println("Sorry, not enough milk!");
            notEnoughResources = true;
        }
        if (currBeans < 20) {
            System.out.println("Sorry, not enough beans!");
            notEnoughResources = true;
        }
        if (currCups < 1) {
            System.out.println("Sorry, not enough cups!");
            notEnoughResources = true;
        }
        if (!notEnoughResources) {
            DeLonghi.water -= 350;
            DeLonghi.milk -=75;
            DeLonghi.beans -= 20;
            DeLonghi.cups--;
            DeLonghi.money += 7;
            System.out.println("I have enough resources, making you a coffee!");
        }
    }

    static void makeCappuccino(int currWater, int currMilk, int currBeans, int currCups) {
        boolean notEnoughResources = false;
        if (currWater < 200) {
            System.out.println("Sorry, not enough water!");
            notEnoughResources = true;
        }
        if (currMilk < 100){
            System.out.println("Sorry, not enough milk!");
            notEnoughResources = true;
        }
        if (currBeans < 12) {
            System.out.println("Sorry, not enough beans!");
            notEnoughResources = true;
        }
        if (currCups < 1) {
            System.out.println("Sorry, not enough cups!");
            notEnoughResources = true;
        }
        if (!notEnoughResources) {
            DeLonghi.water -= 200;
            DeLonghi.milk -= 100;
            DeLonghi.beans -= 12;
            DeLonghi.cups--;
            DeLonghi.money += 6;
            System.out.println("I have enough resources, making you a coffee!");
        }
    }
}
