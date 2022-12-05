package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write how many cups of coffee you will need:\n> ");
        int cupsOfCoffee = scanner.nextInt();
        System.out.printf("For %d cups of coffee you will need:\n", cupsOfCoffee);
        System.out.println(calculationForOneCupOfCoffee(cupsOfCoffee));
        /*startMachine();
        grindBeans();
        boilWater();
        mixWaterAndBeans();
        pourCoffee();
        pourMilk();
        serveCoffee();*/
    }

    /**
     * This metod figure out how much of each ingredient the machine will need
     * @param cupsOfCoffee - numbers of coffee drinks
     * @return returns String with list of the required ingredient amounts
     */
    public static String calculationForOneCupOfCoffee(int cupsOfCoffee) {
        int waterPerCup = 200;
        int milkPerCup = 50;
        int coffeeBeansPerCup = 15;
        int waterForCups, milkForCups, coffeeBeansForCups;
        waterForCups = waterPerCup * cupsOfCoffee;
        milkForCups = milkPerCup * cupsOfCoffee;
        coffeeBeansForCups = coffeeBeansPerCup * cupsOfCoffee;
        return waterForCups + " ml of water\n" + milkForCups + " ml of milk\n" + coffeeBeansForCups + " g of coffee beans";
    }
    private static void startMachine() {
        System.out.println("Starting to make a coffee");
    }
    private static void grindBeans() {
        System.out.println("Grinding coffee beans");
    }

    private static void boilWater() {
        System.out.println("Boiling water");
    }

    private static void mixWaterAndBeans() {
        System.out.println("Mixing boiled water with crushed coffee beans");
    }

    private static void pourCoffee() {
        System.out.println("Pouring coffee into the cup");
    }

    private static void pourMilk() {
        System.out.println("Pouring some milk into the cup");
    }

    private static void serveCoffee() {
        System.out.println("Coffee is ready!");
    }
}