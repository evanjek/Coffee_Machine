package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int mlWater = 400;
        int mlMilk = 540;
        int coffeeBeans = 120;
        int disposableCups = 9;
        int money = 550;

        coffeeMachineHas(mlWater, mlMilk, coffeeBeans, disposableCups, money);
        String action = action();
        if (action.equals("buy"))
            buy(mlWater, mlMilk, coffeeBeans, disposableCups, money);
        else if (action.equals("fill"))
            fill(mlWater, mlMilk, coffeeBeans, disposableCups, money);
        else if (action.equals("take"))
            take(mlWater, mlMilk, coffeeBeans, disposableCups, money);
    }

    private static void coffeeMachineHas(int mlwater, int mlmilk, int coffeeBeans, int disposableCups, int money) {
        System.out.println("The coffee machine has:");
        System.out.println(mlwater + " ml of water\n"
                + mlmilk + " ml of milk\n"
                + coffeeBeans + " g of coffee beans\n"
                + disposableCups + " disposable cups\n"
                + "$" + money + " of money");
    }

    private static String action() {
        System.out.println("\nWrite action (buy, fill, take):");
        String action = scanner.next();
        switch (action) {
            case "buy":
                break;
            case "fill":
                break;
            case "take":
                break;
            default:
                System.out.println("You have entered invalid action");
        }
        return action;
    }

    private static void buy(int mlwater, int mlmilk, int coffeeBeans, int disposableCups, int money) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int buy = scanner.nextInt();
        switch (buy) {
            case 1:
                mlwater -= 250;
                coffeeBeans -= 16;
                disposableCups -= 1;
                money += 4;
                break;
            case 2:
                mlwater -= 350;
                mlmilk -= 75;
                coffeeBeans -= 20;
                disposableCups -= 1;
                money += 7;
                break;
            case 3:
                mlwater -= 200;
                mlmilk -= 100;
                coffeeBeans -= 12;
                disposableCups -= 1;
                money += 6;
                break;
            default:
                System.out.println("You have entered invalid number");
        }
        System.out.println();
        coffeeMachineHas(mlwater, mlmilk, coffeeBeans, disposableCups, money);
    }

    private static void fill(int mlwater, int mlmilk, int coffeeBeans, int disposableCups, int money) {
        int mlwaterAdd, mlmilkAdd, coffeeBeansAdd, disposableCupsAdd;
        System.out.println("Write how many ml of water you want to add:");
        mlwaterAdd = scanner.nextInt();
        mlwater += mlwaterAdd;
        System.out.println("Write how many ml of milk you want to add:");
        mlmilkAdd = scanner.nextInt();
        mlmilk += mlmilkAdd;
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeansAdd = scanner.nextInt();
        coffeeBeans += coffeeBeansAdd;
        System.out.println("Write how many disposable cups of coffee you want to add:");
        disposableCupsAdd = scanner.nextInt();
        disposableCups += disposableCupsAdd;
        System.out.println();

        coffeeMachineHas(mlwater, mlmilk, coffeeBeans, disposableCups, money);


    }

    private static void take(int mlwater, int mlmilk, int coffeeBeans, int disposableCups, int money) {
        System.out.println("I gave you $" + money + "\n");
        money -= money;
        coffeeMachineHas(mlwater, mlmilk, coffeeBeans, disposableCups, money);
    }
}
