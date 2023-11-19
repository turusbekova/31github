package com.java.homeWork.nestedHW;

import java.util.Scanner;

public class NestedIfHomeWork3 {
    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Please enter weight of your item in lbs: ");
//        double weight = scan.nextDouble();
//        System.out.println("Please enter shipping country: ");
//        String country = scan.next();
//
//        if (weight < 2 && country.equalsIgnoreCase("USA")){
//            System.out.println("Your shipping cost is " + (weight * 5));
//        }
//        else {
//            if (weight >= 2 && country.equalsIgnoreCase("USA")){
//                System.out.println("Your shipping cost is " + (weight * 0.5));
//            }
//            else if (country != "USA"){
//                System.out.println("Your shopping cost is " + (weight * 1.5));
//            }
//            else {
//                System.err.println("ERROR");
//            }
//        }

        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter how much you want to loan: ");
        int loan = scan.nextInt();
        System.out.println("Please enter your credit score: ");
        double creditScore = scan.nextDouble();

        if (loan < 10000 && creditScore < 600){
            System.out.println("Your interest rate is 15%");
        }
        else {
            if (loan < 10000 && creditScore >= 600){
                System.out.println("Your interest rate is 10%");
            }
            else if (loan >= 10000 && creditScore < 600){
                System.out.println("Your interest rate is 12%");
            }
            else if (loan >= 10000 && creditScore >= 600 ){
                System.out.println("Your interest rate is 8%");
            }
            else {
                System.err.println("ERROR");
            }
        }

    }
}
