package machine;

public class CoffeeType {
    protected int water, milk, beans, cups, money;

    public void setResources(int water, int milk, int beans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
    }

    public String getStatus(int water, int milk, int beans, int cups, int money) {
        return "The coffee machine has:\n" +
                this.water + " ml of water\n" +
                this.milk + " ml of milk\n" +
                this.beans + " g of coffee beans\n" +
                this.cups + " disposable cups\n" +
                "$" + this.money + " of money\n";
    }
}
