package machine;

public class CoffeeType {
    private String name;
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private int money;

    public CoffeeType(String s, int i, int i1, int i2, int i3, int i4) {
        this.name = s;
        this.water = i;
        this.milk = i1;
        this.coffeeBeans = i2;
        this.disposableCups = i3;
        this.money = i4;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public int getDisposableCups() {
        return disposableCups;
    }

    public int getMoney() {
        return money;
    }
}
