package machine;

/**
 * enum with types of coffee. Each type have own list with need resources. Declaration and initialization of fields of
 * enum objects. Methods to get needed resources and price for cup of good coffee.
 */
public enum TypeOfCoffee {
    ESPRESSO(250, 0, 16, 1, 4),
    LATTE(350, 75, 20, 1, 7),
    CAPPUCCINO(200, 100, 12, 1, 6);

    private final int water;
    private final int milk;
    private final int beans;
    private final int cups;
    private final int price;

    /**
     * This setter method for new object of enum
     * @param water this field set how much water need for cup of some type of coffee
     * @param milk this field set how much milk need for cup of some type of coffee
     * @param beans this field set how much beans need for cup of some type of coffee
     * @param cups this field set how much cup need for cup of some type of coffee
     * @param price this field set price for cup of some type of coffee
     */
    TypeOfCoffee(int water, int milk, int beans, int cups, int price) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.price = price;
    }

    /**
     * This method return needed ml of water for some type of coffee
     * @return
     */
    public int needWater() {
        return water;
    }

    /**
     * This method return needed ml of milk for some type of coffee
     * @return
     */
    public int needMilk() {
        return milk;
    }

    /**
     * This method return how much beans need for some type of coffee
     * @return
     */
    public int needBeans() {
        return beans;
    }

    /**
     * This method return how much cup need for some type of coffee
     * @return
     */
    public int needCups() {
        return cups;
    }

    /**
     * This method return price for some type of coffee
     * @return
     */
    public int getPrice() {
        return price;
    }
}
