package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        int availableWater, availableMilk, availableBeans, availableCups, availableMoney;
        availableWater = 400;
        availableMilk = 540;
        availableBeans = 120;
        availableCups = 9;
        availableMoney = 550;
        selectMenu(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
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
        System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
        String selection = scanner.nextLine();
        switch (selection) {
            case ("buy") -> buy(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
            case ("fill") -> fill(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
            case ("take") -> take(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
            case ("remaining") -> showStatus(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
            default ->  System.exit(0);
        }
    }

    public static void buy(int availableWater, int availableMilk, int availableBeans, int availableCups,
                           int availableMoney) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String selection = scanner.nextLine();
        switch (selection) {
            case ("1") -> makeEspresso(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
            case ("2") -> makeLatte(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
            case ("3") -> makeCappuccino(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
            case ("back") -> selectMenu(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
            default -> System.exit(0);
        }
    }

    public static void makeEspresso(int availableWater, int availableMilk, int availableBeans, int availableCups,
                                    int availableMoney) {
        availableWater = availableWater - 250;
        if (availableWater <= 0) {
            availableWater = availableWater + 250;
            System.out.println("Sorry, not enough water!");
            selectMenu(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
        }
        availableBeans = availableBeans - 16;
        if (availableBeans <= 0) {
            availableBeans = availableBeans + 16;
            System.out.println("Sorry, not enough beans!");
            selectMenu(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
        }
        availableCups = availableCups - 1;
        if (availableWater <= 0) {
            availableCups = availableCups + 1;
            System.out.println("Sorry, not enough cups!");
            selectMenu(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
        }
        availableMoney = availableMoney + 4;
        System.out.println("I have enough resources, making you a coffee!");
        selectMenu(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
    }

    public static void makeLatte(int availableWater, int availableMilk, int availableBeans, int availableCups,
                                 int availableMoney) {
        availableWater = availableWater - 350;
        if (availableWater <= 0) {
            availableWater = availableWater + 350;
            System.out.println("Sorry, not enough water!");
            selectMenu(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
        }
        availableMilk = availableMilk - 75;
        if (availableMilk <= 0) {
            availableMilk = availableMilk + 75;
            System.out.println("Sorry, not enough milk!");
            selectMenu(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
        }
        availableBeans = availableBeans - 20;
        if (availableBeans <= 0) {
            availableBeans = availableBeans + 20;
            System.out.println("Sorry, not enough beans!");
            selectMenu(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
        }
        availableCups = availableCups - 1;
        if (availableWater <= 0) {
            availableCups = availableCups + 1;
            System.out.println("Sorry, not enough cups!");
            selectMenu(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
        }
        availableMoney = availableMoney + 7;
        selectMenu(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
    }

    public static void makeCappuccino(int availableWater, int availableMilk, int availableBeans, int availableCups,
                                      int availableMoney) {
        availableWater = availableWater - 200;
        if (availableWater <= 0) {
            availableWater = availableWater + 200;
            System.out.println("Sorry, not enough water!");
            selectMenu(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
        }
        availableMilk = availableMilk - 100;
        if (availableMilk <= 0) {
            availableMilk = availableMilk + 100;
            System.out.println("Sorry, not enough milk!");
            selectMenu(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
        }
        availableBeans = availableBeans - 12;
        if (availableBeans <= 0) {
            availableBeans = availableBeans + 12;
            System.out.println("Sorry, not enough beans!");
            selectMenu(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
        }
        availableCups = availableCups - 1;
        if (availableWater <= 0) {
            availableCups = availableCups + 1;
            System.out.println("Sorry, not enough cup!");
            selectMenu(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
        }
        availableMoney = availableMoney + 6;
        selectMenu(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
    }

    public static void fill(int availableWater, int availableMilk, int availableBeans, int availableCups,
                            int availableMoney) {
        int addWater, addMilk, addBeans, addCups;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write how many ml of water you want to add:\n");
        addWater = scanner.nextInt();
        System.out.print("Write how many ml of milk you want to add:\n");
        addMilk = scanner.nextInt();
        System.out.print("Write how many grams of coffee beans you want to add:\n");
        addBeans = scanner.nextInt();
        System.out.print("Write how many disposable cups you want to add:\n");
        addCups = scanner.nextInt();
        availableWater = availableWater + addWater;
        availableMilk = availableMilk + addMilk;
        availableBeans = availableBeans + addBeans;
        availableCups = availableCups + addCups;
        selectMenu(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
    }

    public static void take(int availableWater, int availableMilk, int availableBeans, int availableCups,
                            int availableMoney) {
        System.out.println("I gave you $" + availableMoney);
        availableMoney = 0;
        selectMenu(availableWater, availableMilk, availableBeans, availableCups, availableMoney);
    }
}