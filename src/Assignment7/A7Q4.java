/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment7;

import java.util.Scanner;

/**
 *
 * @author chur7632
 */
public class A7Q4 {
    // calculate the balance after compound interest
    public static double compoundInterest(double P, double r, int n){
        // create the formula to calculate the balance
        // create the double B to represent the balance
        double B = P * Math.pow((1+r), n);
        return B;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create a new scanner
        Scanner in = new Scanner(System.in);
        
        // ask the person to enter the double represnting the initial principal (P)
        System.out.println("Please enter the initial principal:");
        double P = in.nextDouble();
        
        // ask the person to enter the double representing the interest rate as a decimal number (r)
        System.out.println("Please enter the interest rate:");
        double r = in.nextDouble();
        
        // ask the person to enter an integer representing the number of years (n)
        System.out.println("Please enter the number of years:");
        int n = in.nextInt();
        
        double B = compoundInterest(P, r, n);
        
        // output the balance after the compound interest calculations
        System.out.printf("Your balance after the compound interest is %.2f \n" , B + ".");
    }
}
