package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);
    static int water = 400;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int cups = 9;
    static int money = 550;

    public static void showState() {
        System.out.printf("The coffee machine has:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans\n" +
                "%d disposable cups\n" +
                "$%d of money", water, milk, coffeeBeans, cups, money);
        System.out.println();
    }

    public static void buyCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String choice = scanner.next();
        if (choice.equals("back")) {
            return;
        }
        switch (choice) {
            case "1":
                if (water - 250 < 0) {
                    System.out.println("Sorry, not enough water!");
                    break;
                } else if (coffeeBeans - 20 < 0) {
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                } else if (cups - 1 < 0) {
                    System.out.println("Sorry, not enough cups!");
                    break;
                }
                water -= 250;
                coffeeBeans -= 16;
                money += 4;
                cups--;
                break;

            case "2":
                if (water - 350 < 0) {
                    System.out.println("Sorry, not enough water!");
                    break;
                } else if (milk - 70 < 0) {
                    System.out.println("Sorry, not enough milk!");
                    break;
                } else if (coffeeBeans - 20 < 0) {
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                } else if (cups - 1 < 0) {
                    System.out.println("Sorry, not enough cups!");
                    break;
                }
                water -= 350;
                milk -= 75;
                coffeeBeans -= 20;
                money += 7;
                cups--;
                break;
            case "3":
                if (water - 200 < 0) {
                    System.out.println("Sorry, not enough water!");
                    break;
                } else if (milk - 100 < 0) {
                    System.out.println("Sorry, not enough milk!");
                    break;
                } else if (coffeeBeans - 12 < 0) {
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                } else if (cups - 1 < 0) {
                    System.out.println("Sorry, not enough cups!");
                    break;
                }
                water -= 200;
                milk -= 100;
                coffeeBeans -= 12;
                money += 6;
                cups--;
                System.out.println("I have enough resources, making you a coffee!");
                break;
        }
    }

    public static void fillMachine() {
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        cups += scanner.nextInt();
    }

    public static void takeMoney() {
        int moneyCopy = money;
        money = 0;
        System.out.printf("I gave you $%d\n", moneyCopy);
    }

    public static int[] ingredientCalculator(int cups) {
        int water = 200;
        int milk = 50;
        int coffeeBeans = 15;
        return new int[]{water * cups, milk * cups, coffeeBeans * cups};
    }

    public static String estimateNumberOfCoffees() {
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffeeBeans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int neededAmount = scanner.nextInt();

        int amountFromWater = water / 200;
        int amountFromMilk = milk / 50;
        int amountFromBeans = coffeeBeans / 15;

        int maxAmount = Math.min(amountFromBeans, Math.min(amountFromWater, amountFromMilk));
        String result = maxAmount == neededAmount ?
                "Yes, I can make that amount of coffee": maxAmount > neededAmount ?
                String.format("Yes, I can make that amount of coffee (and even %d more than that)", maxAmount - neededAmount):
                String.format("No, I can make only %d cup(s) of coffee", maxAmount);
        return result;
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            String choice = scanner.next();
            System.out.println();
            if (choice.equals("exit")) {
                break;
            }
            switch (choice) {
                case "buy":
                    buyCoffee();
                    break;
                case "fill":
                    fillMachine();
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    showState();
                    break;
            }
        }
    }
}
