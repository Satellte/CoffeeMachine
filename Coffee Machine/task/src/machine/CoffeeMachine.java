package machine;

import java.util.Scanner;

import static machine.DeLonghi.*;

public class CoffeeMachine {

    public static void main(String[] args) {
        DeLonghi DeLonghi = new DeLonghi();
        DeLonghi.setResources(400, 540, 120, 9, 550);

        CoffeeType Espresso = new CoffeeType();
        Espresso.setResources(250,0,16,1,4);

        CoffeeType Latte = new CoffeeType();
        Latte.setResources(350,75,20, 1, 7);

        CoffeeType Cappuccino = new CoffeeType();
        Cappuccino.setResources(200, 100, 12, 1, 6);

    }

    public static void showStatus(int availableWater, int availableMilk, int availableBeans, int availableCups,
                                  int availableMoney) {
        System.out.print("\nThe coffee machine has:\n");
        System.out.println(availableWater + " ml of water");
        System.out.println(availableMilk + " ml of milk");
        System.out.println(availableBeans + " g of coffee beans");
        System.out.println(availableCups + " disposable cups");
        System.out.println("$" + availableMoney + " of money");
        selectMenu(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
    }

    public static void selectMenu(int availableWater, int availableMilk, int availableBeans, int availableCups,
                                  int availableMoney) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write the action (buy, fill, take, remaining, exit):\n" + "> ");
        String selection = scanner.nextLine();
        switch (selection) {
            case ("buy") -> buy(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
            case ("fill") -> fill(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
            case ("take") -> DeLonghi.takeMoney(DeLonghi.money);
            case ("remaining") -> System.out.println(getResources(DeLonghi.water, DeLonghi.milk, DeLonghi.beans, DeLonghi.cups,
                    DeLonghi.money));
            case "exit" -> {
              System.exit(0);
           }
        }
    }

    public static void buy(int availableWater, int availableMilk, int availableBeans, int availableCups,
                           int availableMoney) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int selection = scanner.nextInt();
        switch (selection) {
            case (1) -> makeEspresso(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
            case (2) -> makeLatte(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
            case (3) -> makeCappuccino(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
            default -> {
            }
        }
    }

    public static void makeEspresso(int availableWater, int availableMilk, int availableBeans, int availableCups,
                                    int availableMoney) {
        availableWater = availableWater - 250;
        if (availableWater <= 0) {
            availableWater = availableWater + 250;
            System.out.println("Not enough water, please, refill water");
            showStatus(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
        }
        availableBeans = availableBeans - 16;
        if (availableBeans <= 0) {
            availableBeans = availableBeans + 16;
            System.out.println("Not enough beans, please, refill beans");
            showStatus(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
        }
        availableCups = availableCups - 1;
        if (availableWater <= 0) {
            availableCups = availableCups + 1;
            System.out.println("Not enough cups, please, refill cups");
            showStatus(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
        }
        availableMoney = availableMoney + 4;
        showStatus(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
    }

    public static void makeLatte(int availableWater, int availableMilk, int availableBeans, int availableCups,
                                 int availableMoney) {
        availableWater = availableWater - 350;
        if (availableWater <= 0) {
            availableWater = availableWater + 350;
            System.out.println("Not enough water, please, refill water");
            showStatus(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
        }
        availableMilk = availableMilk - 75;
        if (availableMilk <= 0) {
            availableMilk = availableMilk + 75;
            System.out.println("Not enough milk, please, refill milk");
            showStatus(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
        }
        availableBeans = availableBeans - 20;
        if (availableBeans <= 0) {
            availableBeans = availableBeans + 20;
            System.out.println("Not enough beans, please, refill beans");
            showStatus(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
        }
        availableCups = availableCups - 1;
        if (availableWater <= 0) {
            availableCups = availableCups + 1;
            System.out.println("Not enough cups, please, refill cups");
            showStatus(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
        }
        availableMoney = availableMoney + 7;
        showStatus(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
    }

    public static void makeCappuccino(int availableWater, int availableMilk, int availableBeans, int availableCups,
                                      int availableMoney) {
        availableWater = availableWater - 200;
        if (availableWater <= 0) {
            availableWater = availableWater + 200;
            System.out.println("Not enough water, please, refill water");
            showStatus(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
        }
        availableMilk = availableMilk - 100;
        if (availableMilk <= 0) {
            availableMilk = availableMilk + 100;
            System.out.println("Not enough milk, please, refill milk");
            showStatus(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
        }
        availableBeans = availableBeans - 12;
        if (availableBeans <= 0) {
            availableBeans = availableBeans + 12;
            System.out.println("Not enough beans, please, refill beans");
            showStatus(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
        }
        availableCups = availableCups - 1;
        if (availableWater <= 0) {
            availableCups = availableCups + 1;
            System.out.println("Not enough cups, please, refill cups");
            showStatus(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
        }
        availableMoney = availableMoney + 6;
        showStatus(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
    }

    public static void fill(int availableWater, int availableMilk, int availableBeans, int availableCups,
                            int availableMoney) {
        int addWater, addMilk, addBeans, addCups;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:\n> ");
        addWater = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:\n> ");
        addMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:\n> ");
        addBeans = scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:\n> ");
        addCups = scanner.nextInt();
        availableWater = availableWater + addWater;
        availableMilk = availableMilk + addMilk;
        availableBeans = availableBeans + addBeans;
        availableCups = availableCups + addCups;
        showStatus(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
    }

    public static void take(int availableWater, int availableMilk, int availableBeans, int availableCups,
                            int availableMoney) {
        System.out.println("I gave you $" + availableMoney);
        availableMoney = 0;
        showStatus(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
    }
}