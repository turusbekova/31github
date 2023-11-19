package com.java.homeWork.nestedHW;

import java.util.Scanner;

public class NestedSwitchHomeWork {
    public static void main(String[] args) {
        //        Homework switch statements 1: @channel
//        Write a program that takes a day of the week as input (e.g., “Monday”),
//        and outputs the number of days until the next weekend
//        (i.e., either Saturday or Sunday). Use a switch statement to implement
//        this program.
//                Sample outputs for input "Monday" would be "5" and input "Friday" would be "2"
//        2. Write a program that takes an operator (e.g., “+”, “-”, “*”, “/”)
//        and two integers as input, and outputs the result of the operation.
//        Use a switch statement to implement this program. Make sure to consider
//        the possibility of division by zero, and any other edge cases.
//        Sample outputs for input "+ 2 3" would be "5", input "/ 6 2" would be "3",
//                input "* 7 8" would be "56", if we have edge case input "/ 5 0"
//        would be "division by zero is not allowed" or similar message

 //       System.out.println("---------------------------------------------------");
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Please enter a day of the week:");
//        String day = scan.nextLine();
//        switch (day){
//            case "Monday":
//                System.out.println(5 + " days until a weekend");
//                break;
//            case "Tuesday":
//                System.out.println(4 + " days until a weekend");
//                break;
//            case "Wednesday":
//                System.out.println(3 + " days until a weekend");
//                break;
//            case "Thursday":
//                System.out.println(2 + " days until a weekend");
//                break;
//            case "Friday":
//                System.out.println(1 + " day until a weekend");
//                break;
//            case "Saturday":
//            case "Sunday":
//                System.out.println("That's the weekend");
//                break;
//            default:
//                System.err.println("Try again!");
//        }

       Scanner scan = new Scanner(System.in);
        System.out.println("Enter first number:");
        int num1 = scan.nextInt();
        System.out.println("Enter second number:");
        int num2 = scan.nextInt();
        System.out.println("Choose type of operator (e.g., “+”, “-”, “*”, “/”) ");
        String operator = scan.next();
        switch (operator){
            case "+":
                System.out.println("Result is " + (num1 + num2));
                break;
            case "-":
                System.out.println("Result is " + (num1 - num2));
                break;
            case "*":
                System.out.println("Result is " + (num1 * num2));
                break;
            case "/":
                if (num2 == 0){
                    System.err.println("division by zero is not allowed");
                }
                else {
                    System.out.println("Result is " + num1 / num2);
                }
                break;
            default:
                System.out.println("Invalid! Try again");
        }

    }
}
