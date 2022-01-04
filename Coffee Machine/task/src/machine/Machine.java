package machine;

import java.util.Scanner;

public class Machine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private int money;

    Machine() {
        water = 400;
        milk = 540;
        coffeeBeans = 120;
        disposableCups = 9;
        money = 550;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public void setCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans = coffeeBeans;
    }

    public int getDisposableCups() {
        return disposableCups;
    }

    public void setDisposableCups(int disposableCups) {
        this.disposableCups = disposableCups;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    CoffeeType espresso = new CoffeeType("espresso", 250, 0, 16, 1, 4);
    CoffeeType latte = new CoffeeType("latte", 350, 75, 20, 1, 7);
    CoffeeType cappuccino = new CoffeeType("cappuccino", 200, 100, 12, 1, 6);

    Scanner scanner = new Scanner(System.in);

    void buyCoffeeType(CoffeeType coffeeType) {
        this.setWater(this.getWater() - coffeeType.getWater());
        this.setMilk(this.getMilk() - coffeeType.getMilk());
        this.setCoffeeBeans(this.getCoffeeBeans() - coffeeType.getCoffeeBeans());
        this.setDisposableCups(this.getDisposableCups() - coffeeType.getDisposableCups());
        this.setMoney(this.getMoney() + coffeeType.getMoney());

        mainMenuCoffeeMachine();
    }

    void printStateOfCoffeeMachine() {
        System.out.println("" +
                "The coffee machine has:\n" +
                this.water + " ml of water\n" +
                this.milk + " ml of milk\n" +
                this.coffeeBeans + " g of coffee beans\n" +
                this.disposableCups + " disposable cups\n" +
                "$" + this.money + " of money");
        mainMenuCoffeeMachine();
    }

    private void takeCoffeeMachine() {

        System.out.printf("I gave you $%d", this.money);
        System.out.println("\n");
        this.setMoney(0);

        mainMenuCoffeeMachine();
    }

    private void fillCoffeeMachine() {

        System.out.println("Write how many ml of water you want to add: ");
        this.setWater(scanner.nextInt() + this.getWater());

        System.out.println("Write how many ml of milk you want to add: ");
        this.setMilk(scanner.nextInt() + this.getMilk());

        System.out.println("Write how many grams of coffee beans you want to add: ");
        this.setCoffeeBeans(scanner.nextInt() + this.getCoffeeBeans());

        System.out.println("Write how many disposable cups of coffee you want to add: ");
        this.setDisposableCups(scanner.nextInt() + this.getDisposableCups());

        mainMenuCoffeeMachine();
    }

    private void checkIngredientCoffeeMachine(CoffeeType coffeeType) {

        if ((this.water - coffeeType.getWater()) <= 0) {
            System.out.println("Sorry, not enough water!");
            mainMenuCoffeeMachine();
        } else {
            if ((this.milk - coffeeType.getMilk()) <= 0) {
                System.out.println("Sorry, not enough milk!");
                mainMenuCoffeeMachine();
            } else {
                if ((this.coffeeBeans - coffeeType.getCoffeeBeans()) <= 0) {
                    System.out.println("Sorry, not enough coffee beans!");
                    mainMenuCoffeeMachine();
                } else {
                    if ((this.disposableCups - coffeeType.getDisposableCups()) <= 0) {
                        System.out.println("Sorry, not enough disposable cups!");
                        mainMenuCoffeeMachine();
                    } else {
                        System.out.println("I have enough resources, making you a coffee!");
                        buyCoffeeType(coffeeType);
                    }
                }
            }
        }
    }

    void mainMenuCoffeeMachine() {

        System.out.println("\n" +
                "Write action (buy, fill, take, remaining, exit): ");
        switch (scanner.next()) {
            case "buy": {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                switch (scanner.next()) {
                    case "1": { checkIngredientCoffeeMachine(this.espresso); }
                    case "2": { checkIngredientCoffeeMachine(this.latte); }
                    case "3": { checkIngredientCoffeeMachine(this.cappuccino); }
                    default: mainMenuCoffeeMachine();
                }
            }
            case "fill": {
                fillCoffeeMachine();
            }
            case "take": {
                takeCoffeeMachine();
            }
            case "remaining": {
                printStateOfCoffeeMachine();
            }
            default: System.exit(0);
        }
    }
}