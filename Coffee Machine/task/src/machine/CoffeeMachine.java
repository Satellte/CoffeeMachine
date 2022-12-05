package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] array = new int[3][3];
        int maxAvailableCups;
        System.out.print("Write how many ml of water the coffee machine has:\n");
        array[0][0] = scanner.nextInt(); //количество оставшейся воды
        System.out.print("Write how many ml of milk the coffee machine has:\n");
        array[0][1] = scanner.nextInt(); //количество оставшегося молока
        System.out.print("Write how many grams of coffee beans the coffee machine has:\n");
        array[0][2] = scanner.nextInt(); //количество оставшихся зерен
        System.out.print("Write how many cups of coffee you will need:\n");
        int cupsOfCoffee = scanner.nextInt();
        maxAvailableCups = checkingAmount(array);
        //System.out.println("maxav " + maxAvailableCups);
        if (maxAvailableCups < cupsOfCoffee) {
            System.out.printf("No, I can make only %d cup(s) of coffee", maxAvailableCups);
        } else if (maxAvailableCups == cupsOfCoffee) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            int overCupsOfCoffee = maxAvailableCups - cupsOfCoffee;
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)", overCupsOfCoffee);
        }
        /*System.out.printf("For %d cups of coffee you will need:\n", cupsOfCoffee);
        System.out.println(calculationForOneCupOfCoffee(cupsOfCoffee));
        startMachine();
        grindBeans();
        boilWater();
        mixWaterAndBeans();
        pourCoffee();
        pourMilk();
        serveCoffee();*/
    }

    /**
     * This method figure out how much of each ingredient the machine will need
     *
     * @return returns String with list of the required ingredient amounts
     */
    public static int checkingAmount(int[][] array) {
        int waterPerCup = 200;
        int milkPerCup = 50;
        int coffeeBeansPerCup = 15;
        int maxAvailableCups;
        array[1][0] = array[0][0] / waterPerCup; //заносим количество чашек по воде
        array[1][1] = array[0][1] / milkPerCup; //заночим количество чашек по молоку
        array[1][2] = array[0][2] / coffeeBeansPerCup; //заносим количество чашек по зернам
        //System.out.println(array[1][0]+ " " + array[1][1] + " " + array[1][2]);
        if ((array[1][0] <= array[1][1]) && (array[1][0] <= array[1][2])) { //если наименьшее количество чашек по воде
            maxAvailableCups = array[1][0];
            //System.out.println("вода");
        } else if ((array[1][1] <= array[1][0]) && (array[1][1] <= array[1][2])) { //если наименьшее количество чашек по молоку
            maxAvailableCups = array[1][1];
            //System.out.println("молоко");
        } else { //если наименьшее количество чашек по кофе
            maxAvailableCups = array[1][2];
            //System.out.println("кофе");
        }
        return maxAvailableCups;
        /*int waterForCups, milkForCups, coffeeBeansForCups;
        waterForCups = waterPerCup * cupsOfCoffee;
        milkForCups = milkPerCup * cupsOfCoffee;
        coffeeBeansForCups = coffeeBeansPerCup * cupsOfCoffee;
        return waterForCups + " ml of water\n" + milkForCups + " ml of milk\n" + coffeeBeansForCups + " g of coffee beans";*/
    }
    /*private static void startMachine() {
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
    }*/
}