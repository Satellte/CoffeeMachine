package machine;

import java.util.Scanner;
import static machine.TypeOfCoffee.*;

/**
 * Class CoffeeMachine.
 */
public class CoffeeMachine {

    /**
     * Declaration of fields of object of the class. All fields are static.
     * This fields show how many resources object of class Coffee Machine have.
     */
    static MachineState state;
    static int water;
    static int milk;
    static int beans;
    static int cups;
    static int money;

    /**
     * Method setter for object of class Coffee Machine
     * @param state this field show current state from enum Machine State
     * @param water this field show current amount of water the machine have
     * @param milk this field show current amount of milk the machine have
     * @param beans this field show current amount of beans the machine have
     * @param cups this field show current amount of cups the machine have
     * @param money this field show current amount of money the machine have
     *
     * After initialization call method setToMainState
     */
    public void setResources(MachineState state, int water, int milk, int beans, int cups, int money) {
        CoffeeMachine.state = state;
        CoffeeMachine.water = water;
        CoffeeMachine.milk = milk;
        CoffeeMachine.beans = beans;
        CoffeeMachine.cups = cups;
        CoffeeMachine.money = money;

        setToMainState();
    }

    /**
     *This method change state of this machine to SHOWMAINMENU
     */
    public static void setToMainState(){
        state = MachineState.SHOWMAINMENU;
    }


    /**
     * This method shows welcome screen of main menu, then receive selection from user and,
     * in dependency of user selection, change state of this machine
     */
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

    /**
     * This method shows menu with coffee types from enum TypeOfCoffee, then receive selection from user and,
     * in dependency of user selection, start method makeCoffee
     * @param selection
     */
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

    /**
     * This method compares current resources of the machine and amount of need resources from the enum TypeOfCoffee
     * @param receipt this parameter shows what type of coffee need
     * If some resource is not enough, method shows warning with name of this resource
     * If there are enough resources, method subtract need resources from current resources,
     * then change state for main state and call main menu
     */
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