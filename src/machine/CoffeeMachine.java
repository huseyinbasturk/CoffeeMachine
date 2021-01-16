package machine;

import java.util.Scanner;

public class CoffeeMachine {

    Scanner sc = new Scanner(System.in);
    private int cupsInTheMachine = 9;
    int waterInTheMachine = 400;
    int milkInTheMachine  = 540;
    int coffeeBeansInTheMachine = 120;
    int moneyInTheMachine = 550;
    static CoffeeMachine coffeeMachine = new CoffeeMachine();
    boolean quit = false;
    boolean isWaterEnough;
    boolean isCoffeeEnough;
    boolean isMilkEnough;
    public static void main(String[] args) {
        coffeeMachine.writeAction();

    }

    public void writeAction() {

        while (!quit) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = sc.nextLine();
            System.out.println();
            coffeeMachine.implementAction(action);
        }



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
            case "remaining":
                remaining();
                break;
            case "exit":
                quit = true;
                break;

        }
    }

    public void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3- cappuccino, back - to main menu:");
        String input = sc.nextLine();

        switch(input) {
            case "1":
                makeEspresso();
                break;
            case "2":
                makeLatte();
                break;
            case "3":
                makeCappuccino();
                break;
            case "back":
                writeAction();
                break;

        }
    }

    public void makeEspresso() {
        if(checkIngredientsForEspresso(waterInTheMachine,coffeeBeansInTheMachine)) {
            waterInTheMachine -=250;
            coffeeBeansInTheMachine -=16;
            moneyInTheMachine +=4;
            cupsInTheMachine -=1;
        }


    }

    public void makeLatte() {
        if(checkIngredientsForLatte(waterInTheMachine,coffeeBeansInTheMachine, milkInTheMachine)) {
            waterInTheMachine -= 350;
            milkInTheMachine -= 75;
            coffeeBeansInTheMachine -= 20;
            moneyInTheMachine += 7;
            cupsInTheMachine -=1;
        }
    }

    public void makeCappuccino() {
        if(checkIngredientsForCappucino(waterInTheMachine,coffeeBeansInTheMachine, milkInTheMachine)) {
            waterInTheMachine -= 200;
            milkInTheMachine -= 100;
            coffeeBeansInTheMachine -= 12;
            moneyInTheMachine += 6;
            cupsInTheMachine -=1;
        }
    }

    public void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        int waterToAdd = sc.nextInt();
        sc.nextLine();
        System.out.println("Write how many ml of milk do you want to add:");
        int milkToAdd = sc.nextInt();
        sc.nextLine();
        System.out.println("Write how many grams of coffee beans do you want to add:");
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



    }

    public void take() {
        System.out.println("I gave you $" + moneyInTheMachine );
        moneyInTheMachine = 0;
        System.out.println();

    }

    public void remaining() {
        System.out.println("The coffee machine has:\n" +
                waterInTheMachine + " of water\n" +
                milkInTheMachine + " of milk\n" +
                coffeeBeansInTheMachine + " of coffee beans\n" +
                cupsInTheMachine + " of disposable cups");
        if(moneyInTheMachine != 0) {
            System.out.println("$" + moneyInTheMachine + " of money");
        } else {
            System.out.println(moneyInTheMachine + " of money");
        }
        System.out.println();
    }

    public boolean checkIngredientsForEspresso(int water, int coffee) {
        boolean coffeeIsOk = false;
        if(water >=250) {
            isWaterEnough = true;
        } else {
            isWaterEnough = false;
        }
        if(coffee >= 16) {
            isCoffeeEnough = true;
        } else {
            isCoffeeEnough = false;
        }

        if((isWaterEnough == true) && (isCoffeeEnough == true)) {
            System.out.println("I have enough resources, making you a coffee!");
            coffeeIsOk = true;
        } else if(isWaterEnough == false) {
            System.out.println("Sorry, not enough water!");
        } else {
            System.out.println("Sorry, not enough coffee beans!");
        }
        System.out.println();
        return coffeeIsOk;
    }

    public boolean checkIngredientsForLatte(int water, int coffee, int milk) {
        boolean coffeeIsOk = false;
        if(water >=350) {
            isWaterEnough = true;
        } else {
            isWaterEnough = false;
        }
        if(coffee >= 20) {
            isCoffeeEnough = true;
        } else {
            isCoffeeEnough = false;
        }
        if(milk >= 75) {
            isMilkEnough = true;
        } else {
            isMilkEnough = false;
        }

        if((isWaterEnough == true) && (isCoffeeEnough == true) && (isMilkEnough == true)) {
            System.out.println("I have enough resources, making you a coffee!");
            coffeeIsOk = true;
        } else if(isWaterEnough == false) {
            System.out.println("Sorry, not enough water!");
        } else if(isCoffeeEnough == false){
            System.out.println("Sorry, not enough coffee beans!");
        } else {
            System.out.println("Sorry, not enough milk!");
        }

        System.out.println();
        return coffeeIsOk;
    }

    public boolean checkIngredientsForCappucino(int water, int coffee, int milk) {
        boolean coffeeIsOk = false;
        if(water >=200) {
            isWaterEnough = true;
        } else {
            isWaterEnough = false;
        }
        if(coffee >= 12) {
            isCoffeeEnough = true;
        } else {
            isCoffeeEnough = false;
        }
        if(milk >= 100) {
            isMilkEnough = true;
        } else {
            isMilkEnough = false;
        }

        if((isWaterEnough == true) && (isCoffeeEnough == true) && (isMilkEnough == true)) {
            System.out.println("I have enough resources, making you a coffee!");
            coffeeIsOk = true;
        } else if(isWaterEnough == false) {
            System.out.println("Sorry, not enough water!");
        } else if(isCoffeeEnough == false){
            System.out.println("Sorry, not enough coffee beans!");
        } else {
            System.out.println("Sorry, not enough milk!");
        }

        System.out.println();
        return coffeeIsOk;
    }

}
