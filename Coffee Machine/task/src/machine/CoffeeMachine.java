package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Write how many cups of coffee you will need:");
        int coffe = s.nextInt();
        System.out.println("For " + coffe + " cups of coffee you will need:");
        System.out.println(200 * coffe + " ml of water \n" + 50 * coffe + " ml of milk\n" + 15 * coffe + " g of coffee beans");
    }
}
