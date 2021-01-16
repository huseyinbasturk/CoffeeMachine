package machine;

import java.util.Scanner;

public class StageTwo {

    Scanner sc = new Scanner(System.in);
    static int cups;

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        //coffeeMachine.init();
        //coffeeMachine.calculateIngredient(cups);

    }

    public void init() {
        System.out.println("Write how many cups of coffee you will need:");
        cups = sc.nextInt();
        sc.nextLine();

    }

    public void calculateIngredient(int cups) {
        int water = cups * 200;
        int milk = cups * 50;
        int coffeeBeans = cups * 15;

        System.out.println("For " + cups + " cups of coffee you will need: \n" +
                water +" ml of water\n" +
                milk + " ml of milk\n" +
                coffeeBeans + " g of coffee beans");
    }
}

