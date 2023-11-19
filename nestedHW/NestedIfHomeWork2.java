package com.java.homeWork.nestedHW;

import java.util.Scanner;
import java.util.function.BinaryOperator;

public class NestedIfHomeWork2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please choose one of them: ");
        System.out.println("We have \n 1. Main Course\n 2. Appetizer\n 3. Drinks");
        System.out.println("if you want a \"Main Course\" input 1");
        System.out.println("if you want a \"Appetizer\" input 2");
        System.out.println("if you want a \"Drinks\" input 3");

        String order = scan.nextLine();

        if (order.equals("1")){
            System.out.println("1. Lagman\n2. NewYork Ribeye Steak");
            System.out.println("Please choose one of them: ");
            String meal = scan.next();
            if (meal.equalsIgnoreCase("Lagman")){
                System.out.println("Ingredients of Lagman: ");
            }
            else if (meal.equalsIgnoreCase("NewYork Ribeye Steak")){
                System.out.println("Ingredients of NewYork Ribeye Steak");
            }
           else {
                System.err.println("ERROR");
            }
        }
        else if (order.equals("2")){
            System.out.println("1. Spring Rolls\n2. Egg Rolls");
            System.out.println("Please can you choose one of them: ");
            String meal1 = scan.next();
            if (meal1.equalsIgnoreCase("SpringRolls")){
                System.out.println("Ingredients of Spring Rolls");
            }
            else if (meal1.equalsIgnoreCase("EggRolls")){
                System.out.println("Ingredients of Egg Rolls");
            }
            else {
                System.err.println("ERROR");
            }
        }
        else if (order.equals("3")){
            System.out.println("1. Orange Juice\n2. Apple Juice\n3. PineApple Juice");
            System.out.println("Please can you choose one of them:");
            String drink = scan.next();
            if (drink.equalsIgnoreCase("OrangeJuice")){
                System.out.println("Ingredients of Orange Juice");
            }
            else if (drink.equalsIgnoreCase("AppleJuice")){
                System.out.println("Ingredients of Apple Juice");
            }
            else if (drink.equalsIgnoreCase("PineAppleJuice")){
                System.out.println("Ingredients of PineApple Juice");
            }
            else{
                System.err.println("ERROR");
            }
        }
        else {
            System.err.println("Please order from our menu!");
        }

    }
}
