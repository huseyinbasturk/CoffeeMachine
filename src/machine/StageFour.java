package machine;

import java.util.Scanner;

public class StageFour {
    Scanner sc = new Scanner(System.in);
    private int cupsInTheMachine = 9;
    int waterInTheMachine = 400;
    int milkInTheMachine  = 540;
    int coffeeBeansInTheMachine = 120;
    int moneyInTheMachine = 550;
    static CoffeeMachine coffeeMachine = new CoffeeMachine();
    public static void main(String[] args) {

        //coffeeMachine.state();
        //coffeeMachine.writeAction();

    }

    public void state() {
        System.out.println("The coffee machine has:\n" +
                waterInTheMachine + " of water\n" +
                milkInTheMachine + " of milk\n" +
                coffeeBeansInTheMachine + " of coffee beans\n" +
                cupsInTheMachine + " of disposable cups\n" +
                moneyInTheMachine + " of money");
        System.out.println();
    }

    public void writeAction() {
        System.out.println("Write action (buy, fill, take)");
        String action = sc.nextLine();
        coffeeMachine.implementAction(action);


    }

    public void implementAction(String input) {
        switch (input) {
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
        }
    }

    public void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3- cappuccino:");
        int input = sc.nextInt();
        sc.nextLine();
        cupsInTheMachine -=1;
        System.out.println();
        switch(input) {
            case 1:
                makeEspresso();
                break;
            case 2:
                makeLatte();
                break;
            case 3:
                makeCappuccino();
                break;

        }
    }

    public void makeEspresso() {
        waterInTheMachine -=250;
        coffeeBeansInTheMachine -=16;
        moneyInTheMachine +=4;
        state();

    }

    public void makeLatte() {
        waterInTheMachine -=350;
        milkInTheMachine -=75;
        coffeeBeansInTheMachine -=20;
        moneyInTheMachine +=7;
        state();
    }

    public void makeCappuccino() {
        waterInTheMachine -= 200;
        milkInTheMachine -= 100;
        coffeeBeansInTheMachine -= 12;
        moneyInTheMachine +=6;
        state();
    }

    public void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        int waterToAdd = sc.nextInt();
        sc.nextLine();
        System.out.println("Write how many ml of milk do you want to add:");
        int milkToAdd = sc.nextInt();
        sc.nextLine();
        System.out.println("Write how manygrams of coffee beans do you want to add:");
        int coffeeBeansToAdd = sc.nextInt();
        sc.nextLine();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int cupsToAdd = sc.nextInt();
        sc.nextLine();
        System.out.println();
        waterInTheMachine += waterToAdd;
        milkInTheMachine += milkToAdd;
        coffeeBeansInTheMachine += coffeeBeansToAdd;
        cupsInTheMachine += cupsToAdd;
        state();


    }

    public void take() {
        System.out.println("I gave you $" + moneyInTheMachine );
        moneyInTheMachine = 0;
        System.out.println();
        state();
    }

}
