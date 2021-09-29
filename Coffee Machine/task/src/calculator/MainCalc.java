package calculator;


import java.util.Scanner;

public class MainCalc {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        Calculator c = null;

        //Intro
        System.out.println("Welcome to the universe calculator\n" +
                "Witch calculator do you need\n" +
                "1 - basic calculator\n" +
                "2 - advance calculator");

        int type = s.nextInt();
        if(type == 1)
            c = new Calculator();
        else if (type == 2)
            c = new AdvanceCac();

        System.out.println("How many numbers do you want to use\n" +
                "2\n" +
                "3");
        int number = s.nextInt();
        System.out.println("List of the operations: " + c.listOperations());
        if (number == 2) {
            //Input data
            System.out.println("Please set <a> <operation> <b>");
            c.setA(s.nextDouble());
            c.setOperation(s.next());
            c.setB(s.nextDouble());
            //Calculate
            System.out.println("Result is: " + c.calculateOperation2());
        }else if (number == 3){
            //Input data
            System.out.println("Please set <a> <operation> <b> <operation> <c>");
            c.setA(s.nextDouble());
            c.setOperation(s.next());
            c.setB(s.nextDouble());
            c.setOperation(s.next());
            c.setC(s.nextDouble());
            //Calculate
            System.out.println("Result is: " + c.calculateOperation3());
        }
    }

}
