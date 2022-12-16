package machine;

import java.util.Scanner;
import static machine.TypeOfCoffee.*;

public class CoffeeMachine {
    static MachineState state;
    static int water;
    static int milk;
    static int beans;
    static int cups;
    static int money;


    public void setResources(MachineState state, int water, int milk, int beans, int cups, int money) {
        CoffeeMachine.state = state;
        CoffeeMachine.water = water;
        CoffeeMachine.milk = milk;
        CoffeeMachine.beans = beans;
        CoffeeMachine.cups = cups;
        CoffeeMachine.money = money;

        setToMainState();
    }
    public static void showMainMenu(){
        Scanner scanner = new Scanner(System.in);
        switch (state){
            case SHOWMAINMENU -> {
                System.out.print("Write action (buy, fill, take, remaining, exit):\n> ");
                setStateOfMachine(scanner.next().toLowerCase());
            }
            case MAKINGCOFFE -> {
                System.out.print("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, or back\n> ");
                showCoffeeMenu(scanner.next().toLowerCase());
                setToMainState();
            }
            case SHOWRESOURCES -> getPrintResources();
            case NEEDRESOURCES -> addResources();
            case GIVEMONEY -> giveMoney();
            case OFF -> System.exit(0);
        }
    }
    public static void setToMainState(){
        state = MachineState.SHOWMAINMENU;
    }

    public static void showCoffeeMenu(String selection) {
        TypeOfCoffee receipt = null;

        switch (selection) {
            case "1" -> receipt = ESPRESSO;
            case "2" -> receipt = LATTE;
            case "3" -> receipt = CAPPUCCINO;
            default -> {
                setToMainState();
                showMainMenu();
            }
        }
        assert receipt != null;
        makeCoffee(receipt);
    }

    public static void makeCoffee(TypeOfCoffee receipt) {
        if (water < receipt.needWater()) {
            System.out.println("Sorry, not enough water!\n");
            setToMainState();
            showMainMenu();
        }
        if (milk < receipt.needMilk()) {
            System.out.println("Sorry, not enough milk!\n");
            setToMainState();
            showMainMenu();
        }
        if (beans < receipt.needBeans()) {
            System.out.println("Sorry, not enough coffee beans!\n");
            setToMainState();
            showMainMenu();
        }
        if (cups < receipt.needCups()) {
            System.out.println("Sorry, not enough cups!\n");
            setToMainState();
            showMainMenu();
        }

        water -= receipt.needWater();
        milk -= receipt.needMilk();
        beans -= receipt.needBeans();
        cups --;
        money += receipt.getPrice();

        System.out.println("I have enough resources, making you a coffee!\n");
        setToMainState();
        showMainMenu();
    }

    public static void setStateOfMachine(String function){
        switch (function){
            case "buy" ->{
                state = MachineState.MAKINGCOFFE;
                showMainMenu();
            }
            case "fill" -> {
                state = MachineState.NEEDRESOURCES;
                showMainMenu();
            }
            case "take" ->{
                state = MachineState.GIVEMONEY;
                showMainMenu();
            }
            case "remaining" -> {
                state = MachineState.SHOWRESOURCES;
                showMainMenu();
            }
            case "exit" -> System.exit(0);
        }

    }

    public static void addResources(){
        Scanner scanner = new Scanner(System.in);
        int addWater, addMilk, addBeans, addCups;
        System.out.print("Write how many ml of water do you want to add:\n> ");
        addWater = scanner.nextInt();
        System.out.print("\nWrite how many ml of milk do you want to add:\n> ");
        addMilk = scanner.nextInt();
        System.out.print("\nWrite how many g of beans do you want to add:\n> ");
        addBeans = scanner.nextInt();
        System.out.print("\nWrite how many cups do you want to add:\n> ");
        addCups = scanner.nextInt();
        water += addWater;
        milk += addMilk;
        beans += addBeans;
        cups += addCups;
        setToMainState();
        showMainMenu();
    }

    public static void giveMoney(){
        System.out.printf("I gave you $%d \n", money);
        System.out.print("\n");
        money = 0;
        setToMainState();
        showMainMenu();
    }

    public static void getPrintResources(){
        System.out.printf("""
                The coffee machine has:
                %d ml of water,
                %d ml of milk,
                %d g of coffee beans,
                %d disposable cups
                $%d of money
                """, water, milk, beans, cups, money);
        System.out.print("\n");
        setToMainState();
        showMainMenu();
    }

}

