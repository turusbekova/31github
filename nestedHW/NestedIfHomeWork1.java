package com.java.homeWork.nestedHW;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class NestedIfHomeWork1 {
    public static void main(String[] args) {
//        System.out.println("Enter three numbers: ");
//        System.out.println("First is ");
//        int n1 = scan.nextInt();
//        System.out.println("Second is ");
//        int n2 = scan.nextInt();
//        System.out.println("Third is ");
//        int n3 = scan.nextInt();
//         if (n1 > n2 && n1 > n3){
//             System.out.println(n1 + " - number is a largest");
//         }
//         else {
//             if (n2 > n1 && n2 > n1){
//                 System.out.println(n2 + " - number is a largest");
//             }
//             else if (n3 > n1 && n3 > n2){
//                 System.out.println(n3 + " - number is a largest");
//             }
//             else {
//                 System.err.println("Invalid");
//             }
//         }


        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter your age:");
        int age = scan.nextInt();
        System.out.println("Please enter your salary:");
        int salary = scan.nextInt();
        System.out.println("Please enter your loan amount:");
        int loanAmount = scan.nextInt();

        if (age >= 18){
            if (salary < 1000){
                System.out.println("Not Eligible");
            }
            else if (salary > 1001 && salary < 5000){
                System.out.println("Limit 10000");
            }
            else if (salary > 5001 && salary < 10000){
                System.out.println("Limit 20000");
            }
            else if (salary > 10001){
                System.out.println("Limit 50000");
            }
            if (loanAmount < 5000 ){
                System.out.println("No Deduction in Limit");
            }
            else {
                if (loanAmount > 20000){
                    System.out.println("Not Eligible");
                }
                else if (loanAmount > 5001 && loanAmount < 20000){
                    System.out.println("Deduct Half Of The Loan Amount From Credit Card Limit");
                }
            }
        }
        else {
            System.err.println("You are not Eligible");
        }
    }
}
