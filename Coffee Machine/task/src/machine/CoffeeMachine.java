package machine;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.min;

public class CoffeeMachine {
    final static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        result();


    }

    public static void result() {
        int water, milk, coffee, cup;
        System.out.println("Write how many ml of water the coffee machine has:");
        water = s.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        milk = s.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        coffee = s.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        cup = s.nextInt();

        int w = water / 200;
        int m = milk / 50;
        int c = coffee / 15;
        int minimum =min(w,min(m,c));

        if ((water / 200) == cup) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if ((water / 200) > cup)
            System.out.println("Yes, I can make that amount of coffee (and even " + (minimum - cup) + " more than that)");
        else if ((water / 200) < cup)
            System.out.println("No, I can make only " + w + " cup(s) of coffee");
    }

}
