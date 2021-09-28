package machine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.Math.min;

public class CoffeeMachine {

    public static void main(String[] args) {

        int mlWater = 0, mlMilk = 0, coffeeBeans = 0, disposableCups = 0, money = 0;

        try {
            Scanner s = new Scanner(new File("doc/coffee_machine_status.txt"));
            if (s.hasNextLine()) {
                String data = s.nextLine();
                String[] fields = data.split("; ");
                mlWater = parseInt(fields[0]);
                mlMilk = parseInt(fields[1]);
                coffeeBeans = parseInt(fields[2]);
                disposableCups = parseInt(fields[3]);
                money = parseInt(fields[4]);

            } else {
                mlWater = 400;
                mlMilk = 540;
                coffeeBeans = 120;
                disposableCups = 9;
                money = 550;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        action(mlWater, mlMilk, coffeeBeans, disposableCups, money);

    }

    private static void coffeeMachineHas(int mlwater, int mlmilk, int coffeeBeans, int disposableCups, int money) {
        System.out.println("The coffee machine has:");
        System.out.println(mlwater + " ml of water");
        System.out.println(mlmilk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(disposableCups + " disposable cups");
        System.out.println("$" + money + " of money");
        action(mlwater, mlmilk, coffeeBeans, disposableCups, money);
    }


    private static void action(int mlWater, int mlMilk, int coffeeBeans, int disposableCups, int money) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
        String action = scanner.next();
        switch (action) {
            case "buy":
                buy(mlWater, mlMilk, coffeeBeans, disposableCups, money);
                break;
            case "fill":
                fill(mlWater, mlMilk, coffeeBeans, disposableCups, money);
                break;
            case "take":
                take(mlWater, mlMilk, coffeeBeans, disposableCups, money);
                break;
            case "exit":
                try {
                    FileWriter w = new FileWriter("doc/coffee_machine_status.txt");
                    w.write(String.format("%d; %d; %d; %d; %d", mlWater, mlMilk, coffeeBeans, disposableCups, money));
                    w.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return;
            case "remaining":
                coffeeMachineHas(mlWater, mlMilk, coffeeBeans, disposableCups, money);
                break;
            case "back":

            default:
                System.out.println("You have entered invalid action");
                action(mlWater, mlMilk, coffeeBeans, disposableCups, money);
                break;
        }
    }

    private static void buy(int mlwater, int mlmilk, int coffeeBeans, int disposableCups, int money) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String buy = scanner.next();
        int min;
        String enough = null;
        switch (buy) {
            case "1":
                if (mlwater > 250 && coffeeBeans > 16 && disposableCups > 1) {
                    mlwater -= 250;
                    coffeeBeans -= 16;
                    disposableCups -= 1;
                    money += 4;
                    System.out.println("I have enough resources, making you a coffee!");
                } else {
                    min = min(mlwater / 250, min(coffeeBeans / 16, disposableCups));
                    if (min == mlwater / 250)
                        enough = "water";
                    else if (min == mlmilk / 16)
                        enough = "milk";
                    else if (min == coffeeBeans)
                        enough = "coffee beans";
                    else if (min == disposableCups)
                        enough = "disposable cups";
                    System.out.println("Sorry, not enough" + enough + "!");
                }
                break;
            case "2":
                if (mlwater > 350 && mlmilk > 75 && coffeeBeans > 16 && disposableCups > 1) {
                    mlwater -= 350;
                    mlmilk -= 75;
                    coffeeBeans -= 20;
                    disposableCups -= 1;
                    money += 7;
                    System.out.println("I have enough resources, making you a coffee!");
                } else {
                    min = min(mlwater / 350, min(mlmilk / 75, min(coffeeBeans / 16, disposableCups)));
                    if (min == mlwater / 350)
                        enough = "water";
                    else if (min == mlmilk / 75)
                        enough = "milk";
                    else if (min == coffeeBeans / 16)
                        enough = "coffee beans";
                    else if (min == disposableCups)
                        enough = "disposable cups";
                    System.out.println("Sorry, not enough " + enough + "!");
                }
                break;
            case "3":
                if (mlwater > 200 && mlmilk > 100 && coffeeBeans > 12 && disposableCups > 1) {
                    mlwater -= 200;
                    mlmilk -= 100;
                    coffeeBeans -= 12;
                    disposableCups -= 1;
                    money += 6;
                    System.out.println("I have enough resources, making you a coffee!");
                } else {
                    min = min(mlwater / 200, min(mlmilk / 100, min(coffeeBeans / 12, disposableCups)));
                    if (min == mlwater / 200)
                        enough = "water";
                    else if (min == mlmilk / 100)
                        enough = "milk";
                    else if (min == coffeeBeans / 12)
                        enough = "coffee beans";
                    else if (min == disposableCups)
                        enough = "disposable cups";
                    System.out.println("Sorry, not enough" + enough + "!");
                }
                break;
            case "back":
                action(mlwater, mlmilk, coffeeBeans, disposableCups, money);
            default:
                System.out.println("You have entered invalid number");
                break;
        }
        action(mlwater, mlmilk, coffeeBeans, disposableCups, money);
    }

    private static void fill(int mlwater, int mlmilk, int coffeeBeans, int disposableCups, int money) {
        Scanner scanner = new Scanner(System.in);
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

        action(mlwater, mlmilk, coffeeBeans, disposableCups, money);


    }

    private static void take(int mlwater, int mlmilk, int coffeeBeans, int disposableCups, int money) {
        System.out.println("I gave you $" + money + "\n");
        money -= money;
        action(mlwater, mlmilk, coffeeBeans, disposableCups, money);
    }
}
