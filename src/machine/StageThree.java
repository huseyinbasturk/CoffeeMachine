package machine;

import java.util.Scanner;

public class StageThree {
    Scanner sc = new Scanner(System.in);
    static int cups;
    int waterInTheMachine;
    int milkInTheMachine;
    int coffeeBeansInTheMachine;

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        //coffeeMachine.init();
        //coffeeMachine.calculateIngredient(cups);

    }

    public void init() {
        System.out.println("Write how many ml of water the coffee machine has:");
        waterInTheMachine = sc.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        milkInTheMachine = sc.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        coffeeBeansInTheMachine = sc.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        cups =  sc.nextInt();
    }

    public void calculateIngredient(int cups) {
        int water = cups * 200;
        int milk = cups * 50;
        int coffeeBeans = cups * 15;

        int leftWater;
        int leftMilk;
        int leftCoffeBeans;
        int leftCup;

        int availableWater;
        int availableMilk;
        int availableCoffeeBeans;
        int availableCups;

        if(waterInTheMachine >= water && milkInTheMachine >= milk && coffeeBeansInTheMachine >=coffeeBeans) {
            leftWater = (waterInTheMachine - water) / 200;
            leftMilk = (milkInTheMachine - milk) / 50;
            leftCoffeBeans = (coffeeBeansInTheMachine - coffeeBeans) / 15;
            if(leftWater >=1 && leftMilk >= 1 && leftCoffeBeans >=1) {

                if (leftWater <= leftMilk && leftWater <= leftCoffeBeans) {
                    leftCup = leftWater;
                } else if (leftMilk <= leftCoffeBeans && leftMilk <= leftWater) {
                    leftCup = leftMilk;
                } else {
                    leftCup = leftCoffeBeans;
                }
                System.out.println("Yes, I can make that amount of coffee (and even " + leftCup + " more than that)");
            } else {
                System.out.println("Yes, I can make that amount of coffee");
            }
        } else {
            availableWater = waterInTheMachine / 200;
            availableMilk = milkInTheMachine / 50;
            availableCoffeeBeans = coffeeBeansInTheMachine / 15;
            if (availableWater <= availableMilk & availableWater <= availableCoffeeBeans) {
                availableCups = availableWater;

            } else if (availableMilk <= availableCoffeeBeans & availableMilk <= availableWater) {
                availableCups = availableMilk;

            } else {
                availableCups = availableCoffeeBeans ;
            }
            System.out.println("No, I can make only " + availableCups + " cup(s) of coffee");

        }


    }
}

