package CoffeeMachine;

public enum TypeOfCoffee {
    ESPRESSO(250, 0, 16, 1, 4),
    LATTE(350, 75, 20, 1, 7),
    CAPPUCCINO(200, 100, 12, 1, 6);

    private final int water;
    private final int milk;
    private final int beans;
    private final int cups;
    private final int price;

    TypeOfCoffee(int water, int milk, int beans, int cups, int price) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.price = price;
    }

    public int needWater() {
        return water;
    }

    public int needMilk() {
        return milk;
    }

    public int needBeans() {
        return beans;
    }

    public int needCups() {
        return cups;
    }

    public int getPrice() {
        return price;
    }
}
